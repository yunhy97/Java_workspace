package oop2;

import java.util.Scanner;

//UI(User Interface), 서비스클래스와 사용자 사이를 연결해주는 다리역할.
public class BankingDemo3 {

	public static void main(String[] args) {
		
		BankingService service = new BankingService();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println();
			System.out.println("[계좌관리 프로그램]");
			System.out.println("---------------------------------");
			System.out.println("1.조회 2.검색 3.신규 4.입금 5.출금 6.해지 0.종료");
			System.out.println("---------------------------------");
			
			System.out.println("메뉴를 선택하세요: ");
			int menuNo = sc.nextInt();
			
			if(menuNo == 1) {
				service.printAllBankings();
				
			}else if(menuNo == 2) {
				System.out.print("조회할 계좌번호를 입력하세요: ");
				String searchNo = sc.next();
				
				service.printBankingByNo(searchNo);
				
			}else if(menuNo == 3) {
				System.out.println("신규 계좌개설에 필요한 정보를 입력해주세요.");
				System.out.print("이름을 입력하세요: ");
				String name = sc.next();
				System.out.print("비밀번호를 입력하세요: ");
				int pwd = sc.nextInt();
				System.out.print("첫 입금액을 입력하세요: ");
				long money=sc.nextLong();
				
				service.addNewBanking(name, pwd, money);
				
			}else if(menuNo == 4) {
				System.out.println("계좌번호를 입력하세요: ");
				String no = sc.next();
				System.out.println("입금액을 입력하세요: ");
				long money = sc.nextLong();
				
				service.depositBanking(no, money);
				
			}else if(menuNo == 5) {
				System.out.println("계좌번호를 입력하세요: ");
				String no = sc.next();
				System.out.print("비밀번호를 입력하세요: ");
				int pwd = sc.nextInt();
				System.out.println("출금액을 입력하세요: ");
				long money = sc.nextLong();
				
				long withdraw = service.withdrawFromBanking(no, pwd, money);
				System.out.println("고객님 [" + withdraw + "]원을 가져가세요.");
				
			}else if(menuNo == 6) {
				System.out.println("계좌번호를 입력하세요: ");
				String no = sc.next();
				System.out.print("비밀번호를 입력하세요: ");
				int pwd = sc.nextInt();
				
				long money = service.closeBanking(no, pwd);
				System.out.println("고객님 총해지금액 [" +money+"]원을 가져가세요.");
			
			}else if(menuNo == 0) {
				System.out.println("[프로그램을 종료]");
				break;
			}
			
		}
	}
}
