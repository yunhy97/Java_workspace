package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.User;

public class UserDAO {

	/**
	 * 사용자를 추가한다.
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception{
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.addUser"));
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	/**
	 * 지정된 아이디에 해당하는 사용자정보를 반환한다.
	 * @param userId
	 * @return
	 */
	public User getUserById(String userId) throws Exception {
		User user = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getUserById"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			user = resultSetToBook(rs);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return user;
	}
	
	public void updateUser(User user) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.updateUser"));
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getEmail());
		pstmt.setInt(3, user.getPoint());
		pstmt.setString(4, user.getId());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	private User resultSetToBook(ResultSet rs) throws Exception {
		User user = new User();
		user.setId(rs.getString("user_id"));
		user.setPassword(rs.getString("user_password"));
		user.setName(rs.getString("user_name"));
		user.setEmail(rs.getString("user_email"));
		user.setPoint(rs.getInt("user_point"));
		user.setRegisteredDate(rs.getDate("user_registered_date"));
		
		return user;
	}
}
