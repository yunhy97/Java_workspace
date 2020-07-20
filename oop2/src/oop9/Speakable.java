package oop9;

//인터페이스 - 기획서
//사운드출력이 지원되는 모든 모니터가 갖춰야 하는 기능을 정의한다.
//사운드출력이 지원되는 모니터는 최소/최대 범위내의 소리크기만을 가지도록 상수를 정의한다.
public interface Speakable {
	public static final int MIN_VOLUME = 0; 		//상수
	public static final int MAX_VOLUME = 100;		//상수
	
	void sound();									//public abstract는 생략가능(인터페이스일 경우)
	void volumeUp();								//public abstract는 생략가능(인터페이스일 경우)
	void voulumeDown();								//public abstract는 생략가능(인터페이스일 경우)
	
}
