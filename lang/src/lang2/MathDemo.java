package lang2;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.rint;
import static java.lang.Math.round;
public class MathDemo {

	public static void main(String[] args) {
		
		//						-1				-2					1				2
		System.out.println(round(-1.2) + "," + round(-1.9) + "," + round(1.2) + ","+ round(1.8));
		//						-1.0			-2.0				1.0				2.0
		System.out.println(rint(-1.2) + "," + rint(-1.9) + "," + rint(1.2) + ","+ rint(1.8));
		//						-2.0			-2.0				1.0				1.0
		System.out.println(floor(-1.2) + "," + floor(-1.9) + "," + floor(1.2) + ","+ floor(1.8));
		//						-1.0			-1.0				2.0				2.0
		System.out.println(ceil(-1.2) + "," + ceil(-1.9) + "," + ceil(1.2) + ","+ ceil(1.8));
		
	}
}
