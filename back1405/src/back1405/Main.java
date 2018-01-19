package back1405;

import java.util.Scanner;

public class Main {
	static int N;
	static long dp[][];
	static double p[];
	
	public static void main(String args[]) {
		Scanner in= new Scanner(System.in);
		N = in.nextInt();
		p= new double[4];
		for (int i = 0 ; i < 4 ; i++) {
			p[i] = in.nextLong();
		}
		dp = new long[15][4];
		for ( int i = 0 ; i < 15 ; i++) {
			for ( int j = 0 ; j < 4 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		long ans = 0;
		for (int i = 0 ; i < 4; i++) {
			ans += p[i]*func(1,i);
		}
		System.out.println(ans / Math.pow(10, N));
	}
	
	public static long func(int len,int choice) {
		if ( len == N)
		{
			return 1;
		}

		long ret = dp[len][choice];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		for (int i = 0 ; i < 4 ; i++) {
			if ( choice != i) {
				ret = ret + p[i]*func(len+1,i);
			}
		}
		
		return ret;
	}
}
