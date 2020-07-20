package com.sample.school.vo;

import java.sql.Date;

public class Subject {
//	과목: 번호, 과목명, 학과번호, 등록일
	private int no;
	private String subjectName;
	private Department dept;
	private Date registeredDate;
	
	public Subject() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	
	
}
