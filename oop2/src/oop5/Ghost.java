package oop5;

public class Ghost extends Unit{

	//Unit의 추상메소드인 attack()의 메소드재정의
	@Override
	void attack() {
		System.out.println("["+name+"] 은 자신을 감추고 적을 공격합니다.");
	}
}
