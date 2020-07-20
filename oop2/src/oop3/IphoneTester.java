package oop3;

public class IphoneTester {

	void testIphone(Iphone p) {
		p.applemusic();
		p.siri();
		
		//p에 전달된 객체가 Iphone8이라면 지문인식기능 실행해보기
		//p에 전달된 객체가 IphoneX라면 얼굴인식기능 실행해보기
		//p에 전달된 객체가 Iphone11이라면 카메라기능 실행해보기
		
		if(p instanceof Iphone8) {
			Iphone8 i8 = (Iphone8) p;		//(Iphone8) p <--- p가 참조하는 객체에서 
											//				   Iphone8객체를 찾아서 (형변환)
											//				   그 객체의 주소값을 반환한다.
			i8.fingerscan();
			System.out.println("아이폰8의 지문인식기능 테스트 완료");
		}else if(p instanceof Iphone11) {
			((Iphone11) p).tripleCamera();
			System.out.println("아이폰11의 좋은 카메라 기능 테스트 완료");
		}else if(p instanceof IphoneX) {
			((IphoneX) p).faceScan();
			System.out.println("아이폰X의 얼굴인식기능 테스트 완료");
		}
	}
}
//instanceof 연산자
		//참조변수가 참조하는 객체의 실제 타입을 확인하는 연산자.
		//사용법
			//참조변수 instanceof 클래스명
		//연산결과
			//true	검사에 사용했던 타입으로 형변환이 가능하다.
			//false 검사에 사용했던 타입으로 형변환이 불가능하다.
//Iphone p = new Iphone();
		//p가 참조하는 객체가 Iphone타입의 객체인가?
		//p instanceof Iphone ---------->true
		//p가 참조하는 객체가 Galaxy타입의 객체인가?
		//p instanceof Galaxy ---------->false
		//p instanceof SmartPhone ------>true
		//p instanceof phone ----------->true
//Iphone p = new Iphone8();
		//p instanceof Iphone8 --------->true
		//p instanceof IphoneX --------->false
		//p instanceof Iphone11 -------->false
		//p instanceof Galaxy ---------->false
		//p instanceof Iphone ---------->true
		//p instanceof SmartPhone ------>true