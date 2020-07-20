package control;

public class ForDemo2 {

	public static void main(String[] args) {
		/*
		 * 1부터 5까지의 합계를 계산하기
		 * 
		 */
		int sum = 0;
		//sum += 1;
		//sum += 2;
		//sum += 3;
		//sum += 4;
		//sum += 5;
		//System.out.println(sum);
		
		for(int i=1;i<=10;i++) {
			System.out.print(sum + "--->");
			sum += i;
			System.out.println("[i="+i+"]"+sum);
		}
		System.out.println(sum);
	}
}
