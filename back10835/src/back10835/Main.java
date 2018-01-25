package back10835;

import java.util.Scanner;

public class Main {
		static int left[];
		static int right[];
		static int dp[][];
	
		public static void main(String args[]) {
			Scanner in = new Scanner(System.in);
			int N = in.nextInt();
			left = new int[N];
			right = new int[N];
			for ( int i = N-1 ; i >= 0 ; i--) {
				left[i] = in.nextInt();
			}
			for ( int i = N-1 ; i >= 0 ; i--) {
				right[i] = in.nextInt();
			}

			dp = new int[N+1][N+1];
			for (int i = 0 ; i <= N ; i++) {
				for ( int j = 0 ; j <= N ; j++) {
					dp[i][j] = -1;
				}
			}
			
			System.out.println(func(N-1,N-1));
			
		}
		
		public static int func(int l,int r) {
			
			//System.out.println(l+" "+r);
			
			if ( l == -1 || r == -1) {
				return 0;
			}
			
			int ret = dp[l][r];
			if ( ret != -1 ) {
				return ret;
			}
			ret = 0;
			
			if ( left[l] > right[r]) {
				
				int a = func(l-1,r-1);
				int b = func(l-1,r);
				int c = right[r] + func(l,r-1);
				
				//System.out.println(a+" "+b+" "+c);
				
				ret = Math.max(a, Math.max(b, c));
				
				return dp[l][r] = ret;
				
			}else {
				
				int a = func(l-1,r-1);
				int b = func(l-1,r);
				
				//System.out.println(a+" m "+b);
				
				ret = Math.max(a, b);
				return dp[l][r] = ret;
			}
			
			
			
		}
}
