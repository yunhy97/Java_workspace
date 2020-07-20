package com.sample.bookstore;

import java.util.Scanner;

import com.sample.bookstore.service.BookstoreService;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.User;

public class BookstoreApp { //BookstoreService 앞부분
	
	public static void main(String[] args) {
		
		BookstoreService service = new BookstoreService();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println();
			System.out.println("[도서 대여점 관리 프로그램]");
			System.out.println("=====================================");
			System.out.println("1.회원관리  2.도서관리  3.대여관리  0.종료");
			System.out.println("=====================================");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = sc.nextInt();
			
			if(menuNo == 1) {
				System.out.println();
				System.out.println("[회원관리]");
				System.out.println("=====================================");
				System.out.println("1.등록  2.조회  3.변경  4.탈퇴  5.전체조회  6.대여현황");
				System.out.println("=====================================");
				
				System.out.print("회원관련 메뉴를 선택하세요: ");
				int userMenuNo = sc.nextInt();
				
				if(userMenuNo == 1) {
					System.out.println("[신규 회원 등록]");
					System.out.print("이름을 입력하세요: ");
					String name = sc.next();
					System.out.print("전화번호를 입력하세요: ");
					String tel = sc.next();
					
					service.addNewUser(name, tel);
					System.out.println("### 회원등록이 완료되었습니다.");
					
				}else if (userMenuNo == 2) {
					System.out.println("[회원정보 조회]");
					System.out.print("회원번호를 입력하세요: ");
					int no = sc.nextInt();
					
					service.retrieveUserInfo(no);
					System.out.println();
					System.out.println("### 회원정보가 조회되었습니다.");
					
				}else if (userMenuNo == 3) {
					System.out.println("[회원정보 수정]");
					System.out.print("회원번호를 입력하세요: ");
					int no = sc.nextInt();
					System.out.print("이름을 입력하세요: ");
					String name = sc.next();
					System.out.print("전화번호를 입력하세요: ");
					String tel = sc.next();
					
					User user = new User();
					user.no =no;
					user.name=name;
					user.tel=tel;
					service.modifyUserInfo(user);
					System.out.println("### 회원정보가 수정되었습니다.");
					
				}else if (userMenuNo == 4) {
					System.out.println("[회원탈퇴]");
					
					System.out.println("탈퇴처리할 회원번호를 입력하세요: ");
					int no = sc.nextInt();
					
					service.disabledUser(no);
					
				}else if (userMenuNo == 5) {
					System.out.println("[회원정보 전체조회]");
					System.out.println();
					service.retrieveAllUsers();
					
				}else if(userMenuNo == 6) {
					System.out.println("[회원대여 현황]");
					System.out.print("회원번호를 입력하세요: ");
					int no = sc.nextInt();
					
					service.rentUserInfo(no);
					System.out.println("### 회원대여 현황이 조회되었습니다.");
					
				}
			}else if(menuNo == 2) {
				System.out.println();
				System.out.println("[도서관리]");
				System.out.println("=====================================");
				System.out.println("1.검색  2.등록  3.수정  4.전체조회  5.대여현황");
				System.out.println("=====================================");
				System.out.print("도서관련 메뉴를 선택하세요: ");
				int userMenuNo = sc.nextInt();
				
				if(userMenuNo == 1) {
					System.out.println("[도서정보 검색]");
					System.out.print("책제목을 입력하세요: ");
					String title = sc.next();
					service.searchBooks(title);
					System.out.println("### 도서정보가 검색되었습니다.");
					
				} else if (userMenuNo == 2) {
					System.out.println("[도서정보 등록]");
					System.out.print("책제목을 입력하세요: ");
					String title = sc.next();
					System.out.print("저자를 입력하세요: ");
					String writer = sc.next();
					System.out.print("가격을 입력하세요: ");
					int price = sc.nextInt();
					
					service.insertNewBook(title, writer, price);
					System.out.println("### 도서등록이 완료되었습니다.");
					
				} else if (userMenuNo == 3) {
					System.out.println("[도서정보 변경]");
					System.out.print("도서번호를 입력하세요: ");
					int no = sc.nextInt();
					System.out.print("도서명을 입력하세요: ");
					String title = sc.next();
					System.out.print("저자를 입력하세요: ");
					String writer = sc.next();
					System.out.print("가격을 입력하세요: ");
					int price = sc.nextInt();
					
					Book book = new Book(no, title, writer, price, 10000);
					service.modifyBook(book);
					System.out.println("### 도서정보가 수정되었습니다.");
				} else if(userMenuNo == 4) {
					System.out.println("[도서정보 전체조회]");
					
					System.out.println();
					service.retrieveAllBooks();
					
				}else if(userMenuNo == 5) {
					System.out.println("[도서대여 현황]");
					System.out.print("도서번호를 입력하세요: ");
					int bookNo = sc.nextInt();
					
					service.rentBookInfo(bookNo);
					System.out.println("### 도서대여 현황이 조회되었습니다.");
				}
			}else if(menuNo == 3) {
				System.out.println();
				System.out.println("[대여/반납 관리]");
				System.out.println("=====================================");
				System.out.println("1.대여  2.반납  3.대여현황조회  4.일괄반납");
				System.out.println("=====================================");
				System.out.print("대여/반납관련 메뉴를 선택하세요: ");
				int userMenuNo = sc.nextInt();
				
				if(userMenuNo == 1) {
					System.out.println("[도서대여 정보]");
					System.out.print("회원번호를 입력하세요: ");
					int userNo = sc.nextInt();
					System.out.print("도서번호를 입력하세요: ");
					int bookNo = sc.nextInt();
					
					service.rentBook(userNo, bookNo);
					System.out.println("### 도서대여가 완료되었습니다.");
					
				} else if (userMenuNo == 2) {
					System.out.println("[도서반납 정보]");
					System.out.print("대여번호를 입력하세요: ");
					int no = sc.nextInt();
					
					service.returnBook(no);
					System.out.println("### 도서반납이 완료되었습니다.");
				
				} else if (userMenuNo == 3) {
					System.out.println("[대여현황 조회]");
					service.retrieveAllRentals();
					
					System.out.println("### 대여현황이 조회되었습니다.");
				} else if(userMenuNo == 4) {
					System.out.println("[도서 일괄반납]");
					
					System.out.print("회원번호를 입력하세요: ");
					int userNo = sc.nextInt();
					service.AllReturnBook(userNo);
					
				}
			}else if(menuNo == 0) {
				System.out.println("[프로그램 종료]");
				break;
			}
		}
		sc.close();
	}
}
