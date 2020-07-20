package oop1;

import java.util.Scanner;

public class OrderDemo1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Order[] orders = new Order[100];
		int savePosition = 0;
		
		System.out.println("<상품권 관리 프로그램>");
		
		while(true) {
			//메뉴 구성 1.조회	2.검색 3.입력  4.종료
			System.out.println();
			System.out.println("=========================================");
			System.out.println("1.조회	2.검색	3.입력	4.종료");
			System.out.println("=========================================");
			
			System.out.println("번호를 입력하세요: ");
			int menuNo = sc.nextInt();
			
			if(menuNo == 1) {
				//고객명, 고객등급, 총구매금액, 적립포인트, 사은품을 출력한다.
				System.out.println("[고객정보 조회]");
				if(savePosition == 0) {
					System.out.println("고객 주문내용이 존재하지 않습니다.");
				}else {
					System.out.println("고객명  고객등급  총구매금액  적립포인트  사은품");
					System.out.println("=========================================");
					for(int i=0; i<savePosition; i++) {
						Order order=orders[i];
					
						System.out.print(order.name + "\t");
						System.out.print(order.grade + "\t");
						System.out.print(order.price + "\t");
						System.out.print(order.point + "\t");
						System.out.println(order.gift);
					}
				}
			}else if(menuNo == 2) {
				//검색조건에 N을 입력하고 키워드에 이름을 입력해서 조회할 수 있다.
				//	* 고객명이 입력한 이름과 일치하는 정보를 찾아서 출력한다.
				//검색조건에 G를 입력하고 키워드에 등급을 입력해서 조회할 수 있다.
				//	* 사은품이 입력한 내용과 일치하는 정보를 찾아서 출력한다.

				System.out.println("[고객 주문내용 검색]");
				
				System.out.print("검색조건을 입력하세요(N,G) *N은 이름, G는 등급: ");
				String code = sc.next();
				
				/*System.out.print("검색내용을 입력하세요");
				 String text = sc.next();
				 System.out.println("고객명  고객등급  총구매금액  적립포인트  사은품");
				 System.out.println("========================================="); 
				 for(int i=0; i<savePosition; i++) {
				 	Order order = orders[i];
				 
				 	boolean foundOrder = False;
				 	if(code.equals("N" && text.equals(order.name)) {
				 		foundOrder = true;
				 	} else if(option.equals("G") && text.equals(order.gift)) {
				 		foundOrder = true;
				  	}
				 	if(FoundOrder) {
				  		System.out.print(order.name + "\t");
						System.out.print(order.grade + "\t");
						System.out.print(order.price + "\t");
						System.out.print(order.point + "\t");
						System.out.println(order.gift);
					}
				}
				 */
				Order foundOrder = null;
				
				if(code.equals("N")) {
					System.out.println("이름을 입력하세요: ");
					String name = sc.next();
					
					for(int i=0; i<savePosition; i++) {
						Order order = orders[i];
						if(name.equals(order.name)) {
							foundOrder = order;
							break;
						}
					}
				}else if(code.equals("G")) {
					System.out.println("등급을 입력하세요: ");
					String grade = sc.next();
					
					for(int i=0; i<savePosition; i++) {
						Order order = orders[i];
						if(grade.equals(order.grade)) {
							foundOrder = order;
							break;
						}
					}
				}
				
				if(foundOrder != null) {
					System.out.println("[조회결과]");
					System.out.println("===================================");
					System.out.println("고  객  명: " + foundOrder.name);
					System.out.println("고객  등급: " + foundOrder.grade);
					System.out.println("총구매금액: " + foundOrder.price);
					System.out.println("적립포인트: " + foundOrder.point);
					System.out.println("사  은  품: " + foundOrder.gift);
				}else {
					System.out.println("[" + code + "]와(과) 일치하는 고객명이 존재하지 않습니다.");
				}
				
			} else if(menuNo == 3) {
				/*
				 * 고객명, 고객등급, 총구매금액을 입력한다.
				 *	* 고객등급은 클래식,베스트,에이스,프리미어 중 하나를 입력한다.
				 *	* 적립포인트는 고객등급별로 차등 적립된다.
				 *		프리미어: 총구매금액의 5%
				 *		에이스  : 총구매금액의 3%
				 *		베스트  : 총구매금액의 2%
				 *		클래식  : 총구매금액의 1%
				 *	* 사은품은 구매금액에 따라서 차등 지급된다.
				 *		500만원 이상 : 숙박권
				 *		100만원 이상 : 상품권
				 *		50 만원 이상 : 할인권
				 *		그 외        : 주차권
				 */
				System.out.println("[고객정보 입력]");
				
				System.out.println("고객명: ");
				String name = sc.next();
				System.out.println("고객등급: ");
				String grade = sc.next();
				System.out.println("총구매금액: ");
				int price = sc.nextInt();
				
				Order order1 = new Order();
				
				order1.name = name;
				order1.grade = grade;
				order1.price = price;
				
				if(order1.grade.equals("클래식")) {
					order1.point=(int)(order1.price * 0.01);
				}else if(order1.grade.equals("베스트")) {
					order1.point=(int)(order1.price * 0.02);
				}else if(order1.grade.equals("에이스")) {
					order1.point=(int)(order1.price * 0.03);
				}else if(order1.grade.equals("프리미어")) {
					order1.point=(int)(order1.price * 0.05);
				}
				
				if(order1.price<=5000000) {
					order1.gift="숙박권";
				}else if(order1.price<=1000000) {
					order1.gift="상품권";
				}else if(order1.price<=500000) {
					order1.gift="할인권";
				}else {
					order1.gift="주차권";
				}
				
				orders[savePosition]=order1;
				savePosition++;
				
			}else if(menuNo == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		sc.close();		//scanner의 누수가 발생하지 않도록 코드 끝에 닫아준다.
	}
}
