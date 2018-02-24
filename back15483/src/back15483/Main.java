package back15483;

import java.util.*;

public class Main {
	static ArrayList<String> list = new ArrayList<>();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] inner = in.nextLine().toCharArray();
		char[] outer = in.nextLine().toCharArray();
		int n = inner.length;
		int m = outer.length;
		
		int dp[][] = new int[1001][1001];
		
		for (int i = 1; i<= n ; i++) {
			dp[i][0] = i;
		}
		for (int j = 1 ; j<= m ; j++) {
			dp[0][j] = j;
		}
		
		for ( int i =  1; i <= n ; i++) {
			for (int j = 1 ; j <= m ; j++) {
				if ( inner[i-1] == outer[j-1]) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1] + 1));
				}
			}
		}
		
		for (int i = 0 ; i <= n ; i++) {
			for (int j = 0 ; j <= m ; j++) {
				System.out.print(dp[i][j]);
			}System.out.println();
		}
		
		System.out.println(dp[n][m]);
		
	}
	

}
