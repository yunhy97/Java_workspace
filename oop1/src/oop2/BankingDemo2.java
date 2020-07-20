package oop2;

import java.util.Scanner;

public class BankingDemo2 {

	public static void main(String[] args) {
		Banking[] bank = new Banking[100];
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println();
			System.out.println("[계좌정보 관리 프로그램]");
			System.out.println("===================================================");
			System.out.println("1.신규	2.조회	3.입금	4.출금	5.비번변경	6.해지	0.종료");
			System.out.println("===================================================");
			
			System.out.println("메뉴를 입력하세요: ");
			int menuNo = sc.nextInt();
			
			if(menuNo == 1) {
				
			} else if(menuNo == 2) {
				
			} else if(menuNo == 3) {
				
			} else if(menuNo == 4) {
				
			} else if(menuNo == 5) {
				
			} else if(menuNo == 6) {
				
			} else if(menuNo == 0) {
				
			}
		}
	}
}
