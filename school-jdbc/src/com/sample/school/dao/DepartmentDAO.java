package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.vo.Department;

public class DepartmentDAO {

	//학과등록
	public void addDept(Department dept) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		//PreparedStatement pstmt
	}
	//전체학과조회
	
	//학과상세조회
	
}
