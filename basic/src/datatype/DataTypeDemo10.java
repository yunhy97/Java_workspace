package datatype;

public class DataTypeDemo10 {

	public static void main(String[] args) {
		/*
		 * 홍길동은 이번 시험에서 국어 80점, 영어 60점, 수학 45점을 획득했다.
		 * 
		 * 아래와 같이 출력되게 하시오
		 * 이름 	국어 영어	수학	총점	평점
		 * 홍길동	 80	 60	 45	 100 61
		 */
		
		String name = "홍길동";
		int kor = 80;
		int eng = 60;
		int math = 45;
		int tot = 100;
		int avg = 61;
		
		System.out.println("이름	"+"국어 	"+"영어 	"+"수학 	"+"총점 	"+"평점 ");
		System.out.println(name + "\t" + kor+ "\t" + eng+ "\t" + math+ "\t" + tot+ "\t" + avg);
		
		
	}
	
}
