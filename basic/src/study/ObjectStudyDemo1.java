package study;

import java.util.Scanner;

public class ObjectStudyDemo1 {

	public static void main(String[] args) {
		
		ObjectStudyService1 oss1 = new ObjectStudyService1();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println();
			System.out.println("[택배 배송 관리]");
			System.out.println("=====================================");
			System.out.println("1.배송정보등록 2.수령자확인  3.배송정보확인  4.등록정보확인   5.종료");
			System.out.println("=====================================");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = sc.nextInt();
			
			if(menuNo == 1) {
				System.out.println("<배송정보 등록하기>");
				System.out.print("ID를 입력하세요: ");
				String ID = sc.next();
				System.out.print("수령자명을 입력하세요: ");
				String name = sc.next();
				System.out.print("주소지를 입력하세요: ");
				String address = sc.next();
				System.out.print("택배수량을 입력하세요: ");
				int stock = sc.nextInt();
				
				ObjectStudy1 os1 = new ObjectStudy1(ID, name, address, stock, false);
				oss1.insertNewInfo(os1);
				System.out.println("### 배송정보가 등록되었습니다.");
			}else if(menuNo == 2) {
				System.out.println("<수령자 확인하기>");
				System.out.print("ID를 입력하세요: ");
				String ID = sc.next();
				System.out.print("수령자명을 입력하세요: ");
				String name = sc.next();
				
				oss1.checkSentByID(ID, name);
				System.out.println("### 배송되었습니다.");
			}else if(menuNo == 3) {
				System.out.println("<배송정보 확인하기>");
				System.out.print("ID를 입력하세요: ");
				String ID = sc.next();
				
				oss1.printInfoByID(ID);
				
			}else if(menuNo == 4) {
				System.out.println("<등록정보 확인하기>");
				
				oss1.printAllInfo();
				
			}else if(menuNo == 5) {
				System.out.println("<시스템 종료>");
				break;
			}
		}
	}
}
