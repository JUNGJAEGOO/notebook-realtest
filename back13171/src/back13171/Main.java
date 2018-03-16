package back13171;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		long A = in.nextLong();
		long B = in.nextLong();
		
		System.out.println(divide(A,B));
	}
	
	public static long divide(long base,long exp) {
		long mod = 1000000007;
		long res = 1;
		long x = base % mod;
		
		while ( exp > 0) {
			if ( exp%2 == 1) {
				res = (res * x) % mod;
			}
			
			x = ( x * x ) % mod;
			exp = exp / 2;
		}
		
		return res;
	}
}
