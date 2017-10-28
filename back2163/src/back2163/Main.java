package back2163;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		int dp[][] = new int[301][301];
		for(int i = 1 ; i <= 300 ; i++) {
			for ( int j = 1 ; j<= 300 ; j ++) {
				if ( j == 1) {
					dp[i][j] = i-1;
				}else {
				dp[i][j] = dp[i][j-1] +  i;
				}			
			}
		}
		
		System.out.println(dp[M][N]);
	}
	
	
}
