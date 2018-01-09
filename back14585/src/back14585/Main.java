package back14585;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int dp[][];
	static int mat[][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		dp = new int[301][301];
		mat = new int[301][301];
		
		for ( int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			mat[x][y] = M;
		}
		
		for ( int i = 0 ; i <= 300 ; i++) {
			for ( int j = 0 ; j <= 300 ; j++) {
				if ( i == 0 && j == 0 ) {
					continue;
				}
				if ( i == 0) {
					if ( mat[i][j] == 0) {
						dp[i][j] = dp[i][j-1];	
					}else {
						dp[i][j] = M - i - j + dp[i][j-1];
					}
				}else if ( j == 0) {
					if ( mat[i][j] == 0) {
						dp[i][j] = dp[i-1][j];
					}else {
						dp[i][j] = M - i - j + dp[i-1][j];
					}
				}else {
					if ( mat[i][j] == 0) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}else {
						dp[i][j] = M - i - j + Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
		}
		
		System.out.println(dp[300][300]);
	}
}
