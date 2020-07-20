package control;

import java.util.Scanner;

public class Lotto2 {

	public static void main(String[] args) {
		/*
		 * 금액을 입력받는다.
		 * 금액은 1000원 단위의 값만 입력받는다.
		 * 로또번호를 입력된 금액만큼 발행한다.
		 * 1000원당 1세트씩 발행한다.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("금액을 천원 단위로 입력하세요 : ");
		int money = scanner.nextInt();
		
		int setCount = money/1000;			//로또번호를 입력된 금액만큼 발행한다.
		
		for(int i=1; i<=setCount*6; i++) {	//1000원당 1세트(6개의 숫자)씩 발행한다.
			int number = (int)(Math.random()*9 + 1);
			System.out.print(number + " ");
			if(i%6==0) {
				System.out.println(" ");
			}
		}
	}
}
