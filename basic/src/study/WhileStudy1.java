package study;

public class WhileStudy1 {

	public static void main(String[] args) {
		
		//While문을 사용하여 1부터 몇까지 더하면 1000이 되는지 구하여라.
		int i = 0;
		int sum = 0;
		
		while(true) {
			sum+=i;
			if(sum > 1000) {
				break;
			}
			i++;
		}
	System.out.println(i);
	}	
}
