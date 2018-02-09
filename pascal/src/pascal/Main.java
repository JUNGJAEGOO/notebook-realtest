package pascal;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int R = in.nextInt();
		int C = in.nextInt();
		int W = in.nextInt();
		long dp[][] = new long[31][31];
		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 1;
		for (int i = 2 ; i <= 30 ; i++) {
			for (int j = 0 ; j <= 30  ; j ++) {
				if ( j == 0) {
					dp[i][j] = 1;
				}else if ( j == i) {
					dp[i][j] = 1;
				}else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
		}
		
		int cnt = 0;
		long sum = 0;
		for (int i = R-1 ; i< R+W-1 ; i++) {
			for (int j = C-1 ; j <= C + cnt - 1 ; j++) {
				sum += dp[i][j];
			}
			cnt++;
		}
		System.out.println(sum);
		
		/*for (int i = 0 ; i <= 30 ;i++) {
			for (int j = 0 ; j <= 30 ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}*/
	}

}
