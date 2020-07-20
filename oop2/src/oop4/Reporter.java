package oop4;

public class Reporter {

	String[] data;
	DataOutput outputter;
	//발현
	//자손클래스의 생성된 재정의된 메소드가 실행된다.
	//DataOutput outputter = new FileDataOutput("c:/files","데이터.txt");
	
	//DataOutput류 객체를 전달받아서 멤버변수 outputter에 담은 메소드
	void setOutputter(DataOutput dataOutput) {
		this.outputter = dataOutput;
	}
	
	void setData(String[] data) {
		this.data = data;
	}
	
	void reporting() {
		outputter.output(data);
	}
	
}
