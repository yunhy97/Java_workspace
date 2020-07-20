package com.sample.mall;

import java.util.Scanner;

import com.sample.mall.service.MallService;

public class MallApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MallService service = new MallService();
		
		while(true) {
			System.out.println("##### 작은 쇼핑몰 #####");
			System.out.println("=================================================================================");
			System.out.println("1.모든 상품조회 2.상품상세조회 3.장바구니담기 4.내 장바구니 보기 5.구매하기 6.나의 구매내역 0.종료");
			System.out.println("=================================================================================");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = sc.nextInt();
			
			if (menuNo == 1) {
				System.out.println("[모든 상품조회]");
				service.displayAllProducts();
				// 모든 상품을 조회하기
				// 입력값 없음
			} else if (menuNo == 2) {
				System.out.println("[상품상세조회]");
				System.out.print("상품번호를 입력하세요: ");
				int no = sc.nextInt();
				service.displayProductDetail(no);
				// 상품상세정보 조회하기
				// 상품번호 입력받기				
			} else if (menuNo == 3) {
				System.out.println("[장바구니담기]");
				System.out.print("사용자아이디를 입력하세요: ");
				String id = sc.next();
				System.out.print("상품번호를 입력하세요: ");
				int no = sc.nextInt();
				service.addCartItem(id, no);
				// 장바구니 담기
				// 사용자아이디, 상품번호 입력받기
			} else if (menuNo == 4) {
				System.out.println("[내 장바구니 보기]");
				System.out.print("사용자아이디를 입력하세요: ");
				String id = sc.next();
				service.displayMyCart(id);
				// 내장바구니 보기
				// 사용자아이디 입력받기
			} else if (menuNo == 5) {
				System.out.println("[구매하기]");
				System.out.print("사용자아이디를 입력하세요: ");
				String id = sc.next();
				service.cartToOrder(id);
				// 구매하기
				// 사용자아이디 입력받기
			} else if (menuNo == 6) {
				System.out.println("[나의 구매내역]");
				System.out.print("사용자아이디를 입력하세요: ");
				String id = sc.next();
				
				service.displayMyOrders(id);
				// 나의 구매내역 보기
				// 사용자아이디 입력받기
			} else if (menuNo == 0) {
				System.out.println("[종료하기]");
				// 종료
				break;
			}
			System.out.println();
			System.out.println();
		}
		sc.close();
		System.out.println("[프로그램 종료]");
	}
}
