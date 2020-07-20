package control;

public class Gugudan2 {

	public static void main(String[] args) {
		System.out.println("구구단 출력");
		for(int i=1;i<=9;i++) {
			
			for(int j=2;j<=9;j++) {
				System.out.print(" "+ j+"*"+i+" = "+(j*i));
				System.out.print("\t");
			}
			System.out.println();
		}

	}
}
