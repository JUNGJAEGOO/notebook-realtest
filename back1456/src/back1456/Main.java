package back1456;

import java.math.BigInteger;
import java.util.*;

public class Main {
	static boolean prime[];
	
	public static void main(String args[]) {
		Scanner in  =new Scanner(System.in);
		long A = in.nextLong();
		long B = in.nextLong();
		prime = new boolean[10000001];
		eratos();
		int count = 0;
		for ( int i = 2 ; i <= 10000000  ;i++) {
			BigInteger n = BigInteger.valueOf(i);
			if ( prime[i] != false ) {
				continue;
			}
			n = n.multiply(BigInteger.valueOf(i));
			while ( n.compareTo(BigInteger.valueOf(B)) <= 0)  {
				
				if ( n.compareTo(BigInteger.valueOf(A)) >= 0) {
					//System.out.println(n);
					count++;
				}
				n = n.multiply(BigInteger.valueOf(i));
			}
			
		}
		
		System.out.println(count);
	}
	
	public static void eratos() {
		
		prime[1] = true;
		prime[0] = true;
		
		for (int i = 2 ; i<= 10000000 ; i++) {
			if ( prime[i] == false) {
				for (int j = i+i ; j <= 10000000 ; j+=i) {
					if ( j > 10000000 ) {
						break;
					}
					prime[j] = true;
				}
			}
		}
		
	}
}
