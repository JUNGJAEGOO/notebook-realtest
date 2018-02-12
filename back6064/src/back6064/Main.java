package back6064;

import java.util.*;

public class Main {
	static int dp[][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T= in.nextInt();
		while ( T > 0) {
			
			int M = in.nextInt();
			int N = in.nextInt();
			dp = new int[M+1][N+1];
			dp[1][1] = 1;
			int wannaX = in.nextInt();
			int wannaY = in.nextInt();
			int x = 1;
			int y = 1;
			int cnt = 1;
			while ( true) {
				
				if ( x < M ) {
					x = x + 1;
				}else {
					x = 1;
				}
				
				if ( y < N) {
					y =  y+ 1;
				}else {
					y = 1;
				}
				
				if ( x > M || y > N) {
					break;
				}
				
				if ( x == M && y == N) {
					break;
				}
				
				cnt++;
				dp[x][y] = cnt;
				
			}
			if (dp[wannaX][wannaY] == 0) {
				System.out.println(-1);
			}else {
				System.out.println(dp[wannaX][wannaY]);
			}
			
			T--;
		}
	}
}
