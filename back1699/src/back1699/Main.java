package back1699;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N  = in.nextInt();   // 100
		int dp[] = new int[100001];
		int sq[] = new int[317];
		
		for (int i = 1 ; i <= 316 ; i++) {
			sq[i] = i*i;
			//dp[i*i] = 1;
		}
		
		for ( int j = 1 ; j <= 316 ; j++) {
			for (int i = sq[j] ; i <= 100000 ; i++) {
				if ( dp[i] != 0) {
					dp[i] = Math.min(dp[i-sq[j]]+1,dp[i]);
				}else {
					dp[i] = dp[i-sq[j]]+1;
				}
			}
		}
		
		
		/*for ( int i = 1 ; i <= 10 ;i++) {
			for ( int j = 1 ; j <= 10; j++) {
				System.out.print(dp[10*(i-1)+j]+" ");
			}System.out.println();
		}*/
		System.out.println(dp[N]);
		
	}
	

}
