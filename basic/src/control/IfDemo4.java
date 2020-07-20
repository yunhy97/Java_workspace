package control;

import java.util.Scanner;

public class IfDemo4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * 고객의 등급(일반, 로얄, 플래티넘 중 하나)과 총구매금액을 입력받는다.
		 * 고객의 등급이 플래티넘인 경우 구매금액의 10%를 할인한다.
		 * 			   로얄인 경우 구매금액의 3%를 할인한다.
		 * 			   일반인 경우 구매금액의 1%를 할인한다.
		 * 결재금액은 총구매금액에서 할인된 금액만큼 차감한 금액이다.
		 * 적립포인트는 결재금액의 3%를 적립한다.
		 *
		 * 출력내용은
		 * 		총구매금액, 고객등급, 할인된 금액, 결재할 금액, 적립포인트 
		 */
		
		System.out.print("등급을 입력하세요 : ");
		String grade = scanner.next();
		System.out.print("총구매금액을 입력하세요 : ");
		int totalPrice = scanner.nextInt();		//총구매금액
		
		int discountPrice = 0;		//할인된 금액, 초기화되지 않은 변수는 사용불가.
		int payTotalPrice = 0;		//결재할 금액
		int depositPoint = 0;		//적립포인트
		
		if(grade.equals("플래티넘")) {
			discountPrice = (int)(totalPrice*0.1);		//if문에 변수를 선언하면 그 블록안에서만 변수가 사용된다.
		}else if(grade.equals("로얄")) {
			discountPrice = (int)(totalPrice*0.03);
		}else if(grade.equals("일반")){
			discountPrice = (int)(totalPrice*0.01);
		}/*else {
			discountPrice = (int)(totalPrice*0.005);
		}*/
		payTotalPrice = totalPrice-discountPrice;		//수행문이 계속 반복되면 if문 밖에 적어준다.
		depositPoint = (int)(payTotalPrice*0.03);
		
		System.out.println();
		System.out.println("------정     보------");
		System.out.println("총 구매금액 : " + totalPrice + " 원");
		System.out.println("고 객 등 급 : " + grade);
		System.out.println("할인된 금액 : " + discountPrice + " 원");
		System.out.println("결재할 금액 : " + payTotalPrice + " 원");
		System.out.println("적립 포인트 : " + depositPoint + " 점");
	}
}
