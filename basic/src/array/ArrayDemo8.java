package array;

import java.util.Scanner;

public class ArrayDemo8 {

	public static void main(String[] args) {
		/*
		 * 5개의 정수를 입력받아서 그 중에 가장 큰 값을 출력하시오.
		 */
		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];		//배열 생성
		
		for(int i=0; i<5; i++) {
			System.out.print("숫자를 입력하세요: ");
			int inputNumber =sc.nextInt();
			num[i]=inputNumber;		//5번 반복해서 숫자를 입력받고 배열에 담기
	
		}
		int max = 0;
		//배열에서 가장 큰 값을 찾아서 max에 담기
		
		for(int x : num) {
			if(x > max) {
				max = x;
			}
		}
		System.out.println("최댓값: "+ max);
	}
}
