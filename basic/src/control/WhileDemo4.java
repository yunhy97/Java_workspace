package control;

import java.util.Scanner;

public class WhileDemo4 {

	public static void main(String[] args) {
		//10000~99999 사이의 임의의 정수를입력하세요.
		//예)입력값 : 12132 ---> 출력값 1+2+1+3+2
		
		Scanner sc = new Scanner(System.in);
		System.out.print("임의의 5자리숫자를 입력하세요.(10000~99999) : ");
		int inputNum = sc.nextInt();
		
		int sum = 0;
		
		while(inputNum != 0) {
			int lastNumber = inputNum%10;
			sum += lastNumber;
			
			inputNum = inputNum/10;
		}
		System.out.println("합계: "+sum);
	}
}
