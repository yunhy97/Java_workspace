package oop2;

public class BankingDemo {

	public static void main(String[] args) {
		Banking ba = new Banking();
		
		ba.name = "홍길동";
		ba.no = "11-110-1234";
		ba.password = 1234;
		ba.balance = 2000000;
		ba.period = 6;			//개월수
		
		//현재 계좌정보 조회
		ba.display();
		
		//입금하기
		ba.deposit(500000);
		ba.display();
		
		//출금하기
		//long money1 = ba.withdraw(50000, 1111);
		long money1 = ba.withdraw(50000, 1234);
		System.out.println("출금액: " + money1);
		ba.display();
		
		//비밀번호 변경
		ba.changePwd(1234, 5678);
		System.out.println("현재 비밀번호: "+ ba.password);
		System.out.println();
		
		//해지
		long money2 = ba.close(5678);
		System.out.println("최종 해지금액: " + money2);
		System.out.println();
		ba.display();
		
	}
}
