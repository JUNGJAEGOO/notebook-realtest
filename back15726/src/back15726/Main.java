package back15726;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		double A = in.nextDouble();
		double B = in.nextDouble();
		double C = in.nextDouble();
		
		double x = A*B/C;
		double y = A/B*C;
		
		if ( x >= y) {
			System.out.println((long)x);
		}else {
			System.out.println((long)y);
		}
		
	}
}
