package datatype;

public class DataTypeDemo8 {

	public static void main(String[] args) {
		//반지름의 길이가 5, 10, 20인 원들이 있다.
		//각 원들의 넓이와 원의 둘레길이를 계산해서 출력하기
		//넓이는 3.14*반지름*반지름 둘레길이는 2*3.14*반지름
		//파이는 3.14==Math.PI
		
		int circle1 = 5;
		int circle2 = 10;
		int circle3 = 20;
		
		double width1 = Math.PI * circle1 * circle1;
		double width2 = Math.PI * circle2 * circle2;
		double width3 = Math.PI * circle3 * circle3;
		
		double length1 = 2 * Math.PI * circle1;
		double length2 = 2 * Math.PI * circle2;
		double length3 = 2 * Math.PI * circle3;
		
		System.out.println("반지름의 길이5  의 넓이: " + width1 + " , 둘레길이: " + length1 );
		System.out.println("반지름의 길이10 의 넓이: " + width2 + " , 둘레길이: " + length2 );
		System.out.println("반지름의 길이20 의 넓이: " + width3 + " , 둘레길이: " + length3 );
	}
}
