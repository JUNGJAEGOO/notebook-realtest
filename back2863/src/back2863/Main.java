package back2863;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		double A = in.nextDouble();
		double B = in.nextDouble();
		double C = in.nextDouble();
		double D = in.nextDouble();
		
		double first = A/C + B/D;
		double second = C/D + A/B;
		double third = D/B + C/A;
		double fourth = B/A + D/C;
		//System.out.println(first+" "+second+" "+third+" "+fourth);
		int res = 0;
		double max = first;
		if ( max < second) {
			max = second;
			res = 1;
		}
		if ( max < third) {
			max = third;
			res = 2;
		}
		if ( max < fourth ) {
			max = fourth;
			res = 3;
		}
		
		System.out.println(res);
	}
}
