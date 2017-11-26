package back2225;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int An;
		int dp[][] = new int[202][202];
		for (int i = 1 ; i <=200 ; i++) {
			dp[0][i] = 1;
		}
		for ( int i = 1 ; i <= 200 ; i++) {
			dp[i][1] = 1;

		}
		for ( int i = 1  ; i <= 201 ; i++) {
			for ( int j = 1 ; j <= 201 ; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000000;
				                                     
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
