package backB;

import java.util.Scanner;

public class MainK {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		long N = in.nextLong();
		long exp = N-1;
		long base = 2 % 1000000007;
		long res = 1;
		while ( exp > 0 ) {
			
			if ( exp % 2 == 1) {
				res = (res * base) % 1000000007;

			}
			
			base = ( base * base) % 1000000007;
			exp /= 2;
			
			
		}
		
		System.out.println(res);
	}
}
