package back2631;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		int dp[] = new int[N];
		dp[0] = 1;
		for (int i = 1 ; i < N ; i++) {
			dp[i] = 1;
			
			for (int j = 0 ; j < i ; j++) {
				if ( arr[i] > arr[j] ) {
					if ( dp[i] <= dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
			}
		}
		
		
		Arrays.sort(dp);
		System.out.println(N-dp[N-1]);
	}
}
