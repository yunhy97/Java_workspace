package operator;

import java.util.Scanner;

public class ScannerDemo3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * 고객명, 상품명, 가격, 구매수량, 사용포인트를 입력받는다.
		 * 출력내용
		 *  	고객명, 상품명, 가격, 구매수량, 구매가격, 사용포인트, 결재금액, 적립포인트
		 *  	* 사용포인트는 고객이 이미 적립한포인트가 있다고 가정하고, 임의의 값을 입력받는다.
		 *  	* 결재금액은 구매가격에서 포인트 사용량을 제외한 금액이다.
		 *  	* 적립포인트는 실결재금액의 3%다. 
		 */
		
		System.out.print("고  객  명을 입력하세요 : ");
		String name = scanner.next();
		
		System.out.print("상  품  명을 입력하세요 : ");
		String product = scanner.next();
		
		System.out.print("가      격을 입력하세요 : ");
		int price = scanner.nextInt();
		
		System.out.print("구 매 수 량을 입력하세요 : ");
		int amount = scanner.nextInt();
		
		System.out.print("사용포인트를 입력하세요 : ");
		int usePoint = scanner.nextInt();
		
		int buyPrice = price*amount;
		int totalPrice = buyPrice - usePoint;
		int point = (int)(totalPrice * 0.03);
		
		System.out.println();
		System.out.println("------정   보------");
		System.out.println("고   객  명 : " + name);
		System.out.println("상   품  명 : " + product);
		System.out.println("가       격 : " + price);
		System.out.println("구 매 수 량 : " + amount);
		System.out.println("구 매 가 격 : " + buyPrice);
		System.out.println("사용 포인트 : " + usePoint);
		System.out.println("결 재 금 액 : " + totalPrice);
		System.out.println("적립 포인트 : " + point);
		
	}
}
