package back10422;

import java.util.*;

public class Main {
	static int dp[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		dp = new int [5001][5001];
		for ( int i = 0 ; i < 5001 ; i++) {
			for ( int j = 0 ; j < 5001 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		for ( int testcase = 0 ; testcase < T ; testcase++) {
			
			int x = in.nextInt();
			if ( x % 2 == 1) {
				System.out.println(0);
			}else {
				System.out.println(func(x/2,x/2));
			}
			
		}
	}
	
	public static int func(int x,int y) {
		
		if ( x < y ) {
			return 0;
		}
		if ( x < 0 || y < 0) {
			return 0;
		}
		if ( x == 0 && y == 0) {
			return 1;
		}
		
		int ret = dp[x][y];
		if ( ret != -1) {
			return ret;
		}
		
		ret = 0;
		ret += func(x-1,y) + func(x,y-1);
		ret %= 1000000007;
		
		return dp[x][y] = ret;

		
	}

}
