package com.sample.school.service;

import java.util.List;

import com.sample.school.dao.CourseDAO;
import com.sample.school.dao.CoursehistoryDAO;
import com.sample.school.dao.DepartmentDAO;
import com.sample.school.dao.ProfessorDAO;
import com.sample.school.dao.StudentDAO;
import com.sample.school.dao.SubjectDAO;
import com.sample.school.vo.Course;
import com.sample.school.vo.Coursehistory;
import com.sample.school.vo.Subject;

public class SchoolService {

	CourseDAO courseDao = new CourseDAO();
	SubjectDAO subjectDao = new SubjectDAO();
	StudentDAO studentDao = new StudentDAO();
	ProfessorDAO professorDao = new ProfessorDAO();
	CoursehistoryDAO historyDao = new CoursehistoryDAO();
	DepartmentDAO departmentDao = new DepartmentDAO();
	
	//교수전용
	public boolean 과목등록(Subject subject, int departmentNo) {
		return true;
	}
	
	public List<Subject> 과목조회(String subjectName) {
		return null;
	}
	
	public List<Course> 교수과정목록조회(int professorNo) {
		return null;
	}
	
	public Course 과정상세조회(int courseNo) {
		return null;
	}
	
	public boolean 과정등록(Course course, int subjectNo, int professorNo) {
		return true;
	}
	
	//학생전용
	
	public List<Course> 학생과정목록조회(int studentNo) {
		return null;
	}
	
	//보류
	public boolean 수강신청 (int courseNo, int studentNo, Coursehistory history) {
		return true;
	}
	
	//보류
	public void 수강취소() {
		
	}
	
	public List<Coursehistory> 수강신청내역조회(int studentNo){
		return null;
	}
	
}
