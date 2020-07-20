package oop2;

import java.util.Scanner;

import oop1.Score;

public class StudentDemo {

	public static void main(String[] args) {
		Student[] st = new Student[100];
		Scanner sc=new Scanner(System.in);
		int savePosition = 0;
		
		while(true) {
			
			System.out.println();
			System.out.println("[학생정보 관리 프로그램]");
			System.out.println("=========================================");
			System.out.println("1.조회	2.검색	3.입력	0.종료");
			System.out.println("=========================================");
			
			System.out.println("메뉴를 입력하세요: ");
			int menuNo = sc.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[학생정보 조회]");
				
				System.out.println("학생이름\t반\t번호\t국어\t영어\t수학\t총점\t평균");
				System.out.println("=================================");
				
				for(int i=0; i<savePosition; i++) {
					Student st1 =  st[i];
					st1.displayStudentInfoForRow();
				}
			} else if(menuNo == 2) {
					System.out.println("[학생정보 검색]");
				
				System.out.print("검색할 학생이름을 입력하세요 : ");
				String searchName = sc.next();
				/*
				 boolean isFound = false;
				 for(int i=0; i<savePosition; i++) {
					Student st2 = st[i];
					if(searchName.equals(st2.studentName)) {
						st2.display();
						isFound=true;
					}
				 }
				 if(!isFound) {
				 	System.out.println("입력한 이름과 일치하는 정보를 찾을 수 없습니다.");
				 }
				 */
				Student foundSt = null;		
				for(int i=0; i<savePosition; i++) {
					Student st2 = st[i];
					if(searchName.equals(st2.studentName)) {
						foundSt = st2;
						break;
					}
				}
				if(foundSt != null) {
					foundSt.display();
				} else {
					System.out.println("[" + searchName + "]과 일치하는 학생정보가 존재하지 않습니다.");
				}
				
			} else if(menuNo == 3) {
				System.out.println("[학생정보 입력]");
				
				System.out.print("이름을 입력하세요: ");
				String name = sc.next();
				System.out.print("반을 입력하세요: ");
				int classes = sc.nextInt();
				System.out.print("번호를 입력하세요: ");
				int no = sc.nextInt();
				System.out.print("국어점수를 입력하세요: ");
				int korea = sc.nextInt();
				System.out.print("영어점수를 입력하세요: ");
				int english = sc.nextInt();
				System.out.print("수학점수를 입력하세요: ");
				int math = sc.nextInt();
			
				Student st3 = new Student();
				
				st3.studentName = name;
				st3.classes = classes;
				st3.studentNum = no;
				st3.kor = korea;
				st3.eng = english;
				st3.math = math;
				int total = st3.classTotal();
				int avg = st3.classAvg();
				
				st[savePosition]=st3;
				savePosition++;
			} else if(menuNo == 0) {
				System.out.println("[프로그램을 종료]");
				break;
			}
		}
	}
}
