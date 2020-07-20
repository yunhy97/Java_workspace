package oop2;

import java.text.DecimalFormat;

public class MyUtils {

	//유틸성 메소드
	//자주 사용되는 메소드를 사용
	//클래스 메소드(static 메소드)로만 사용한다.
	
	public static String numberWithComma(long number) {
		DecimalFormat df = new DecimalFormat("#,###");
		
		return df.format(number);
	}
}
