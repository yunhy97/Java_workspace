package oop2;

public class HealthDemo {

	public static void main(String[] args) {
		
		Health health = new Health();
		
		double result1 = health.bmi(70, 1.68);
		System.out.println("bmi지수: " + result1);
		
		String result2 = health.bmiText(70, 1.68);
		System.out.println("bmi등급: " + result2);
	
	}
}
