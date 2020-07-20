package com.sample.bookstore.service;

import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Rental;
import com.sample.bookstore.vo.User;

public class BookstoreService {

	BookService bookService = new BookService();
	UserService userService = new UserService();
	RentalService rentalService = new RentalService();
	
	// end회원등록 서비스
	// 이름, 전화번호를 전달받아서 회원등록 서비스를 제공한다.
	// 		- User객체를 생성해서 이름과 전화번호를 저장한다.
	//		- 회원등록시 100포인트를 지급한다.
	//		- UserService의 회원등록 기능을 실행한다.
	public void addNewUser(String name, String tel) {
		User user = new User();
		user.name = name;
		user.tel = tel;
		user.point = 100;
		user.isDisabled = false;
		
		userService.insertUser(user);
	}
	
	// end회원조회 서비스
	// 회원번호를 전달받아서 회원번호에 대한 회원정보를 화면에 출력한다.
	//		- UserService의 회원조회기능을 실행해서 회원정보를 제공받는다.
	//		- 조회된 회원정보를 화면에 출력한다.
	public void retrieveUserInfo(int userNo) {
		
		System.out.println("=========================================");
		System.out.println("회원번호\t회원명\t전화번호\t\t포인트\t탈퇴여부");
		System.out.println("=========================================");
		
		
		User user1  = userService.findUserByNo(userNo);
		if (user1 == null) {
			System.out.println("회원정보를 찾지 못했습니다.");
			return;
		}
		System.out.print(user1.no + "\t");
		System.out.print(user1.name + "\t");
		System.out.print(user1.tel + "\t");
		System.out.print(user1.point + "\t");
		System.out.print(user1.isDisabled+ "\t");
	}
	
	//대여현황조회(추가기능)
	//회원번호를 입력받아서 그 고객이 대여중인 모든 책정보(책번호, 제목, 가격, 대여상태) 출력하기
	//다
	public void rentUserInfo(int userNo) {
		System.out.println("=========================================");
		System.out.println("도서번호\t도서명\t가격\t\t대여상태");
		System.out.println("=========================================");
		
		
		Rental rent1 = rentalService.findRentalByNo(userNo);
		Book book1 = bookService.findBookByNo(rent1.bookNo);
		
		if (rent1 == null || book1 == null) {
			System.out.println("정보를 찾지 못했습니다.");
		} else {
			
		
		System.out.print(book1.no+ "\t");
		System.out.print(book1.title+ "\t");
		System.out.print(book1.price+ "\t");
		System.out.println(rent1.isRent);	
		}
	}
	//end회원번호, 이름, 전화번호를 입력받아서 User객체를 생성해서 저장하고 
	//BookstoreService의 회원정보변경 서비스에 전달해서 회원정보를 변경하게 한다.
	// 회원수정 서비스
	// 수정할 회원정보를 전달받아서 해당 회원의 정보를 수정한다.
	//		- UserService의 회원정보 변경기능을 실행해서 회원정보를 수정한다.
	public void modifyUserInfo(User user) {
		userService.findUserByNo(user.no);
		
	}
	
	//end회원번호를 입력받아서 BookstoreService의 회원탈퇴 서비스에 전달해서 탈퇴처리 한다.
	// 회원탈퇴 서비스
	// 탈퇴처리할 회원번호를 전달받아서 해당 회원을 탈퇴처리한다.
	//		- UserService의 회원조회기능을 실행해서 회원정보를 제공받는다.
	//		- 조회된 회원의 탈퇴여부를 탈퇴처리로 변경한다.
	//		- RentalService의 반납기능을 실행해서 해당 회원이 대여중인 모든 책을 반납처리한다.
	public void disabledUser(int userNo) {
		User result = userService.findUserByNo(userNo);
		
		if(result != null) {
			result.isDisabled = true;
			System.out.println("탈퇴되었습니다.");
			
		} else {
			System.out.println("회원번호가 일치하지 않습니다.");
		}
	}
	
