package com.sample.school.vo;

import java.sql.Date;

public class Coursehistory {
//수강신청내역: 번호, 과정번호, 학생번호, 취소여부, 수료여부, 점수, 등록일
	
	private int no;
	private Course course;
	private Student student;
	private boolean isCancle;
	private boolean isPassed;
	private int score;
	private Date registeredDate;
	
	public Coursehistory() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public boolean isCancle() {
		return isCancle;
	}

	public void setCancle(boolean isCancle) {
		this.isCancle = isCancle;
	}

	public boolean isPassed() {
		return isPassed;
	}

	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	
	
}
