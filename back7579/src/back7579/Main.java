package back7579;

import java.util.Scanner;

public class Main {
	static int dp[];
	static int cost[],memory[];
	static int N,M;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		memory = new int[N];
		cost = new int[N];
		dp = new int[10000001];
		long sum = 0;
		for(int i = 0 ; i < N ; i++) {
			memory[i] = in.nextInt();
			sum += memory[i];
		}
		
		for(int i = 0 ; i < N ; i++) {
			cost[i] = in.nextInt();
		}
		
		for (int i = 0; i < N ; i++) {
			for (int j = (int) sum ; j >= cost[i]  ; j--) {
				dp[j] = Math.max(dp[j], dp[j-cost[i]]+memory[i]);
			}
		}
		
		/*for (int i = 0 ; i <= M ; i++) {
			System.out.print(dp[i]+" ");
		}*/
		
		for (int i = 0 ; i <= sum ; i++) {
			if ( dp[i] >= M)
			{
				System.out.println(i);
				return;
			}
		}
		
	}
	
}
