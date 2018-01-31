package back13910;


import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int dp[];
	static int inf = 1000000000;
	static int arr[];
	static int N,M;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		arr = new int[M];
		for (int i = 0 ; i < M ; i++) {
			arr[i] = in.nextInt();
		}
		
		dp = new int[N+1];
//		for (int i = 0 ; i < 3 ; i++) {
//			for (int j = 0 ; j <= N ; j++) {
//				dp[i][j] = -1;
//			}
//		}
		
		if ( M == 1) {
			if ( N%arr[0] == 0) {
				System.out.println(N/arr[0]);
			}else {
				System.out.println(-1);
			}
			return;
		}
		
		int ans = inf;
		
		for (int k = 0 ; k <= N ; k++) {
			dp[k] = -1;
		}
		
		int tmp = (func(N));
		ans = Math.min(ans, tmp);
		
		if ( ans == inf) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
		
	}
	
	public static int func(int sum) {
		
		
		
		if ( sum < 0) {
			return inf;
		}
		if ( sum == 0) {
			return 0;
		}
		
		int ret = dp[sum];
		if ( ret != -1) {
			return ret;
		}
		ret = inf;
		
		for (int i = 0 ; i < M ; i++) {
		ret = Math.min(ret, 1+func(sum-arr[i]));
			for (int j = 0 ; j < M ; j++) {	
				if ( i != j) {
				ret = Math.min(ret, 1+func(sum-arr[i]-arr[j]));
				}
			}
		}
		
		
		return dp[sum] = ret;
		
	}
}

