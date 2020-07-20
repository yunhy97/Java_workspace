package array;

import java.util.Scanner;

public class ArrayDemo9 {

	public static void main(String[] args) {
		/*
		 * 숫자를 10개 입력받아서 그 중에 짝수들의 합계만 구해서 출력하기
		 */
		Scanner sc = new Scanner(System.in);
		int[] num = new int[10];		//배열 생성
		
		for(int i=0; i<10; i++) {
			System.out.print("숫자를 입력하세요: ");
			int inputNumber =sc.nextInt();
			num[i]=inputNumber;		//10번 반복해서 숫자를 입력받고 배열에 담기
	
		}
		int total = 0;
		for(int x : num) {
			if(x%2==0) {
				total += x;
			}
		}
		System.out.println("합계: "+ total);
	}
}