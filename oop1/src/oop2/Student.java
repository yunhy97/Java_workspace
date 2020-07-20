package oop2;

public class Student {

	String studentName;
	int classes;
	int studentNum;
	int kor;
	int eng;
	int math;
	
	int classTotal() {
		return kor+eng+math;
	}
	
	int classAvg () {
		int total = classTotal();
		return total/3;
	}
	
	void display(){ 
		System.out.println("----------학생정보----------");
		System.out.println("학생이름: " + studentName);
		System.out.println("      반: " + classes);
		System.out.println("번    호: " + studentNum);
		System.out.println("국어점수: " + kor);
		System.out.println("영어점수: " + eng);
		System.out.println("수학점수: " + math);
		System.out.println("총    점: " + classTotal());
		System.out.println("평    균: " + classAvg());
		System.out.println("---------------------------");
	}
	
	void displayStudentInfoForRow() {
		System.out.print(studentName+ "\t");
		System.out.print(classes+ "\t");
		System.out.print(studentNum+ "\t");
		System.out.print(kor+ "\t");
		System.out.print(eng+ "\t");
		System.out.print(math+ "\t");
		System.out.print(classTotal()+ "\t");
		System.out.println(classAvg()+ "\t");
	}
}
