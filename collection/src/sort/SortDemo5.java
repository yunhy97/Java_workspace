package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortDemo5 {

	public static void main(String[] args) {
		ArrayList<Score> list = new ArrayList<Score>();
		list.add(new Score(10, "김유신", 289));
		list.add(new Score(12, "이순신", 258));
		list.add(new Score(3, "강감찬", 284));
		list.add(new Score(5, "류관순", 249));
		list.add(new Score(31, "윤봉길", 279));
		list.add(new Score(18, "안중근", 164));
		list.add(new Score(21, "이봉창", 210));
		
		//익명객체로 비교기 만들기
//		Collections.sort(list, new Comparator<Score>() {
//			public int compare(Score score1, Score score2) {
//				return (score1.getTotalScore() - score2.getTotalScore()) * -1;
//			}
//		});
		
		//java8의 람다식으로 비교기 만들기
		Collections.sort(list, (s1,s2) -> s1.getTotalScore() - s2.getTotalScore());
		
		for(Score score : list) {
			System.out.println(score.getNo() + ", " + score.getName()+ ", " + score.getTotalScore());
		}
	}
}
