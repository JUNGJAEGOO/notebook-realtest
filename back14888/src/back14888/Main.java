package back14888;

import java.util.Scanner;

public class Main {
	static int arr[];
	static int ops[];
	static int dp[][][][][];
	static int N;
	static int min = 1000000000;
	static int max = -1000000000;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N];
		ops = new int[4];
		dp = new int[N][N][N][N][N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		for ( int i = 0 ; i < 4 ; i++) {
			ops[i] = in.nextInt();
		}
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				for ( int k = 0 ; k < N ; k++) {
					for ( int s = 0 ; s < N ; s++) {
						for ( int t = 0 ; t < N ; t++) {
							dp[i][j][k][s][t] = -1;
						}
					}
				}
			}
		}
		func(1,arr[0],0,0,0,0);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static int func(int idx,int sum,int plus,int minus,int multiply,int divide) {
		//System.out.println(sum);
		if ( idx == N) {
			//System.out.println(sum);
			if ( sum > max ) {
				max = sum;
			}
			if ( sum < min) {
				min = sum;
			}
			return 1;
		}
		
		int ret = dp[idx][plus][minus][multiply][divide];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if ( plus+1 <= ops[0]) {
			ret += func(idx+1,sum+arr[idx],plus+1,minus,multiply,divide);
		}
		if ( minus+1 <= ops[1]) {
			ret += func(idx+1,sum-arr[idx],plus,minus+1,multiply,divide);
		}
		if ( multiply+1 <= ops[2]) {
			//System.out.println("hi");
			ret += func(idx+1,sum*arr[idx],plus,minus,multiply+1,divide);
		}
		if ( divide+1 <= ops[3]) {
			ret += func(idx+1,sum/arr[idx],plus,minus,multiply,divide+1);
		}
		
		return ret;
	}
}
