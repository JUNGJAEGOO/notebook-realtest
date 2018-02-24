package back1328;

import java.util.Scanner;

public class Main {
	public static void main ( String args[]) {
		Scanner in = new Scanner(System.in);
		int N =in.nextInt();
		int L= in.nextInt();
		int R = in.nextInt();
		int dp[][][] = new int[N+1][N+1][N+1];
		dp[1][1][1] = 1;
		for (int i = 2 ; i <= N ; i ++) {
			for (int j = 1 ; j <= N ; j ++) {
				for (int k = 1 ; k <= N ; k ++) {
					dp[i][j][k] = (dp[i-1][j-1][k] + dp[i-1][j][k-1] + 2*dp[i-1][j][k]*(i-2) )% 1000000007;
					
				}
			}
		}
		
		System.out.println(dp[N][L][R]);
	}
}
