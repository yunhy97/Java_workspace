package oop11;

public class HTAListDemo {

	public static void main(String[] args) {
		HTAList list = new HTAList();
		
		//값을 저장함
		list.add("홍길동");
		list.add("김유신");
		list.add("강감찬");
		list.add("이순신");
		list.add("류관순");
		
		//값 꺼내기
		HTAIterator hta = list.iterator();
		
		//Iterator의 hasNext()가 true를 반환하는 동안 while블록내의 수행문이 실행된다.
		while(hta.hasNext()) {
			String value = hta.next();
			boolean value2 = hta.hasNext();
			System.out.println("이름: "+ value + ", " + value2);
		}
		
	}
}
