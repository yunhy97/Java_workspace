package oop2;

public class Calculator {

	int plus(int x, int y) {
		System.out.println("int + int 의 합 계산");
		int result =  x + y;
		return result;
	}
	
	int plus(int x, int y, int z) {
		System.out.println("int+int+int 의 합 계산");
		int result = x + y + z;
		return result;
	}
	double plus(double x, double y) {
		System.out.println("double+double 의 합 계산");
		double result = x + y;
		return result;
	}
	long plus(long x, long y) {
		System.out.println("long+long 의 합 계산");
		long result = x + y;
		return result;
	}
	/*중복정의 규칙위반
	 * 
	 
	long plus(long a, long b) {
		long result a + b;
		return result;
	}*/
}
