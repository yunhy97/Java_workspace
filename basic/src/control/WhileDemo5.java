package control;

public class WhileDemo5 {

	public static void main(String[] args) {
		//1 + (-2)+3+(-4)+5+ ...몇까지 더하면 총합이 100이상이 되는지 구하기
		
		int sum = 0;
		
		int num =1;
		while(true) {
			//number의 값이 홀수면 sum에 그냥 더하고, 아니면 -1를 곱한 후 더한다.
			//sum의 값이 100이상이면 탈출한다.
			//num의 값을 1증가시킨다.
			
			if(num%2==0) {
				sum += num*-1;
			}else if (num%2==1){
				sum += num;
			} 
			
			if(sum>=100) {
				break;
			}
			num++;
		}
		System.out.println("100이상이되는 첫번째 숫자: " + num);
		
	}
}