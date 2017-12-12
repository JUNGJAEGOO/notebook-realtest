package back1947;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long dp[] = new long[1000001];
		dp[1] = 0; dp[2] = 1;
		for ( int i = 3 ; i <= 1000000; i++) {
			dp[i] = ((dp[i-1]+dp[i-2] )*(i-1))%1000000000;
			 								  
		}
		
		System.out.println(dp[N]);
	}
}
