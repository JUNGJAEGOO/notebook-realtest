package back5721;

import java.util.Scanner;

public class Main {

	static int dp[];
	static int col[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		while ( true) {
			
		int N = in.nextInt();
		int M = in.nextInt();
		if ( N == 0 && M == 0) {
			break;
		}
		dp = new int[N+1];
		
		
		for ( int i = 1 ; i <= N ; i++) {
			col = new int[M+1];
			for ( int j = 1 ; j <= M ; j++) {
				col[j] = in.nextInt();
				if ( j >= 2) {
					col[j] = Math.max(col[j]+col[j-2], col[j-1]);
				}
			}
			
		dp[i] = col[M];
		//System.out.println(dp[i]);
		if ( i >=  2 ) {
				dp[i] = Math.max(dp[i]+dp[i-2], dp[i-1]);
		}
			
			
			
		}

		

		System.out.println(dp[N]);
		}
	}
}
