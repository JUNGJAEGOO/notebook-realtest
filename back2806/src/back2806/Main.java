package back2806;

import java.util.Scanner;

public class Main {
	static int inf = 1000000000;
	static int dp[][];
	static char target[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		target = in.nextLine().toCharArray();
		dp = new int[2][N+1];
		for (int i = 0 ; i < 2 ; i++) {
			for (int j = 0 ; j < N+1 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(Math.min(func(0,0), func(1,0)));
		
	}
	
	public static int func(int k,int pos) {
		

		System.out.println(k+" "+pos);
		
		int ret = dp[k][pos];
		if( ret != -1) {
			return ret;
		}
		if ( pos == target.length) {
			return ret = 1-k;
		}
		
		ret = inf;
		
		
		if (target[pos] == 'A') {
			if ( k == 0) {
				ret = Math.min(func(k,pos+1), 1+func(1-k,pos+1));
			}else {
				ret = Math.min(1+func(k,pos+1), func(1-k,pos+1));
			}
		}else {
			if ( k == 0) {
				ret = Math.min(1+func(k,pos+1), func(1-k,pos+1));
			}else {
				ret = Math.min(func(k,pos+1), 1+func(1-k,pos+1));
			}
		}
		
		return dp[k][pos] = ret;
		
	}
}
