package back4811;

import java.util.*;

public class Main {
	static long dp[][][];
	static int n;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		while ( true ) {
			
			n = in.nextInt();
			if ( n == 0) {
				break;
			}
			
			dp = new long[n*2+1][n*2+1][n*2+1];
			for ( int i = 0 ; i < n*2+1 ; i++) {
				for ( int j = 0 ; j < n*2+1 ; j++) {
					for ( int k = 0 ; k < n*2+1 ; k++) {
						dp[i][j][k] = -1;
					}
				}
			}
			
			System.out.println(func(n,0,0));
		}
	}
	
	public static long func(int full,int half,int idx) {
		
		//System.out.println(full+" "+half+" "+idx);
		
		if ( idx >= 2*n) {
			return 1;
		}
		
		long ret = dp[full][half][idx];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if( full-1 >= 0) {
			ret += func(full-1,half+1,idx+1);
		}
		if ( half - 1 >= 0) {
			ret += func(full,half-1,idx+1);
		}
		
		
		return dp[full][half][idx] = ret;
	}
}
