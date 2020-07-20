package progrmmers;

public class StrangeChar {
	public String solution(String s) {
		String answer ="";
		String[] data = s.split("");
		int count = 0;

		for(int i=0; i<data.length;i++) {
			if(data[i].equals(" ")) {
				count =0;
			} else {
				if(count % 2 ==0) {
					data[i]=data[i].toUpperCase();
					count++;
	            }else {
					data[i] = data[i].toLowerCase();
	                count++;
				}
			}
			answer +=data[i];
		}
		return answer;
	}
		public static void main(String[] args) {
			StrangeChar s = new StrangeChar();
			String word = "try hello world";
			s.solution(word);
			
		}
}
