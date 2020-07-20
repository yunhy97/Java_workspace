package etc;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		 
		//콜렉션 프레임워크의 표준 메소드를 사용한 경우
		Stack<String> stack1 = new Stack<String>();
		stack1.add("길동");
		stack1.add("유신");
		stack1.add("순신");
		
		for(String value : stack1) {
			System.out.println(value);
		}
		
		System.out.println();
		
		//Stack 고유의 기능을 제공하는 메소드를 사용하는 겨우
		Stack<String> stack2 = new Stack<String>();
		stack2.push("길동");		//Stack객체에 저장
		stack2.push("유신");
		stack2.push("순신");
		
		while(!stack2.isEmpty()) {
			String value = stack2.pop();		//Stack객체에서 조회 ,예: 홈페이지 뒤로가기, 되돌리기
			System.out.println(value);
		}
	}
}
