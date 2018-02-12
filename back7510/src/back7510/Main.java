package back7510;

import java.util.*;
import java.math.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int cnt = 1;
		StringBuilder sb = new StringBuilder();
		while ( T > 0) {
			
			BigInteger A = in.nextBigInteger();
			BigInteger B = in.nextBigInteger();
			BigInteger C = in.nextBigInteger();
			boolean pass = false;
			if (  A.pow(2).compareTo(B.pow(2).add(C.pow(2))) == 0) {
				pass = true;
			}
			if (  B.pow(2).compareTo(A.pow(2).add(C.pow(2))) == 0) {
				pass = true;
			}
			if (  C.pow(2).compareTo(B.pow(2).add(A.pow(2))) == 0) {
				pass = true;
			}
				
			sb.append("Scenario #"+cnt+":\n");
			if ( pass) {
				sb.append("yes\n\n");
			}else {
				sb.append("no\n\n");
			}
			cnt++;
			T--;
		}
		System.out.print(sb);
	}
}
