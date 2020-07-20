package control;

import java.util.Scanner;

public class Gugudan1 {

	public static void main(String[] args) {
		//숫자를 입력받아서 해당 숫자에 대한 구구단을 출력하기
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 숫자를 입력하세요: ");
		int num = sc.nextInt();
		
		for(int i=1; i<=9;i++) {
			System.out.println(num+"*"+i+"="+(num*i));
		}


		
		
	}
}
