package back9461;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		long dp[] = new long[101];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2; // 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
		dp[6] = 3;
		dp[7] = 4;
		dp[8] = 5;
		dp[9] = 7;
		dp[10] = 9;
		
		for(int i = 11 ; i <= 100 ; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}
		
		while ( T>0 ) {
			
			int n = in.nextInt();
			
			System.out.println(dp[n]);
			
			
			T--;
		}
	}
}
