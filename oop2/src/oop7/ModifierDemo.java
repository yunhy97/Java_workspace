package oop7;

import oop7.sub.Modifier;

public class ModifierDemo {

	public static void main(String[] args) {
		Modifier m = new Modifier();
		
		//Modifier과 다른 패키지에 위치한 ModifierDemo에서는
		//public 접근제한이 지정된 멤버에만 접근할 수 있다.
		m.d = 10;
	}
}
