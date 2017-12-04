package back6359;

import java.util.Scanner;

public interface Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int dp[];
		

		
		while (T>0) {
			
			int n = in.nextInt();
			
			dp = new int[n+1];
			for ( int i = 1 ; i <= n ; i++) {
				dp[i] = 1;
			}
			
			for ( int i =2 ; i <= n ; i++) {
				for ( int j = i ; j <= n ; j+=i) {
					//System.out.println(j+" "+dp[j]);
					if ( dp[j] == 0 ) {
						dp[j] = 1;
					}else {
						dp[j] = 0;
					}
				}
			}
			
			int sum = 0;
			for ( int i = 1 ; i <= n ; i++) {
				//System.out.print(dp[i]+" ");
				sum+=dp[i];
			}
			
			System.out.println(sum);
			T--;
		}
	}
}
