package back7579;

import java.util.Scanner;

public class Main {
	public static int dp[][];
	static int N,M;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int mem[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			mem[i] = in.nextInt();	
		}
		int c[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			c[i] = in.nextInt();
		}
		dp = new int[10005][105];
		for ( int i = 0 ; i < 10005 ; i++) {
			for ( int j = 0 ; j < 105 ; j++) {
				dp[i][j] = -1;
			}
		}
		
	}
	
	public static int func(int c,int visit) {
		if ( visit == N ) { return 0;}
		int ret = dp[c][visit];
		if ( ret != -1) { return ret; }
		ret = 0;
		
		
		return ret;
		
	}
}
