package back1915;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int mat[][] = new int[n+1][m+1];
		
		for ( int i = 1 ; i <= n ; i++) {
			char[] tmp = br.readLine().toCharArray();
			for ( int j = 1 ; j <= m ; j++) {
				mat[i][j] = Integer.parseInt(String.valueOf(tmp[j-1]));
			}
		}
		
		int dp[][] = new int[n+1][m+1];

		for  ( int i = 1 ; i <= n ; i++) {
			for ( int j = 1 ; j <= m ; j++) {
				if ( mat[i][j] != 0) {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j]))+1;
				}
			}
		}
		int max = 0;
		for ( int i = 1 ; i <= n ; i++) {
			for ( int j = 1 ; j <= m ; j++) {
				//System.out.print(dp[i][j]+" ");
				max = Math.max(dp[i][j], max);
			}
		}
		
		System.out.println(max*max);
	}
}
