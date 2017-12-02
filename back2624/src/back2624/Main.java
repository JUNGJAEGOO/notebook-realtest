package back2624;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int dp[] = new int[N+1];
		int K = in.nextInt();
		int coin[] = new int[K];
		int coins[] = new int[K];
		for ( int i = 0; i < K ; i++) {
			coin[i] = in.nextInt();
			coins[i] = in.nextInt();
			
		}
		
		
		
		for ( int i = 0 ; i < coin.length ; i++) {
				
		
			for ( int j = coin[i] ; j <= N ; j++) {
				
						System.out.println(dp[j-coin[i]]);
						dp[j] += dp[j-coin[i]];
				
					
				
			}
		}
		
		System.out.println(dp[N]);
	}
}
