package oop1;

public class PersonDemo2 {

	public static void main(String[] args) {
		
		//Person객체를 여러 개 담는 배열을 사용해보기
		//기존의 배열 --> int[] numbers = new int[3];
		
		//Person객체 3개 담을 수 있는 배열을 생성해서 people에 대입하기
		Person[] people = new Person[3];
		
		Person p1 = new Person();		//p1은 Person 객체의 주소값을 가지고 있다.
		p1.name = "이순신";
		p1.email = "lee@naver.com";
		p1.age = 60;
		
		Person p2 = new Person();		//p2는 Person 객체의 주소값을 가지고 있다.
		p2.name = "류관순";
		p2.email = "ryu@gmail.com";
		p2.age = 17;
		
		Person p3 = new Person();		//p3는 Person 객체의 주소값을 가지고 있다.
		p3.name = "강감찬";
		p3.email = "kang@daum.net";
		p3.age =80;
		
		//생성된 각각의 Person객체의 주소값을 배열에 저장하기
		people[0] = p1;
		people[1] = p2;
		people[2] = p3;
		
		//people 배열에 저장된 모든 Person객체의 속성을 출력하기
		for(int i=0; i<people.length; i++) {
			Person p = people[i];		//p에는 Person객체의 주소값이 순서대로 대입된다.
			System.out.println(p.name + "\t" + p.email + "\t" + p.age);
		}
		
		
	}
}
