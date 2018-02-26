package back11570;

import java.util.*;

public class Main {
	static int dp[][];
	static int arr[];
	static int N;
	static int inf = 1000000000;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		dp = new int[2001][2001];
		
		for (int i = 0 ; i < 2001 ; i++) {
			for ( int j = 0 ; j < 2001 ; j++) {
				dp[i][j] = -1;
			}
		}
		arr = new int[N+1];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.println(func(0,0));
	}
	
	public static int func(int l,int r) {
		
		if ( l == N || r == N) {
			return 0;
		}
		
		int ret = dp[l][r];
		if ( ret != -1) {
			return ret;
		}
		
		int max = Math.max(l, r);
		ret = inf;
		if ( l-1 >= 0) {
			ret = Math.min(func(max+1,r)+Math.abs(arr[max]-arr[l-1]),ret);
		}else {
			ret = Math.min(func(max+1,r)+Math.abs(0),ret);
		}
		if ( r-1 >= 0 ) {
			ret = Math.min(func(l,max+1)+Math.abs(arr[max]-arr[r-1]),ret);
		}else {
			ret = Math.min(func(l,max+1)+Math.abs(0),ret);
		}
		
		return dp[l][r] = ret;
		
	}
}
