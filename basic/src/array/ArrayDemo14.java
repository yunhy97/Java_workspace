package array;

import java.util.Scanner;

public class ArrayDemo14 {

	public static void main(String[] args) {
		/*
		 * 야구게임
		 * 		1~9까지의 임의의 수 3개를 가진 배열이 있다.
		 * 		사용자로부터 숫자3개를 입력받아서 순서대로 배열에 저장한다.
		 * 		사용자가 입력한 숫자와 임의의 숫자들을 비교해서
		 * 		숫자가 동일하고 인덱스도 동일하면 strike
		 * 		숫자는 동일하지만 인덱스는 일치하지 않으면 ball로 판정한다.
		 * 		최대 10회까지 시도할 수 있다.
		 * 		출력값이 "3S 0B"인 경우 사용자가 숫자를 모두 맞힌 경우다.
		 */
		Scanner sc = new Scanner(System.in);
		
		//사용자가 입력한 숫자 3개를 저장하는 배열
		int[] num1= new int[3]; 
		//임의의 숫자 3개를 저장하는 배열
		int[] secretNumbers= new int[3];
		
		//1~9 임의의 숫자를 secretNumbers에 순서대로 저장하기
		for (int i=0; i<secretNumbers.length; i++) {
			int randomNumber = (int)(Math.random()*9 + 1);

			//secretNumbers에 중복된 숫자가 저장되지 않게 하기
			boolean isExist = false;
			for(int j=0; j<secretNumbers.length; j++) {
				//새로 발생한 난수와 secretNumbers의 배열의 값을 순서대로 비교한다.
				if(secretNumbers[j] == randomNumber) {
					//동일한 숫자가 발견되면 isExist를 true로 설정하고,
					//숫자를 비교하는 for문을 탈출한다.
					isExist = true;
					break;
				}
			}
			//isExist가 false면 중복없음, isExist가 true면 중복이 발생함.
			if (!isExist) {
				//중복이 없었으므로 난수를 배열에 저장
				secretNumbers[i]=randomNumber;
			}else {
				//이번에 뽑은 난수가 중복이 발생했으므로 다시 이번회차를 뽑기 위해서\
				//i를 1감소시킨다.
				i--;
			}
		}
		//사용자가 숫자 맞추기
		
		int count = 1;
		while(true) {
			//최대 10회동안 못 맞추면 빠져나간다.
			if(count > 10) {
				System.out.println("실패-시도 횟수가 10회를 넘었습니다.!");
				break;
			}
			
			//사용자가 숫자를 입력한다.
			for (int i=0; i<num1.length; i++) {
				System.out.print(i+1 + "번째 숫자를 입력해주세요: ");
				num1[i] = sc.nextInt();
			}
			
			int strike = 0;
			int ball = 0;
			//num1의 숫자를 하나씩 가져와서 secretNumbers의 0,1,2,번째 숫자와 비교한다.
			for(int i=0; i< num1.length; i++) {
				for(int j=0; j<secretNumbers.length; j++) {
					if(num1[i] == secretNumbers[j]) {	//숫자가 같을 경우
						if(i==j) {	//인덱스가 같을 경우
							strike ++;
						} else {
							ball++;
						}
					} 
				}
			}
			
			System.out.println("스트라이크 횟수 : "+strike+ ", 볼 횟수 : "+ball);
			
			//성공했을 때 출력
			if(strike == 3) {
				System.out.println("성공입니다. 시도횟수는 총 "+ count + "회 입니다.");
					break;
			}
			//정답을 못 맞췄을 때 횟수증가
			count++;
		}
		
	}
}
