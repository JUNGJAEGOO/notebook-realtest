package back14863;

import java.util.Scanner;

public class Main {
	static int dp[][];
	static int N;
	static node arr[];
	static int inf = -1000000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int K = in.nextInt();
		arr= new node[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = new node();
			arr[i].A_second = in.nextInt();
			arr[i].A_cost = in.nextInt();
			arr[i].B_second = in.nextInt();
			arr[i].B_cost = in.nextInt();
		}
		
		dp = new int[N+1][K+1];
		for(int i = 0 ; i < N+1 ; i++) {
			for (int j = 0 ; j < K+1 ; j++) {
				dp[i][j] = -1;
				
			}
		}
		
		System.out.println(func(0,K));
		
	}
	
	public static int func(int len,int sec) {
		
		//System.out.println(len+" "+sec);
		
		if ( len >= N ) {
			return 0;
		}
		if ( sec < 0) {
			return inf;
		}
		
		
		int ret = dp[len][sec];
		if ( ret != -1) {
			return ret;
		}
		ret = inf;
		
		if ( sec - arr[len].A_second >= 0) {
		ret = Math.max(ret,arr[len].A_cost+func(len+1,sec-arr[len].A_second));
		}
		if ( sec - arr[len].B_second >= 0) {
		ret = Math.max(ret,arr[len].B_cost+func(len+1,sec-arr[len].B_second));
		}
		return dp[len][sec] = ret;
		
	}
	
	public static class node{
		int A_cost;
		int A_second;
		int B_cost;
		int B_second;
	}
}



