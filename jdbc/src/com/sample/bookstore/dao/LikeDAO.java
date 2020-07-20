package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Like;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.Review;
import com.sample.bookstore.vo.User;

public class LikeDAO {
	
	public void addLike(Like like) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("like.addLike"));
		pstmt.setInt(1, like.getBook().getNo());
		pstmt.setString(2, like.getUser().getId());
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();
		
	}
	
	public Like countReviewByNo(int book_no) throws SQLException {
		Like like = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("like.countLike"));
		pstmt.setInt(1, book_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			like = resultSetToLike(rs);
		}
		connection.close();
		pstmt.close();
		rs.close();
		return like;
	}
	private Like resultSetToLike(ResultSet rs) throws SQLException {
		Like like = new Like();
		Book book = new Book();
		book.setNo(rs.getInt("book_no"));
		
		User user = new User();
		user.setId(rs.getString("user_id"));
		
		like.setBook(book);
		like.setUser(user);
		
		
		return like;
	}
}
