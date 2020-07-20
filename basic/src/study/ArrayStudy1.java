/*
 * 배열
 * 		-서로 다른 타입의 변수들로 구성된 배열을 만들 수 없다.
 * 		-배열은 객체이다.
 * 		-인덱스가 자동으로 부여된다.
 * Enhanced-for문
 *		-배열, Collection과 같은 값을 여러개 저장하는 저장소에서 각 요소의 값을 하나씩 조회할 때 사용하는 for문이다.
 *		-반드시, 배열, Collection을 대상으로만 사용해야 한다.
 */
package study;
import java.util.Scanner;
public class ArrayStudy1 {
	/* 
	 * 배열을 이용하여 간단한 극장 예약시스템 작성 
	 * 아주 작은 극장이라 좌석이 10개만 됨. 
	 * 먼저 좌석 배치표를 보여주고 예약이 끝나면 1로 
	 * 예약이 안된 좌석은 0으로 나타내라. 
	 */
	public static void main(String[] args) {
		int[] seat = new int[10];
		int[] reservedNow = {0,0,0,0,0,0,0,1,0,0};
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("좌석을 예약하시겠습니까? (y 또는 n)");
			String reserved = sc.next();
			 
			 if("y".equals(reserved)) {
				 System.out.println("현재의 예약 상태는 다음과 같습니다.");
				 System.out.println("-------------------------------");
				 
				 for(int i=1;i<=10;i++) {
					 System.out.print(i+ "  ");
				 }
				 
				 System.out.println();
				 System.out.println("-------------------------------");
				 
				 for(int i=0;i<reservedNow.length;i++) {
					 System.out.print(reservedNow[i]+ "  "); 
				 }
				 
				 System.out.println();
				 System.out.println("몇 번째 좌석을 예약하시겠습니까? ");
				 int numSeat = sc.nextInt();
				 
				 if(reservedNow[numSeat-1] == 0) {
					 reservedNow[numSeat-1]=1;
					 System.out.println("예약되었습니다.");
					 
				 } else if(reservedNow[numSeat-1] == 1) {
					 System.out.println("이미 예약된 자리입니다. 다시 선택하세요.");
					 continue;
				 }
			 }else if("n".equals(reserved)){
				 System.out.println("예약을 취소하셨습니다.");
			 }
		}
	}	
}
