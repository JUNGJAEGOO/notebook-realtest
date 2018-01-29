package back2306;

import java.util.*;

public class Main {
	static char[] T;
	static int dp[][];
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		T = in.nextLine().toCharArray();
		N = T.length;
		dp = new int[N+1][N+1];
		for (int i = 0 ; i <= N ; i++) {
			for (int j = 0 ; j <= N ; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(func(0,N));
		
	}
	
	public static int func(int start,int end) {
		
		//System.out.println(start+" "+end);
		
		if ( start == N) {
			return 0;
		}
		if ( start==end) {
			return 0;
		}
		
		
		int ret = dp[start][end];
		if (ret != -1) {
			return ret;
		}
		ret = func(start+1,end);
		if ( T[start] == 'a' ) {
			for (int i = start+1 ; i < end ; i++) {
				if ( T[i] == 't') {
					ret = Math.max(ret, 2+func(start+1,i)+func(i+1,end));
				}
			}
			
		}
		else if ( T[start] == 'g' ) {
			for (int i = start+1 ; i < end ; i++) {
				if (T[i] == 'c') {
					ret = Math.max(ret, 2+func(start+1,i)+func(i+1,end));
				}
			}
		
		}


		return dp[start][end] = ret;
	}

	
}
