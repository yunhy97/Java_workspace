package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Answer;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.User;

public class QuestionDAO {

	public void addQuestion(Question question) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.addQuestion"));
		pstmt.setString(1, question.getUser().getId());
		pstmt.setString(2, question.getTitle());
		pstmt.setString(3, question.getContent());
		pstmt.setString(4, question.getType());
		 pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();

	}
	
	public List<Question> getAllQuestions() throws SQLException {
		List<Question> questions = new ArrayList<Question>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.getAllQuestions"));
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			questions.add(this.resultSetToBook(rs));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		return questions;
	}
	
	public Question getQuestionByNo(int questionNo) throws SQLException {
		Question question = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.getQuestionByNo"));
		pstmt.setInt(1, questionNo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			question = resultSetToBook(rs);
		}
		rs.close();
		connection.close();
		pstmt.close();
		return question;
	}
	public void updateQuestion(Question question) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.updateQuestion"));
		pstmt.setString(1, question.getTitle());
		pstmt.setString(2, question.getContent());
		pstmt.setInt(3, question.getViewCount());
		pstmt.setString(4, question.getStatus());
		pstmt.setString(5, question.getType());
		pstmt.setInt(6, question.getNo());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();		
	}
	
	public void removeQuestion(int questionNo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.removeQuestion"));
		pstmt.setInt(1, questionNo);
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();
		
	}
	
	private Question resultSetToBook(ResultSet rs) throws SQLException {
		Question question = new Question();
		question.setNo(rs.getInt("question_no"));
		question.setTitle(rs.getString("question_title"));
		question.setContent(rs.getString("question_content"));
		question.setViewCount(rs.getInt("question_view_count"));
		question.setStatus(rs.getString("question_status"));
		question.setRegisteredDate(rs.getDate("question_registered_date"));
		question.setType(rs.getString("question_type"));
		
		
		User user = new User();
		user.setId(rs.getString("user_id"));
		
		question.setUser(user);
		
		
		return question;
	}
}
