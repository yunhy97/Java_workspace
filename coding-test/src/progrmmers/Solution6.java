package progrmmers;

public class Solution6 {
	 public int solution(int num) {
	        int answer = 0;
	        int count = 0;
	        for(int i =1; i<500; i++) {
	        	if(num == 1) {
	        		break;
	        	}
	        	if(num % 2 == 0) {
	        		num = num/2;
	        	} else {
	        		num = num*3+1;
	        	}
	        	count++;
	        	if(count >=500) {
	        	count= -1;
	        	}
	        }
	        return count;
    }
	 
}
