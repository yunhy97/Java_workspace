package oop5;

public class Play {

	public static void main(String[] args) {
		
		Starcraft star = new Starcraft();
		//Unit unit = new Unit();    new를 사용 못함
		Marine u1 = new Marine();
		u1.name = "마린";
		star.addUnit(u1);		//Starcraft클래스의 addUnit메소드 사용
		
		Marine u2 = new Marine();
		u2.name = "마린";
		star.addUnit(u2);
		
		Ghost u3 = new Ghost();
		u3.name = "고스트";
		star.addUnit(u3);
		
		Firebat u4 = new Firebat();
		u4.name = "화염방사병";
		star.addUnit(u4);
		
		//이동하기
		star.click();
		
		//공격하기
		star.clickA();
		
	}
}
