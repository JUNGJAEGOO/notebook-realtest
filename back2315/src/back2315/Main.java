package back2315;

import java.util.*;

public class Main {
	static int d[];
	static int w[];
	static int wsum[];
	static int dp[][][];
	static int N;
	static int inf = 1000000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int M = in.nextInt();
		
		d = new int[1001];
		w = new int[1001];
		wsum = new int[1001];
		for ( int i = 0 ; i < N ; i++) {
			d[i] = in.nextInt();
			w[i] = in.nextInt();
			wsum[i+1] = wsum[i] + w[i];
		}
		
		dp = new int[1001][1001][2];
		for ( int i = 0 ; i < 1001 ; i++) {
			for ( int j = 0 ; j < 1001 ; j++) {
				for ( int k = 0 ; k < 2 ; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		
		System.out.println( func(M-1,N-M,0) );
	}
	
	public static int func(int l,int r,int onright) {
		
		if ( l == 0 && r == 0) {
			return 0;
		}
		
		int ret = dp[l][r][onright];
		if ( ret != -1) {
			return ret;
		}
		ret = inf;
		
		if ( l > 0) {
			if ( onright == 1) {
				ret = Math.min(ret, func(l-1,r,0) + (wsum[l]+wsum[N]-wsum[N-r])* (d[N-r-1]-d[l-1]) );
			}else {
				ret = Math.min(ret, func(l-1,r,0) + (wsum[l]+wsum[N]-wsum[N-r]) * (d[l] - d[l-1]) );
			}
	
		}
		if ( r > 0 ) {
			if ( onright == 1) {
				ret = Math.min(ret, func(l,r-1,1) + (wsum[l]+wsum[N]-wsum[N-r]) * (d[N-r]-d[N-r-1]) );
			}else {
				ret = Math.min(ret, func(l,r-1,1) + (wsum[l]+wsum[N]-wsum[N-r]) * (d[N-r] - d[l] ) );
			}
		}
		
		return dp[l][r][onright] = ret;
	}
	

}
