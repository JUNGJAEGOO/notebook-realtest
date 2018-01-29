package back14867;

import java.util.Scanner;

public class Main {
	static int dp[][];
	static int capaA,capaB;
	static int inf = 1000000000;
	static int wannaA,wannaB;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		capaA = in.nextInt();
		capaB = in.nextInt();
		wannaA = in.nextInt();
		wannaB = in.nextInt();
		dp=  new int[100001][4];
		for (int i = 0 ; i <= 100000 ; i++) {
			for (int j = 0 ; j <= 3 ; j++) {
				dp[i]][j] = -1;
			}
		}
		System.out.println(func(0,0,0));
	}
	
	public static int func(int a,int b) {
		
		
		int ret = dp[sum];
		if ( ret != -1) {
			return ret;
		}
		ret = inf;
		
		
		
		return dp[sum] = ret;
	}
}
