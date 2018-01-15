package back1890;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner in= new Scanner(System.in);
		int N = in.nextInt();
		int mat[][] = new int[N][N];
		boolean visit[][] = new boolean[N][N];
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		long dp[][] = new long[N][N];
		dp[0][0] = 1;

			
			for ( int j = 0 ; j < N ; j++) {
				for ( int k = 0 ; k < N ; k++) {
					if ( !(j==N-1 && k==N-1) && dp[j][k] != 0 && visit[j][k] == false) {
						
						//System.out.println( j+","+(k+mat[j][k])+" "+ (j+mat[j][k])+","+k);
						if ( j+mat[j][k] < N) {
						dp[j+mat[j][k]][k] += dp[j][k];
						}
						if ( k+mat[j][k] < N) {
						dp[j][k+mat[j][k]] += dp[j][k];
						}
						visit[j][k] = true;
						
					}
				}
				
			}	

		
		/*for ( int s = 0  ; s < N ; s++) {
			for (int j = 0 ; j < N ; j++) {
				System.out.print(dp[s][j]+" ");
			}System.out.println();
		}System.out.println();*/
			
			System.out.println(dp[N-1][N-1]);
		
	}
}
