package com.sample.bookstore.vo;

public class Rental {			//대여정보를 담는 클래스를 정의

	public int no;
	public int userNo;
	public int bookNo;
	public boolean isRent;		//true : 대여중, false : 반납완료
	
	public Rental() {
		
	}
	
	public Rental(int no, int userNo, int bookNo, boolean isRent) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.bookNo = bookNo;
		this.isRent = isRent;
	}
	
	
}
