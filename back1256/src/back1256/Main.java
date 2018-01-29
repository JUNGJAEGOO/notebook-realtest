package back1256;

import java.util.*;

public class Main {
	static int N,M,K;
	static int cnt = 0;
	static int dp[][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		K = in.nextInt();
		dp = new int[N+1][M+1];
		for (int i = 0 ; i < N+1 ; i++ ) {
			for (int j = 0 ; j < M+1 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(func(N,M,0));
	}
	
	public static int func(int n,int m,int len) {
		
		
		if ( n == 0 || m == 0) {
			return 1;
		}
		
		
		int ret = dp[n][m];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		ret = Math.min(func(n-1,m,len+1)+func(n,m-1,len+1),1000000000);
		
		
		
		return dp[n][m] = ret;
	}
}
