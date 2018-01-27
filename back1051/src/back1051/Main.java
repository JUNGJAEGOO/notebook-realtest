package back1051;

import java.util.Scanner;

public class Main {
	static int mat[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String first[] = in.nextLine().split(" ");
		int N = Integer.parseInt(first[0]);
		int M = Integer.parseInt(first[1]);
		mat = new int[N][M];
		for (int i = 0 ; i < N ; i++) {
			char[] tmp = in.nextLine().toCharArray();
			for (int j = 0 ; j < M  ; j++) {
				mat[i][j] = Integer.parseInt(String.valueOf(tmp[j]));
			}
		}
		
		long ans = 0;
		int dp[][] = new int[N][M];
		for ( int i = 0 ; i < N ; i++) {
			
			for (int j = 0 ; j < M ; j++) {
				
				int limit = Math.min(i,j);
				/*if (  i== N-1 && j == M -1) {
					System.out.println(limit);
				}*/
				
				for (int k = 0 ; k <= limit ; k++) {
					
					if ( i-k >= 0 && j-k >= 0) {
						
						if ( mat[i][j] == mat[i-k][j] && mat[i-k][j] == mat[i][j-k] && mat[i][j-k] == mat[i-k][j-k]) {
							dp[i][j] = (k+1)*(k+1);
							ans = Math.max(ans, dp[i][j]);
						}
					
					}
					
				}
				
				
			}
			
		}
		
		/*for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				System.out.print(dp[i][j]);
			}System.out.println();
		}*/
		
		System.out.println(ans);
		
	}
}
