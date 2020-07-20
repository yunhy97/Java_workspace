package oop5;

public class Marine extends Unit{
	
	//Unit의 추상메소드인 attack()의 메소드재정의
	@Override
	void attack() {
		System.out.println("["+name+"] 은 적을 총으로 사살합니다.");
	}
	
}
