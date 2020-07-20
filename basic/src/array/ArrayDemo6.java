package array;

public class ArrayDemo6 {

	public static void main(String[] args) {
		int[][] scores = {
				{80,70,80},		//김유신의 국어, 영어, 수학점수
				{90,40,50},		//강감찬의 국어, 영어, 수학점수
				{100,86,100}	//이순신의 국어, 영어, 수학점수
		};
		int korTotal = 0;
		int engTotal = 0;
		int mathTotal = 0;
		System.out.println("번호		국어		영어		수학		총점		평균");
		System.out.println("============================================================");
		
		for(int i=0;i<scores.length;i++) {
			System.out.print(i+1+"\t\t");		//번호출력
			int total =0;						//0번행,1번행2번행의 총점을 저장하는 변수
			int avg =0;							//0번행,1번행2번행의 평균을 저장하는 변수
			korTotal += scores[i][0];			//0번행,1번행2번행의 국어점수 누적
			engTotal += scores[i][1];			//0번행,1번행2번행의 영어점수 누적
			mathTotal += scores[i][2];			//0번행,1번행2번행의 수학점수 누적
			for(int j=0;j<scores[i].length;j++) {
				total+=scores[i][j];			//각 행별 과목점수를 total에 누적
				avg=total/3;					//각 행별 과목점수의 평균을 avg에 누적
				System.out.print(scores[i][j]+"\t\t");	//각 행별 과목점수를 출력
			}
			System.out.print(total+"\t\t"+avg);	//각 행별 총점과 평균을 출력
			System.out.println();
		}
		System.out.println("============================================================");
		System.out.println("총점		"+korTotal+"\t\t"+engTotal+"\t\t"+mathTotal);
		
		
	}
}
