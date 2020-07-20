package study;

public class ForStudy2 {

	public static void main(String[] args) {
		//1부터 30까지 짝수와 홀수의 합을 각각 구하세요.
		int sum1 = 0;
		int sum2 = 0;
		int count1 =0;
		for(int i=1; i<=30; i++) {
			if(i%2 == 0) {
				sum1 += i;
				count1++;
			}else if(i%2 == 1) {
				sum2 += i;
			}
		}
		System.out.println("짝수의 합은 "+ sum1);
		System.out.println("홀수의 합은 "+ sum2);
	}
}
