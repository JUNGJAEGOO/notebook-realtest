package back10179;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			double A = in.nextDouble();
			A = A*0.8;
			System.out.format("$%.2f\n",A);
			
			
			
			T--;
		}
	}
}
