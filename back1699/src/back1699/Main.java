package back1699;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int dp[] = new int[N+1];
		for(int i = 1 ; i*i <= N ; i++) {
			int tmp = i*i;
			dp[tmp] = 1;
			
		}
		
	    for (int i = 1; i <= N; i++)
	    {
	        for (int j = 1; j*j <= i; j++){
	            if (dp[i] > dp[i - j*j] + 1 || dp[i] == 0)
	                dp[i] = dp[i - j*j] + 1;
	        }
	    }


		for(int i =1;i<=N;i++) {
			System.out.println(i+" "+dp[i]);
		}
	}
}