	// end전체 회원조회 서비스
	// 등록된 모든 회원정보 조회를 처리한다.
	// 		- UserService의 모든 회원정보 조회기능을 실행해서 모든 회원정보를 제공받는다.
	//		- 조회된 회원정보를 화면에 출력한다.
	public void retrieveAllUsers() {
		System.out.println("=========================================");
		System.out.println("회원번호\t회원명\t전화번호\t포인트\t탈퇴여부");
		System.out.println("=========================================");
		
		User[] user = userService.getAllUsers();
		
		for(int i=0; i<user.length; i++) {
			if (user[i] == null) {
				break;
			}
			System.out.print(user[i].no + "\t");
			System.out.print(user[i].name + "\t");
			System.out.print(user[i].tel + "\t");
			System.out.print(user[i].point + "\t");
			System.out.println(user[i].isDisabled+ "\t");
		}
	}
	
	// end BookstoreService에 신규도서등록서비스에 전달한다.
	// 도서등록 서비스
	// 제목, 저자, 가격을 전달받아서 도서 등록 서비스를 처리한다.
	//		- Book객체를 생성해서 제목, 저자, 가격 정보를 저장한다.
	//		- 재고는 10000권으로 한다.
	// 		- BookService의 도서등록기능을 실행한다.
	public void insertNewBook(String title, String writer, int price) {
		Book book = new Book();
		
		book.title = title;
		book.writer = writer;
		book.price = price;
		book.stock = 10000;
		
		bookService.insertBook(book);
	}
	
	//end 책제목을 입력받아서 BookstoreService에 전달해서 제목을 포함하고 있는 책정보를 출력하게 한다.
	// 도서 검색 서비스
	// 제목를 전달받아서 도서 검색서비스를 처리한다.
	//		- BookService의 도서 검색기능을 실행해서 책정보를 제공받는다.
	//		- 조회된 책정보를 화면에 출력한다.
	public void searchBooks(String title) {
		System.out.println("=========================================");
		System.out.println("도서번호\t도서명\t저 자\t가 격\t재고량");
		System.out.println("=========================================");
		
		Book[] book = bookService.findBookByTitle(title);
		for(int i=0; i<book.length; i++) {
			if (book[i] == null) {
				break;
			} 
			System.out.print(book[i].no + "\t");
			System.out.print(book[i].title + "\t");
			System.out.print(book[i].writer + "\t");
			System.out.print(book[i].price + "\t");
			System.out.println(book[i].stock + "\t ");
			
		}
	}
	
	// end 도서 정보 수정 서비스
	// 책정보를 전달받아서 책정보 수정서비스를 처리한다.
	//		- BookService의 책정보 수정기능을 실행한다.
	public void modifyBook(Book book) {
		bookService.updateBook(book);
	}
	
	//도서 전체 정보 서비스
	//BookstoreService의 전체 책 조회서비스를 실행해서 모든 책 정보를 출력하게 한다.
	public void retrieveAllBooks() {
		System.out.println("=========================================");
		System.out.println("도서번호\t   도서명\t\t저자명\t  가 격\t  재고량");
		System.out.println("=========================================");
		
		Book[] book = bookService.getAllBooks();
		
		for(int i=0; i<book.length; i++) {
			if (book[i] == null) {
				break;
			}
			System.out.print(book[i].no + "\t");
			System.out.print(book[i].title + "\t");
			System.out.print(book[i].writer + "\t");
			System.out.print(book[i].price + "\t");
			System.out.println(book[i].stock+ "\t");
		}
	}
	//대여현황조회(추가기능)
	//책번호를 입력받아서 그 책을 대여중인 정보(대여번호, 회원번호, 회원명) 출력하기
	//다시
	public void rentBookInfo(int bookNo) {
		System.out.println("=========================================");
		System.out.println("대여번호\t회원번호\t회원명");
		System.out.println("=========================================");
		
		
		Rental rent1 = rentalService.findRentalByBookNo(bookNo);
		User user1 = userService.findUserByBookNo(rent1.userNo);
		
		if (rent1 == null || user1 == null) {
			System.out.println("정보를 찾지 못했습니다.");
		} else {
			
		
		System.out.print(rent1.no+ "\t");
		System.out.print(rent1.userNo+ "\t");
		System.out.println(user1.name);	
		}
	}
	
