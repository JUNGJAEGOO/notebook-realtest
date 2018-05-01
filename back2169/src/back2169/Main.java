package back2169;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		int mat[][] = new int[N][M];
		
		for ( int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		int dp[][] = new int[N][M];

		dp[0][0] = mat[0][0];
		
		int tempDP[][][] = new int[2][N][M];
		
		for ( int i = 0 ; i < N ; i++) {
			
			
			if ( i == 0) {
				for  (int j = 1 ; j < M ; j++) {
					dp[i][j] = dp[i][j-1] + mat[i][j];
				}
			}
			else {
			
				tempDP[0][i][0] = dp[i-1][0] + mat[i][0];
				
				for ( int j = 1 ; j < M ; j++) {
					
					tempDP[0][i][j] = Math.max(dp[i-1][j], tempDP[0][i][j-1])+ + mat[i][j] ;
					
				}
				
				tempDP[1][i][M-1] = dp[i-1][M-1] + mat[i][M-1];
				//System.out.println(tempDP[1][i][M-1]+" "+dp[i-1][M-1]+" "+mat[i][M-1]);
				
				for ( int j = M-2 ; j >= 0 ; j--) {
					
					tempDP[1][i][j] = Math.max(dp[i-1][j], tempDP[1][i][j+1]) + mat[i][j] ;
				}
			
				for (int j = 0 ; j < M ; j++) {
					
					dp[i][j] = Math.max(tempDP[0][i][j], tempDP[1][i][j]);
				}
				
				
			}
			
			
		}
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < M; j++) {
				System.out.print(tempDP[0][i][j]+" ");
			}System.out.println();
		}
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < M; j++) {
				System.out.print(tempDP[1][i][j]+" ");
			}System.out.println();
		}
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < M; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}
		
		System.out.println(dp[N-1][M-1]);
	}
}
