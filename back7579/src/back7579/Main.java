package back7579;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int dp[];
	static int cost[],memory[];
	static int N,M;
	static int inf = 1000000000;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		memory = new int[N+1];
		cost = new int[N+1];
		for (int i = 1 ; i <= N ; i++) {
			memory[i] = in.nextInt();
			
		}
		
		for (int i = 1 ; i <= N ; i++) {
			cost[i] = in.nextInt();
		}
		
		dp = new int[10001];
		//Arrays.fill(dp,inf);
		int ans = inf;
		for (int i = 1 ; i<= N ; i++) {
			for (int j = 10000 ; j >= 0 ; j-- ) {
				if( j-cost[i] >= 0) {
					dp[j] = Math.max(dp[j], dp[j-cost[i]]+memory[i]);
				}
			}
		}
		
		int min = inf;
		
		for (int i = 0 ; i <= 10000 ; i++) {
			if ( dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}
		
	}
	

	
}
