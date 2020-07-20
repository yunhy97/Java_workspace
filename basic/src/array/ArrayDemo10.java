package array;

import java.util.Scanner;

public class ArrayDemo10 {

	public static void main(String[] args) {
		//인접한 숫자들간의 차이를 계산해서 가장 차이가 큰 숫자와 그차이를 구하기
		Scanner sc = new Scanner(System.in);
		int[] num = new int[10];		//배열생성
		
		for(int i=0; i<10; i++) {
			System.out.print("숫자를 입력하세요: ");
			num[i] = sc.nextInt();
			 
	
		}
		//출력할 값을 담는 변수 만들기
		int prev = 0;
		int next = 0;
		int gap = 0;
		//인접한 숫자들간의 차이를 계산해서 가장 차이가 큰 숫자와 그차이를 구하기
		for(int i=0; i<num.length-1; i++) {
			int temPrev = num[i];
			int temNext = num[i+1];
			int temGap = Math.abs(temPrev-temNext);
			
			if(temGap>gap) {
				prev = temPrev;
				next = temNext;
				gap = temGap;
			}
			
		}
		System.out.println("숫자1: "+ prev+" 숫자2: "+next+ " 차이: "+ gap);
		//결과 출력하기
		
	}
}
