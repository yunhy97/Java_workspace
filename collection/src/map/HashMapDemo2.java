package map;

import java.util.HashMap;

public class HashMapDemo2 {

	public static void main(String[] args) {
		
		//고객등급(bronze, silver, gold)에 따라서 각각 구매금액의 1%, 3%, 5%를 포인트로 지급하기
		
		HashMap<String, Double> pointDepsiteRate = new HashMap<String, Double>();
		pointDepsiteRate.put("bronze", 0.01);
		pointDepsiteRate.put("silver", 0.03);
		pointDepsiteRate.put("gold", 0.05);
		
		String grade = "silver";
		int orderPrice = 34000;
		
		double depositeRate = pointDepsiteRate.get(grade);
		int point = (int)(orderPrice*depositeRate);
		
//		int point = 0;
//		if(grade.equals("bronze")) {
//			point = (int)(orderPrice * 0.01);
//		} else if (grade.equals("silver")) {
//			point = (int)(orderPrice * 0.03);
//		} else if (grade.equals("gold")) {
//			point = (int)(orderPrice * 0.05);
//		}
		
		System.out.println("고객등급: " + grade);
		System.out.println("구매금액: " + orderPrice);
		System.out.println("포 인 트: " + point);
	}
}
