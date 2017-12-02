package back2688;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		long dp[][] = new long[65][10];
		long sum = 0;
		for ( int i = 0 ; i < 10 ; i++) {
			dp[1][i] = 1;
		}
		
		for ( int i = 2 ; i <65 ; i++ ) {
			sum = 0;
			for ( int j = 0 ; j < 10 ; j++) {
				sum += dp[i-1][j];
			}
			
			for ( int j = 9 ; j >= 0 ; j--) {
				
				dp[i][j] = sum;
				sum -= dp[i-1][j];
			}
		}
		
		while ( T > 0) {
			
			T--;
			int K = in.nextInt();
			long ans = 0;
			for ( int i = 0 ; i < 10 ; i++) {
				ans += dp[K][i];
			}
			System.out.println(ans);
			
		}
	}
	
	
}
