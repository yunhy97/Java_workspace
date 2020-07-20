package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Review;
import com.sample.bookstore.vo.User;

public class ReviewDAO {

	public void addReview(Review review) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.addReview"));
		pstmt.setString(1, review.getContent());
		pstmt.setInt(2, review.getBook().getNo());
		pstmt.setString(3, review.getUser().getId());
		pstmt.setInt(4, review.getPoint());
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();
	}
	
	public Review getReview(int reviewNo) throws SQLException {
		Review review = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.getReview"));
		pstmt.setInt(1, reviewNo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			review = resultSetToReview(rs);
		}
		rs.close();
		connection.close();
		pstmt.close();
		
		return review; 
	}
	private Review resultSetToReview(ResultSet rs) throws SQLException {
		Review review = new Review();
		review.setNo(rs.getInt("review_no"));
		review.setContent(rs.getString("review_content"));
		review.setPoint(rs.getInt("review_point"));
		review.setRegisteredDate(rs.getDate("review_registered_date"));
		
		Book book = new Book();
		book.setNo(rs.getInt("book_no"));
		
		User user = new User();
		user.setId(rs.getString("user_id"));
		
		review.setBook(book);
		review.setUser(user);
		
		return review;
	}
}
