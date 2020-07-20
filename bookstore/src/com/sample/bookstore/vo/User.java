package com.sample.bookstore.vo;

import com.sample.bookstore.service.UserService;

public class User {			//고객정보를 담는 클래스를 정의

	public int no;				//1001, 1002, ....
	public String name;
	public String tel;
	public int point;
	public boolean isDisabled;		//탈퇴여부, false : 사용가능 고객, true : 탈퇴처리된 고객
	
	public User() {
		
	}
	
	public User(int no, String name, String tel, int point, boolean isDisabled) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.point = point;
		this.isDisabled = isDisabled;
	}

	
	
}
