package back13703;

import java.util.*;

public class Main {
	static int n,k;
	static long dp[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		k = in.nextInt();
		n = in.nextInt();
		dp = new long[1000][64];
		for (int i = 0 ; i < 1000 ; i++) {
			for (int j = 0 ; j <= 63 ; j++) {
				dp[i][j] = -1;
			}
			
		}
		
		if ( k == 0) {
			System.out.println(0);
			return;
		}
		
		System.out.println(func(k,0));
	}
	
	public static long func(int now,int len) {
		//System.out.println(now + " " + len);
		if ( len == n ) {
			return 1;
		}
		
		long ret = dp[now][len];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if ( now+1 > 0) {
		ret += func(now+1,len+1);
		}
		if ( now-1 > 0) {
		ret += func(now-1,len+1);
		}
		
		return dp[now][len] = ret;
	}
}
