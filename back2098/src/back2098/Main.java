package back2098;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int arr[][];
	static int dp[][];
	static int inf = Integer.MAX_VALUE;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		dp = new int[N][1<<N];
		arr = new int[N][N];
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				arr[i][j] = in.nextInt();
			}
			Arrays.fill(dp[i], inf);
		}
		
		int res = func(0,1);
		if ( res == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(res);
		}
	}
	
	public static int func(int cur,int visit) {
		if ( visit == (1<<N) - 1 ) {
			return arr[cur][0];
		}
		
		if ( dp[cur][visit] != inf ) {
			return dp[cur][visit];
		}
		
		for ( int i = 0 ; i < N ; i++) {
			if ( (visit&(1<<i)) == 0 && arr[cur][i] != 0 ) {
				dp[cur][visit] = Math.min(dp[cur][visit],arr[cur][i]+func(i,visit|(1<<i) ));
			}
		}
		
		return dp[cur][visit];
	}
}
