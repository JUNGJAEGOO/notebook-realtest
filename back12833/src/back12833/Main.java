package back12833;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		for ( int i = 0 ; i < C; i++) {
			A = A^B;
		}
		
		System.out.println(A);
	}
}