	//end 회원번호, 책번호를 입력받아서 
	//BookstoreService의 대여 서비스에 전달해서 대여정보가 등록되게 한다.
	// 대여 서비스
		// 사용자번호와 책번호를 전달받아서 대여 서비스를 처리한다.
		//		- Rental객체를 생성해서 사용자번호, 책번호를 저장한다.
		//		- 대여여부는 대여중으로 설정한다.
		//		- 책재고 변경하기
		//			- BookService에서 책번호에 해당하는 책정보 조회기능 실행
		//			- 조회된 책의 재고를 1감소시킨다.
	public void rentBook(int userNo, int bookNo) {
		Rental rental = new Rental();
		
		User findUser = userService.findUserByNo(userNo);
		Book findBook = bookService.findBookByNo(bookNo);
		
		
		// 고객검색, 도서검색 해서 존재하는지 체크
		if(findUser == null || findBook == null /*|| findUser.isDisabled*/) {
			System.out.println("정보를 찾지 못했습니다.");
		} else {
			rental.userNo = userNo;
			rental.bookNo = bookNo;
			
			rentalService.insertRental(rental);
			rental.isRent = true;
			findBook.stock -= 1;
		}
	}
		
		//대여번호를 입력받아서 BookstoreService의 반납서비스에 전달해서 반납처리되게 한다.
		// 반납 서비스
		// 대여번호를 전달받아서 반납 서비스를 처리한다.
		//		- RentalService에서 대여번호에 해당하는 대여정보 조회 기능을 실행
		//		- 조회된 대여정보의 반납여부를 false로 설정한다.
		//		- 사용자포인트 증가, 책재고 변경하기
		//			- UserService에서 사용자번호로 사용자정보 조회하기 실행
		//			- BookService에서 책번호로 책정보 조회하기 실행
		//			- 조회된 사용자의 포인트를 책가격의 1%만큼 증가시키기
		//			- 조회된 책정보의 재고를 1증가시키기
	public void returnBook(int rentalNo) {
		Rental rental = rentalService.findRentalByNo(rentalNo);
		if(rental == null) {
			System.out.println("대여정보를 찾지 못했습니다.");
		}
		if(!rental.isRent) {
			System.out.println("이미 반납처리된 도서입니다.");
			return;
		}
			rental.isRent = false;
		
			int bookNo = rental.bookNo;
			int userNo=rental.userNo;
			Book book=bookService.findBookByNo(bookNo);
			User user = userService.findUserByNo(userNo);
			int point = (int)(book.price *0.01);
			user.point += point;
			book.stock++;
		
	}
		
	//BookstoreService의 대여현황조회 서비스를 실행해서 모든 대여현황을 출력하게 한다.
	// 대여현황 조회 서비스
	// 모든 대여정보를 조회하는 서비스를 처리한다.
	//		- RentalService의 전체 대여정보조회 기능을 실행한다.
	//		- 조회된 대여정보를 화면에 출력한다. (null체크)
	public void retrieveAllRentals() {
		System.out.println("=========================================");
		System.out.println("대여번호\t회원번호\t도서번호\t대여여부");
		System.out.println("=========================================");
		
		Rental[] rental = rentalService.getAllRentals();
		
		for(int i=0; i<rental.length; i++) {
			if (rental[i] == null) {
				break;
			}
			System.out.print(rental[i].no + "\t");
			System.out.print(rental[i].userNo + "\t");
			System.out.print(rental[i].bookNo + "\t");
			System.out.println(rental[i].isRent + "\t");
		}
	}
	
	//일괄반납(추가기능)
	//회원번호를 입력받아서 그 고객이 대여중인 모든 책을 일괄반납처리하기
	public void AllReturnBook(int userNo) {
		rentalService.returnAllRentalByUserNo(userNo);
	}
}