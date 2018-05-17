package back10826;

import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		BigInteger [] dp = new BigInteger[10001];
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;
		dp[2] = BigInteger.ONE;
		for ( int i = 3 ; i< 10001 ; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		System.out.println(dp[N]);
	}
}
