package back7770;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String ags[]) {
		Scanner in = new Scanner(System.in);
		BigInteger N = in.nextBigInteger();
		
		BigInteger n = BigInteger.ONE;
		BigInteger il = BigInteger.ONE;
		
		while ( true ) {
			BigInteger before = ((BigInteger.valueOf(2).multiply(n).multiply(n).multiply(n)).add(n)).divide(BigInteger.valueOf(3));
			BigInteger after = ((BigInteger.valueOf(2).multiply(n.add(il)).multiply(n.add(il)).multiply(n.add(il))).add(n.add(il))).divide(BigInteger.valueOf(3));
			//System.out.println(before+"~"+after);
			if ( N.compareTo(before) >= 0 && N.compareTo(after) < 0) {
				//System.out.println(n);
				break;
			}
			n = n.add(BigInteger.ONE);
		}
		System.out.println(n);
	}
}
