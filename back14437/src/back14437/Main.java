package back14437;

import java.util.*;

public class Main {
	static int l;
	static int dp[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		String input = in.nextLine();
		l = input.length();
		dp = new int[3001][3001];
		for (int i = 0 ; i < 3001 ; i++) {
			for (int j = 0 ; j < 3001 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(func(0,N));
	}
	
	public static int func(int len,int sum) {
		
		if ( sum < 0) {
			return 0;
		}
		
		if ( len == l ) {
			if ( sum == 0) {
				return 1;
			}else {
				return 0;
			}
		}
		
		int ret = dp[len][sum];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		for (int i = 0 ; i <= 25 ; i++) {
			ret += func(len+1,sum-i)%1000000007;
		}
		
		return dp[len][sum] = ret;
	}
}
