package study;

public class ForStudy1 {

	public static void main(String[] args) {
		
		//100~999 사이에 7의 배수의 갯수와 합을 구하세요.
		int sum = 0;
		int count = 0;
		for(int i=100; i<=999; i++) {
			if(i%7 == 0) {
				sum += i;
				count++;
			}
		}
		System.out.println("7의 배수의 갯수: "+ count);
		System.out.println("7의 배수의 합: "+ sum);
		
		//100~999 사이에 4의 배수가 아닌수들의 갯수와 합을 구하세요.
		int sum2=0;
		int count2=0;
		for(int j=100; j<=999; j++) {
			if(j%4 != 0) {
				sum2 += j;
				count2++;
			}
		}
		System.out.println("4의 배수가 아닌 수의 갯수: "+ count2);
		System.out.println("4의 배수의 합: "+ sum2);
	}
}
