package back15482;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char [] input1 = in.nextLine().toCharArray();
		char [] input2 = in.nextLine().toCharArray();
		int dp[][] = new int[input1.length+1][input2.length+1];
		for (int i = 1 ; i <= input1.length ; i++ ) {
			for (int j = 1 ; j <= input2.length ; j++) {
				
				if ( input1[i-1] == input2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		
		for (int i = 0 ; i <= input1.length ; i++) {
			for (int j = 0 ; j <= input2.length ; j++) {
				System.out.print(dp[i][j]);
			}System.out.println();
		}
		
		System.out.println(dp[input1.length][input2.length]);
	}
}
