package com.sample.bookstore.app;

import java.util.List;


import com.sample.bookstore.service.BookstoreService;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Like;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.Review;
import com.sample.bookstore.vo.User;

public class Bookstore {

	public static void main(String[] args) throws Exception {
		
		BookstoreService service = new BookstoreService();
		
		while(true) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("1.가입  2.검색  3.책정보  4.주문  5.내주문  6.주문정보  7.문의  8.리뷰  9.좋아요  0.종료");
			System.out.println("--------------------------------------------------------------");
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = KeyboardUtil.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[신규 회원가입]");
				System.out.print("등록할 아이디를 입력하세요: ");
				String id = KeyboardUtil.nextString();
				System.out.print("등록할 비밀번호를 입력하세요: ");
				String password = KeyboardUtil.nextString();
				System.out.print("등록할 이름을 입력하세요: ");
				String name = KeyboardUtil.nextString();
				System.out.print("등록할 이메일을 입력하세요: ");
				String email = KeyboardUtil.nextString();

				User user = new User();
				user.setId(id);
				user.setPassword(password);
				user.setName(name);
				user.setEmail(email);
		
				boolean isSuccess = service.회원가입(user);
				if(isSuccess) {
					System.out.println("### 회원가입이 완료되었습니다.");
				} else {
					System.out.println("!!! 이미 사용중인 아이디입니다.");					
				}
				
			}else if (menuNo == 2){
				System.out.println("[책 검색하기]");
				System.out.print("키워드를 입력하세요: ");
				String keyword = KeyboardUtil.nextString();
				
				List<Book> books = service.도서검색(keyword);
				if(books.isEmpty()) {
					System.out.println("!!! 검색결과가 존재하지 않습니다.");
				} else {
					System.out.println(books.size() + "권의 책이 조회되었습니다.");
					System.out.println("--------------------------------------------------------------");
					System.out.println("번호\t제목\t\t\t저자\t출판사\t가격");
					for(Book book : books) {
						System.out.print(book.getNo() + "\t");
						System.out.print(book.getTitle()+ "\t\t");
						System.out.print(book.getWriter()+ "\t");
						System.out.print(book.getPublisher()+ "\t");
						System.out.println(book.getPrice());
					}
					System.out.println("--------------------------------------------------------------");
				}
				
			}else if (menuNo == 3){
				System.out.println("[책정보 상세보기]");
				System.out.print("검색할 책번호를 선택하세요: ");
				int bookNo =KeyboardUtil.nextInt();
				
				Book book = service.도서상세정보(bookNo);
				if(book == null) {
					System.out.println("!!! 유효한 책번호가 아닙니다.");
				}else {
					System.out.println("--------------------------------------------------------------");
					System.out.println("번      호: " + book.getNo());
					System.out.println("제      목: " + book.getTitle());
					System.out.println("저      자: " + book.getWriter());
					System.out.println("장      르: " + book.getGenre());
					System.out.println("출  판 사: " + book.getPublisher());
					System.out.println("가      격: " + book.getPrice());
					System.out.println("할인가격: " + book.getDiscountPrice());
					System.out.println("재      고: " + book.getStock());
					System.out.println("등  록 일: " + book.getRegisteredDate());
					System.out.println("--------------------------------------------------------------");
				}
				
			}else if (menuNo == 4){
				System.out.println("[주문하기]");
				System.out.print("주문자 아이디를 입력하세요: ");
				String userId = KeyboardUtil.nextString();
				System.out.print("주문할 책번호를 입력하세요: ");
				int bookNo =KeyboardUtil.nextInt();
				System.out.println("주문할 수량을 입력하세요:");
				int amount = KeyboardUtil.nextInt();
				
				boolean isSuccess = service.주문하기(userId, bookNo, amount);
				if(isSuccess) {
					System.out.println("### 주문이 완료되었습니다.");
				} else {
					System.out.println("!!! 주문처리 중 오류가 발생하였습니다..");					
				}
				
			}else if (menuNo == 5){
				System.out.println("[내 주문 전부 보기]");
				System.out.print("아이디를 입력하세요: ");
				String userId = KeyboardUtil.nextString();
				
				List<Order> orders = service.내주문조회(userId);
				if(orders.isEmpty()) {
					System.out.println("!!! 주문내역이 존재하지 않습니다.");
				} else {
					System.out.println(orders.size() + "개의 주문이 조회되었습니다.");
					System.out.println("--------------------------------------------------------------");
					System.out.println("주문번호\t책제목\t가격\t수량");
					
					for(Order order : orders) {
						System.out.print(order.getNo() + "\t");
						System.out.print(order.getBook().getTitle() + "\t");
						System.out.print(order.getPrice() + "\t");
						System.out.println(order.getAmount());
					}
					System.out.println("--------------------------------------------------------------");
				}
			}else if (menuNo == 6){
				System.out.println("[주문정보 상세보기]");
				System.out.print("주문번호를 입력하세요: ");
				int orderNo =KeyboardUtil.nextInt();
				
				Order order = service.주문상세정보(orderNo);
				if(order == null) {
					System.out.println("!!! 유효한 주문번호가 아닙니다.");
				}else {
					System.out.println("--------------------------------------------------------------");
					System.out.println("번      호: " + order.getNo());
					System.out.println("사용자명: " + order.getUser().getName());
					System.out.println("제     목: " + order.getBook().getTitle());
					System.out.println("가      격: " + order.getBook().getPrice());
					System.out.println("구매가격: " + order.getPrice());
					System.out.println("수      량: " + order.getAmount());
					System.out.println("주문일자: " + order.getRegisteredDate());
					System.out.println("--------------------------------------------------------------");
				}
			}else if(menuNo == 7) {
				System.out.println("---------------------------------------");
				System.out.println("1.전체조회  2.질문등록  3.질문조회  4.질문삭제");
				System.out.println("---------------------------------------");
				System.out.print("메뉴를 선택하세요: ");
				int subMenuNo = KeyboardUtil.nextInt();
				
				if(subMenuNo == 1) {
					System.out.println("[전체 조회하기]");
					//모든 질문글 표시
					List<Question> questions =service.문의글전체조회();
					if(questions.isEmpty()) {
						System.out.println("!!! 조회내역이 존재하지 않습니다.");
					} else {
						System.out.println(questions.size() + "개의 질문이 조회되었습니다.");
						System.out.println("--------------------------------------------------------------");
						System.out.println("번호\t작성자\t조회수\t답변상태\t질문유형");
						
						for(Question question : questions) {
							System.out.print(question.getNo() + "\t");
							System.out.print(question.getUser().getId() + "\t");
							System.out.print(question.getViewCount() + "\t");
							System.out.print(question.getStatus() + "\t");
							System.out.println(question.getType());
						}
						System.out.println("--------------------------------------------------------------");
					}
				} else if(subMenuNo == 2) {
					System.out.println("[내용 등록하기]");
					//아이디, 제목, 내용, 질문구분(배송, 결재, 품직)을 입력해서 등록한다.
					System.out.print("등록할 아이디를 입력하세요: ");
					String id = KeyboardUtil.nextString();
					System.out.print("등록할 제목를 입력하세요: ");
					String title = KeyboardUtil.nextString();
					System.out.print("등록할 내용을 입력하세요: ");
					String content = KeyboardUtil.nextString();
					System.out.print("등록할 질문구분(배송,결재,품질)을 입력하세요: ");
					String type = KeyboardUtil.nextString();
					
					Question question = new Question();
					
					question.setTitle(title);
					question.setContent(content);
					question.setType(type);
					
					boolean isSuccess = service.문의등록(id, question);
					if(isSuccess) {
						System.out.println("### 질문등록이 완료되었습니다.");
					} else {
						System.out.println("!!! 유효한 아이디가 아닙니다.");					
					}
					
				} else if(subMenuNo == 3) {
					System.out.println("[내용 조회하기]");
					//질문글 번호를 입력받아서 질문글과 답변글을 표시한다.
					//답변글이 없으면 표시하지 않는다.
					System.out.print("질문글 번호를 입력하세요: ");
					int questionNo = KeyboardUtil.nextInt();
					
					Question question = service.문의글조회(questionNo);
					
					if(question == null) {
						System.out.println("!!! 유효한 질문번호가 아닙니다.");
					}else {
						System.out.println("--------------------------------------------------------------");
						System.out.println("번      호: " + question.getNo());
						System.out.println("작  성 자: " + question.getUser().getId());
						System.out.println("제      목: " + question.getTitle());
						System.out.println("내      용: " + question.getContent());
						System.out.println("조  회 수: " + question.getViewCount());
						System.out.println("작성일자: " + question.getRegisteredDate());
						System.out.println("답변상태: " + question.getStatus());
						System.out.println("작성유형: " + question.getType());
						System.out.println("--------------------------------------------------------------");
					}
				} else if(subMenuNo == 4) {
					System.out.println("[내용 삭제하기]");
					//아이디와 질문글 번호를 입력받아서 질문글을 삭제한다.
					System.out.print("아이디를 입력하세요: ");
					String userId = KeyboardUtil.nextString();
					System.out.print("질문글 번호를 입력하세요: ");
					int questionNo = KeyboardUtil.nextInt();
					
					service.문의글삭제(questionNo, userId);
					
				}
			}else if(menuNo == 8) {
				System.out.println("---------------------------------------");
				System.out.println("1.리뷰조회  2.리뷰등록  3.평점평균");
				System.out.println("---------------------------------------");
				System.out.print("메뉴를 선택하세요: ");
				int subMenuNo = KeyboardUtil.nextInt();
				if(subMenuNo==1) {
					System.out.println("[책 리뷰쓰기]");
					
					System.out.print("등록할 책번호를 입력하세요: ");
					int bookNo = KeyboardUtil.nextInt();
					System.out.print("사용자 아이디를 입력하세요: ");
					String id = KeyboardUtil.nextString();
					System.out.print("등록할 내용을 입력하세요: ");
					String content = KeyboardUtil.nextString();
					System.out.print("등록할 평점(0~5)을 입력하세요: ");
					int point = KeyboardUtil.nextInt();
					
					Review review = new Review();
					review.setPoint(point);
					review.setContent(content);
					
					boolean isSuccess = service.책리뷰등록(bookNo, id, review);
					if(isSuccess) {
						System.out.println("### 리뷰등록이 완료되었습니다.");
					} else {
						System.out.println("!!! 유효한 정보가 아닙니다.");					
					}
					
				} else if(subMenuNo == 2) {
					System.out.println("[책 리뷰 삭제하기]");
					System.out.print("리뷰번호를 입력하세요: ");
					int no = KeyboardUtil.nextInt();
					
					
				}
			}else if(menuNo ==9) {
				System.out.println("---------------------------------------");
				System.out.println("1.책추천등록  2.추천수 조회");
				System.out.println("---------------------------------------");
				System.out.print("메뉴를 선택하세요: ");
				int subMenuNo = KeyboardUtil.nextInt();
				if(subMenuNo ==1) {
					System.out.println("[책 추천하기]");
					System.out.print("등록할 책번호를 입력하세요: ");
					int bookNo = KeyboardUtil.nextInt();
					System.out.print("사용자 아이디를 입력하세요: ");
					String userId = KeyboardUtil.nextString();
					
					service.책추천(bookNo, userId);
					//좋아요 증가시키기
				}else if(subMenuNo == 2) {
					System.out.println("[책 추천수 조회하기]");
					System.out.print("책번호를 입력하세요: ");
					int bookNo = KeyboardUtil.nextInt();
					Like like = service.책추천수(bookNo);
					if(like == null) {
						System.out.println("!!! 유효한 책번호가 아닙니다.");
					}else {
						System.out.println("--------------------------------------------------------------");
						//System.out.println("번      호: " + like.getBook().getNo());
						//System.out.println("작  성 자: " + like.);
						
						System.out.println("--------------------------------------------------------------");
					}
				}
			}else if (menuNo == 0){
				KeyboardUtil.close();
				System.out.println("[프로그램을 종료합니다.]");
				break;
			}
		}
	}
}
