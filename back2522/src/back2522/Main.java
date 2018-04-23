package back2522;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for ( int i = 1 ; i <= 2*N-1 ; i++) {
			int max = N-i;
			if ( max < 0 ) {
				max = -max;
			}
			for ( int j = 0 ; j < max ; j++) {
				System.out.print(" ");
			}
			for ( int j = 0 ; j < N-max ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
