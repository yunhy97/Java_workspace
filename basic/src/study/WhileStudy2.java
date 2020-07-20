package study;

public class WhileStudy2 {

	public static void main(String[] args) {
		//i는 0부터 1초당 2씩 증가하며 j는 0부터 1초당 5씩 증가 한다.
		//몇초후에 i + j 가 1000이상이 될는지와 그때의 i와 j의 값을 구하여라.
		
		int i = 0;	
		int j = 0;
		int count = 0;
		while(true) {
			if(i+j>1000) {
				break;
			}
			i+=2;			//1초당 2씩 증가
			j+=5;			//1초당 5씩 증가
			count++;		
		}
		
		System.out.println("i = "+ i + ", j = "+ j + ", i+j = "+ (i+j) );
		System.out.println(count);

	}
}
