package com.sample.bookstore.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.sample.bookstore.dao.AnswerDAO;
import com.sample.bookstore.dao.BookDAO;
import com.sample.bookstore.dao.LikeDAO;
import com.sample.bookstore.dao.OrderDAO;
import com.sample.bookstore.dao.QuestionDAO;
import com.sample.bookstore.dao.ReviewDAO;
import com.sample.bookstore.dao.UserDAO;
import com.sample.bookstore.vo.Answer;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Like;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.Review;
import com.sample.bookstore.vo.User;

/**
 * 회원가입, 책검색, 책 상세정보 조회,
 * 주문하기, 내 주문 조회하기, 주문상세정보보기 등의 
 * 기능을 제공하는 객체다.
 * @author JHTA
 *
 */
public class BookstoreService {

	private UserDAO userDao = new UserDAO();
	private BookDAO bookDao = new BookDAO();
	private OrderDAO orderDao = new OrderDAO();
	private QuestionDAO questionDao = new QuestionDAO();
	private AnswerDAO answerDao = new AnswerDAO();
	private ReviewDAO reviewDao = new ReviewDAO();
	private LikeDAO likeDao = new LikeDAO();
	/**
	 * 신규 사용자 정보를 등록한다.
	 * @param user 신규 사용자 정보
	 * @return 회원가입이 성공하면 true를 반환한다.
	 * @throws Exception
	 */
	public boolean 회원가입(User user) throws Exception {
		User savedUser = userDao.getUserById(user.getId());
		if(savedUser != null) {
			return false;
		}
		//비밀번호 암호화하기
		String md5Password = DigestUtils.md5Hex(user.getPassword());
		user.setPassword(md5Password);
		
		userDao.addUser(user);
		return true;
	}
	/**
	 * 지정된 키워드가 제목에 포함된 책정보를 반환한다.
	 * @param title 검색 키워드
	 * @return 검색된 책들
	 * @throws Exception
	 */
	public List<Book> 도서검색(String title) throws Exception {
		List<Book> books = bookDao.getBooksBytitle(title);
		return books;
	}
	/**
	 * 지정된 책번호에 해당하는 책정보를 반환한다.
	 * @param bookNo 조회할 책번호
	 * @return 책정보, 유효한 번호가 아닌 경우 null이 반환된다.
	 * @throws Exception
	 */
	public Book 도서상세정보(int bookNo) throws Exception {
		Book book = bookDao.getBookByNo(bookNo);
		return book;
	}
	/**
	 * 주문요청을 처리합니다.
	 * @param userId 주문자 아이디
	 * @param bookNo 주문할 책번호
	 * @param amount 주문 수량
	 * @return 주문성공시 true를 반환한다.
	 * @throws Exception 
	 */
	public boolean 주문하기(String userId, int bookNo, int amount) throws Exception {
		User user = userDao.getUserById(userId);
		if(user == null) {	//회원정보가 없음
			return false;
		}
		Book book = bookDao.getBookByNo(bookNo);
		if(book == null) {	//책 정보가 없음
			return false;
		}
		if(book.getStock() < amount) {	//재고가 부족함
			return false;
		}
		Order order = new Order();
		order.setUser(user);
		order.setBook(book);
		order.setAmount(amount);
		order.setPrice(book.getDiscountPrice());
		
		//주문정보 저장
		orderDao.addOrder(order);
		
		//책 재고 변경
		book.setStock(book.getStock()- amount);
		bookDao.updateBook(book);
		
		//사용자 포인트 변경
		int depositPoint = (int)(book.getDiscountPrice()*amount*0.03);
		user.setPoint(user.getPoint() + depositPoint);
		userDao.updateUser(user);
		return true;
	}
	/**
	 * 지정된 사용자아이디의 모든 주문내역을 반환한다.
	 * @param userId 주문내역을 조회할 사용자 이이디
	 * @return 주문내역정보, 주문내영이 없는 경우 empty List 가 반환된다.
	 * @throws Exception
	 */
	public List<Order> 내주문조회(String userId) throws Exception {
		
		return orderDao.getOrdersByUserId(userId);
	}
	/**
	 * 지정된 주문번호에 해당하는 주문정보를 반환한다.
	 * @param orderNo 주문정보를 조회할 주문번호
	 * @return 주문정보 상세내역, 주문번호가 틀린 경우 null이 반환된다.
	 * @throws Exception
	 */
	public Order 주문상세정보(int orderNo) throws Exception {
		Order order = orderDao.getOrderByNo(orderNo);
		return order;
	}
	
	
	public boolean 문의등록 (String userId, Question question) throws Exception {
	
		User savedUser = userDao.getUserById(userId); 
		if(savedUser == null) {
			return false;
		}
		question.setUser(savedUser);
		questionDao.addQuestion(question);
		
		return true;
	}
	
	public void 답변등록(int questionNo, String content) throws SQLException {
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setQuestionNo(questionNo);
		
		answerDao.addAnwer(answer);
		
		// 질문글의 상태를 Y로 변경하기
		Question question = questionDao.getQuestionByNo(questionNo);
		question.setStatus("Y");
		questionDao.updateQuestion(question);
	}
	
	public List<Question> 문의글전체조회() throws SQLException {
		return questionDao.getAllQuestions(); 
	}
	
	public Question 문의글조회(int questionNo) throws SQLException {
		Question question = questionDao.getQuestionByNo(questionNo);
	
		// 질문글의 조회수 증가
		question.setViewCount(question.getViewCount()+1);
		questionDao.updateQuestion(question);
		return question;
	}
	public void 문의글삭제(int questionNo, String userId) throws SQLException {
		// 답변이 달려있으면 삭제 안됨
		// 질문작성자의 아이디와 사용자아이디가 다르면 삭제 안됨
		
		Question question = questionDao.getQuestionByNo(questionNo);
		if(question.getStatus().equals("Y")) {
			System.out.println("답변이 달려있어 삭제할 수 없습니다.");
			return;
		}
		if(question.getNo() != questionNo) {
			System.out.println("아이디가 같지 않아 삭제할 수 없습니다.");
			return;
		}
		questionDao.removeQuestion(questionNo);
		
	}
	public boolean 책리뷰등록(int bookNo, String userId, Review review) throws Exception {
		Book book = bookDao.getBookByNo(bookNo);
		User user = userDao.getUserById(userId); 
		if(book == null || user==null) {
			return false;
		}
		review.setUser(user);
		review.setBook(book);
		reviewDao.addReview(review);
		
		return true;
	}
	
	public boolean 책추천 (int bookNo, String userId) throws Exception {
		Book book = bookDao.getBookByNo(bookNo);
		User user = userDao.getUserById(userId);
		if(book == null || user==null) {
			return false;
		}
		Like like = new Like();
		like.setBook(book);
		like.setUser(user);
		likeDao.addLike(like);
		
		return true;
	}
	
	public Like 책추천수(int bookNo) throws SQLException {
		return likeDao.countReviewByNo(bookNo);
	}
	
}
