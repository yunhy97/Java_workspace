package control;

import java.util.Scanner;

public class IfDemo2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//숫자를 입력받아서 짝수인 경우는 "짝수", 아닌 경우는 "홀수"라고 표시하기
		//짝수는 2의 배수다.
		
		System.out.print("숫자를 입력하세요: ");
		int number = scanner.nextInt();
		
		if(number%2==0) {
			System.out.println(number + " 는(은) 짝수");
		} else {
			System.out.println(number + " 는(은) 홀수");
		}
	}
}
