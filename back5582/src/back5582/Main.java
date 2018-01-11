package back5582;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] input = in.nextLine().toCharArray();
		char[] input2 = in.nextLine().toCharArray();
		int dp[][] = new int[input.length+1][input2.length+1];
		int ans = -1;
		int x = -1;;
		int y= - 1;
		for ( int i = 1 ; i <= input.length ; i++ ) {
			for ( int j = 1 ; j <= input2.length ; j++) {
				if ( input[i-1] == input2[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = 0;
				}
				if ( dp[i][j] > ans) {
					ans = dp[i][j];
					x= i; y= j;
				}
			}
		}
		
		/*for ( int i = 0 ; i <= input.length ; i++) {
			for ( int j = 0 ; j<= input2.length ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}*/
		System.out.println(ans);
	}
}
