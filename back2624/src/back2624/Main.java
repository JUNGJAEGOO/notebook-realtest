package back2624;

import java.util.Scanner;

public class Main {
	
	static int dp[][];
	static int coin[][];
	static int k;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		k = in.nextInt();
		coin = new int[k+1][2];
		
		for ( int i = 1 ; i <= k ; i++) {
			coin[i][0] = in.nextInt();  // 금액
			coin[i][1] = in.nextInt();  // 개수

		}
		
		dp = new int[10001][101];
		for (int i = 0 ; i <= 10000 ; i++) {
			for ( int j = 0 ; j <= 100 ; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(change(T,0));
		

	}
	
	public static int change(int sum,int idx) {
		if ( sum == 0) {
			return 1;
		}
		if ( idx > k ) {
			return 0;
		}
		//System.out.println("sum"+sum);

		int ret = dp[sum][idx];
		if ( ret != -1) { return ret; }
		ret = 0;
		
		for (int i = 0 ; i <= coin[idx][1] ; i++) {
			if ( sum - coin[idx][0]*i >= 0 ) {
				//System.out.println(idx+"+"+sum+","+coin[idx][0]+","+coin[idx][1]);
				ret += change(sum-coin[idx][0]*i,idx+1);
			}
		}

		dp[sum][idx] = ret;
		return ret;
	}
}
