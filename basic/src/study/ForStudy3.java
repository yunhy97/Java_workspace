package study;

public class ForStudy3 {

	public static void main(String[] args) {
		
		//1부터 100까지 3과 5의 공배수를 출력하세요.
		for(int i=1; i<=100;i++) {
			if(i%3 == 0 && i%5 == 0) {
				System.out.println("3과 5의 공배수는 "+ i);
			}
		}
		
		//1부터 1000까지 7과 9의 공배수와 공배수의 합을 출력하세요.
		int sum =0;
		for(int j=1; j<=1000; j++) {
			if(j%7 == 0 && j%9 == 0) {
				System.out.println("7과 9의 공배수는 "+ j);
				sum += j;
			}
		}
		System.out.println("7과 9의 공배수의 합은 "+ sum);
		
		//1부터 100까지 7의 배수이거나 11의 배수를 출력하세요.
		for(int k=1; k<=100; k++) {
			if(k%7 == 0 || k%11 == 0) {
				System.out.println("7 또는 11의 공배수는 "+ k);
			}
		}
		
	}
}
