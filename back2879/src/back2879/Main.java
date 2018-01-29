package back2879;

import java.util.Scanner;

public class Main {
	static int arr[];
	static int res[];
	static int dp[][];
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N+1];
		res = new int[N+1];
		for (int i = 1 ; i<= N ; i++) {
			arr[i] = in.nextInt();
		}
		for (int i = 1 ; i<= N ; i++) {
			res[i] = in.nextInt();
		}
		
		dp = new int[1001][1001];
		for(int i = 0 ; i < 1001 ; i++) {
			for(int j = 0 ; j < 1001 ; j++) {
				dp[i][j] =-1;
			}
		}
		
		System.out.println(func(1,N);
	}
	
	public static int func(int start,int end) {
		
		boolean pass = true;
		for (int i = 1 ; i<= N ; i++) {
			if ( arr[i] != res[i]) {
				pass = false;
				break;
			}
		}
		
		if ( pass ) {
			return 0;
		}
		
		int ret = dp[start][end];
		if ( ret != -1) {
			return ret;
		}
		
		
		
		
	}
}
