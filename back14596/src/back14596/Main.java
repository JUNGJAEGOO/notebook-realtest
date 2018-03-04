package back14596;

import java.util.*;

public class Main {
	static int R,C;
	static long ans = 1000000000;
	static int inf = 1000000000;
	static long dp[][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		R = in.nextInt();
		C = in.nextInt();
		
		int left[][] = new int[R][C];
		int right[][] = new int[R][C];
		for (int i = 0 ; i < R ; i++) {
			for (int j = 0 ; j < C ; j++) {
				left[i][j] = in.nextInt();
			}
		}
		
		for (int i = 0 ; i < R ; i++) {
			for (int j = 0 ; j < C ; j++) {
				right[i][j] = in.nextInt();
			}
		}
			
		dp = new long[R][C];
		for (int i = 0 ; i <R ; i++) {
			for (int j = 0 ; j < C ; j++) {
				dp[i][j] = -1;
			}
		}
		
		for (int s = 0 ; s < left[0].length ; s++) {
			
			ans = Math.min(ans,DFS(left,right,0,s) + (long)Math.pow(left[0][s]-right[0][s],2) );
			
		}
			
		
		System.out.println(ans);
	}
	
	public static long DFS(int[][] one,int[][] two,int r,int c) {
		
		if ( r == R-1 ) {
			return 0;
		}
		
		long ret = dp[r][c];
		if ( ret != -1) {
			return ret;
		}
		
		ret = inf;
		
		if ( c-1 >= 0) {
			ret = Math.min(ret,DFS(one,two,r+1,c-1)+(long)Math.pow(one[r+1][c-1]-two[r+1][c-1], 2) );
		}
		
		ret= Math.min(ret, DFS(one,two,r+1,c) +(long)Math.pow(one[r+1][c]-two[r+1][c], 2) );
		
		
		if ( c+1 < one[0].length) {
			ret = Math.min(ret, DFS(one,two,r+1,c+1) +(long)Math.pow(one[r+1][c+1]-two[r+1][c+1], 2) );
		}
		
		
		return dp[r][c] = ret;
	}
}
