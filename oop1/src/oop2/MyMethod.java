package oop2;

public class MyMethod {

	
	//인스턴스 변수, 멤버변수
	String name;
	
	
	//클래스 변수, 정적 변수
	static final double PI = 3.14;
	
	
	//인스턴스 메소드
	//인스턴스변수, 클래스변수 모두 사용가능
	void memberMethod() {
		System.out.println("인스턴스변수 사용: " + name);
		System.out.println("클래스변수 사용: " + MyMethod.PI);
	}
	
	//인스턴스 메소드
	//인스턴스 메소드, 클래스 메소드 모두 사용가능
	void memberMethod2() {
		memberMethod();
		MyMethod.staticMethod();
	
	}
	
	//클래스 메소드, 정적 메소드
	//인스턴스변수에 접근이 불가능, 클래스메소드에서는 클래스변수만 사용가능
	static void staticMethod() {
		//System.out.println("인스턴스변수 사용: " + name);		//오류
		System.out.println("클래스변수 사용: " + MyMethod.PI);
	}
	//클래스 메소드, 정적 메소드
	//인스턴스메소드 사용불가, 클래스메소드만 사용가능
	static void staticMethod2() {
		//memberMethod();
		MyMethod.staticMethod();
	}
}
