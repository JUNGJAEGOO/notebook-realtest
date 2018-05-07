package backB;

import java.math.*;
import java.util.*;

public class MainF {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int r = in.nextInt();
		int n = in.nextInt();
		int mod = in.nextInt();
	
		
		a = a % mod;
		int boonmo =  ( r % mod - 1 % mod ) % mod;
		
		long x = r % mod;
		long res = 1;
		while ( n > 0 ) {
			
			if ( n % 2 == 1) {
				
				res = (res * x) % mod;
				
				
			}
			
			x = ( x * x) % mod;
			n /= 2;
			
			
		}
		System.out.println(res);
		
		long boonza = ( a * ( res - 1%mod)%mod ) % mod;
		
		System.out.println( ( boonza/boonmo ) % mod);
		
	}
	
	
}
