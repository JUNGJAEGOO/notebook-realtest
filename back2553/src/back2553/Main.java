package back2553;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		int N = in.nextInt();
		long ans = 1;
		for ( int i = 1 ; i <= N ; i++) {
			ans = ans * i;
			ans %= 1000000000;
			while ( ans% 10 == 0 ) {
				ans /= 10;
			}
			
		}
		System.out.println(String.valueOf(ans).charAt(String.valueOf(ans).length()-1));
	}
}
