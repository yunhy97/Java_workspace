package oop4;

public class ReporterDemo {

	public static void main(String[] args) {
		String[] names = {"김유신", "강감창", "이순신", "류관순", "윤봉길"};
		
		//데이터 출력을 지원하는 객체들
		DataOutput do1 = new DataOutput();
		ConsolDataOutput do2 = new ConsolDataOutput();
		FileDataOutput do3 = new FileDataOutput("c:/files", "data.txt");
		
		Reporter reporter = new Reporter();
		//Reporter객체의 setOutputter()메소드를 이용해서 
		//Reporter객체의 DataOutput멤버변수에 
		//데이터 출력을 지원하는 객체(DataOutput)를 전달해서 조립시킨다. 
		reporter.setOutputter(do1);
		reporter.setData(names);
		reporter.reporting();
		
		reporter.setOutputter(do3);
		reporter.reporting();
	}
}
