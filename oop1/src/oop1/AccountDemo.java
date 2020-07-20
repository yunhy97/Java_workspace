package oop1;

public class AccountDemo {

	public static void main(String[] args) {
		//클래스변수 사용하기
		//클래스 변수는 "클래스명.변수명"의 형태이고 객체 생성과 상관없이 사용가능.
		System.out.println("금리: " + Account.RATE_OF_INTEREST);
		
		Account acc1 = new Account();
		acc1.owner="홍길동";
		acc1.no="110-23456-78-912";
		acc1.password="1234";
		acc1.balance = 20000000;
		acc1.period = 24;
		
		Account acc2 = new Account();
		acc2.owner="김유신";
		acc2.no="110-987456-23-654";
		acc2.password="5678";
		acc2.balance = 65000000;
		acc2.period = 27;
		
		//해지환급금 계산하기
		//해지환급금 = 잔액+(잔액*금리*개월수/12)
		long money1 = acc1.balance + (long)(acc1.balance*Account.RATE_OF_INTEREST*acc1.period/12);
		long money2 = acc2.balance + (long)(acc2.balance*Account.RATE_OF_INTEREST*acc2.period/12);
		
		System.out.println("첫번째 계좌의 해지환급금: " + money1);
		System.out.println("두번째 계좌의 해지환급금: " + money2);
		
	}
}
