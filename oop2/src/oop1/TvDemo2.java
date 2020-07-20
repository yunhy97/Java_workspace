package oop1;

public class TvDemo2 {

	
	public static void main(String[] args) {
		
		Tv tv1 = new Tv();
		IPTv tv2 = new IPTv();
		NetflixTv tv3 = new NetflixTv();
		NetflixTv tv4 = new NetflixTv();
		
		//Object에 정의된 toString 메소드 사용하기
		//toString() 메소드는 "클래스전체이름@해시코드"로 구성된 문자열을 반환한다.
		String desc1 = tv1.toString();
		String desc2 = tv2.toString();
		String desc3 = tv3.toString();
		String desc4 = tv4.toString();
										//객체마다 해시코드가 다르다.
		System.out.println(desc1);		//oop1.Tv@15db9742
		System.out.println(desc2);		//oop1.IPTv@6d06d69c
		System.out.println(desc3);		//oop1.NetflixTv@7852e922 
		System.out.println(desc4);		//oop1.NetflixTv@4e25154f
		
		//자바는 참조변수의 값을 출력해 볼 수 없다.
		//참조변수의 값을 출력하는 대신, 참조변수가 참조하는 객체의 toString()를 실행해버린다.
		System.out.println(tv1);
		System.out.println(tv2);
		System.out.println(tv3);
		System.out.println(tv4);
		
		System.out.println(tv1.toString());
		System.out.println(tv2.toString());
		System.out.println(tv3.toString());
		System.out.println(tv4.toString());
	}
}
