package back1965;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n+1];
		int dp[] = new int[n+1];
		int save[] = new int[n+1];
		
		for( int i = 1 ; i <= n ; i++) {
			arr[i] = in.nextInt();
		}
		
		dp[1] = 1;
		for ( int i = 1 ; i <= n ; i++) {
			int tmp = 0;
			for ( int j = i-1 ; j > 0 ; j-- ) {
				if ( arr[i] > arr[j]) {
					tmp = Math.max(tmp, dp[j]);
				}
			}
			dp[i] = tmp+1;
		}
		
		int max = -1;
		for(int i = 1 ; i <= n ; i++) {
			max = Math.max(max, dp[i]);
			System.out.println(dp[i]);
		}
		System.out.println(max);
		
	}
}
