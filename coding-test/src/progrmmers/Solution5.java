package progrmmers;

public class Solution5 {
	 boolean solution(String s) {
	        boolean answer = true;
	        int count1 = 0;
	        int count2 = 0;
	        String[] word = s.split("");
	        
	        for(int i=0; i<word.length; i++) {
	        	if(word[i].equals("p") || word[i].equals("P")) {
	        		count1++;
	        	} else if(word[i].equals("y") || word[i].equals("Y")) {
	        		count2++;
	        	}
	        	
	        }
	        if(count1 == count2) {
	        	return answer;
	        } else {
	        	answer = false;
	        	return answer;
	        }
	  
	    }
	 public static void main(String[] args) {
		Solution5 sol = new Solution5();
		String data = "PoooYy";
		boolean result =sol.solution(data);
		System.out.println(result);
	}
}
