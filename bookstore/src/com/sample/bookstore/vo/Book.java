package com.sample.bookstore.vo;

public class Book {		//도서정보를 담는 클래스를 정의

	public int no;				//2001,2002, ....
	public String title;
	public String writer;
	public int price;
	public int stock;
	
	public Book() {
		
	}
	public Book(int no, String title, String writer, int price, int stock) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.price = price;
		this.stock = stock;
	}
	
	
}
