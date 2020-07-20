package oop11;

public class HTAList {

	private String[] data = new String[100];
	private int position = 0;
	
	public void add(String value) {
		data[position] = value;
		position++;
		
	}
	//내부클래스에 대한 객체를 반환하는 메소드
	//꺼내기 기능이 구현된 HTAIterator 타입의 HTAListIterator 객체가 반환된다.
	public HTAIterator iterator() {
		HTAListIterator iter = new HTAListIterator();
		return iter;
	}
	
	//HTAList에 저장된 데이터 꺼내기 기능이 구현된 HTAListIterator 클래스
	class HTAListIterator implements HTAIterator {
		
		private int currentPosition = 0;
		
		@Override
		public String next() {
			String value = data[currentPosition];		//멤버변수 data 사용해 봤어요
			currentPosition++;
			
			return value;
		}
		
		@Override
		public boolean hasNext() {
			boolean hasValue = true;
			if(currentPosition == position) {		//멤버변수 position 사용해 봤어요
				hasValue = false;
				
			}
			return hasValue;
		}
	}
}
