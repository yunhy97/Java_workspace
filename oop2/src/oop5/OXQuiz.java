package oop5;

import java.util.Scanner;

public class OXQuiz {
	public static void main(String[] args) {
		String[] OX = {"O", "O", "O", "O", "O", "O", "O", "O", "O", "X", "O"};
		//String[] OX = new String[10];
		//Scanner sc = new Scanner(System.in);
		int count = 0;
		int sum = 0;
		
		for(int i=0; i<OX.length; i++) {
			//System.out.print("O과 X 중 선택하시오: ");
			//String select = sc.next();
			
			//OX[i] = select;
			if(OX[i].equals("O")) {
				count++; 
				sum += count;	
			}else if(OX[i].equals("X")) {
				count=0;
			}
			
			System.out.print(count+" ");
		}
		System.out.println();
		for(int i=0; i<OX.length; i++) {
			
			System.out.print(OX[i] + " ");
		}
		System.out.println();
		System.out.println("총 합계:" + sum + "점");
		
	
	
	
	
	
	}
	
}
