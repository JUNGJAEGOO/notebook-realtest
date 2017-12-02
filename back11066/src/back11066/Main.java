package back11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while ( T > 0) {
			
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N+1];
			int dp[][] = new int[N+1][N+1];
			st = new StringTokenizer(br.readLine()," ");
	        for ( int i = 1 ; i <= N ; i++) {
	        	arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
	        }
			for (int len = 2; len <= N; len++) {
	            for (int i = 1; i <= N - len + 1; i++) {
	                int j = i + len - 1;
	                dp[i][j] = Integer.MAX_VALUE;
	 
	                for(int k = i; k < j; k++) {
	                    int cost = dp[i][k] + dp[k + 1][j] + arr[j] - arr[i - 1];
	                    dp[i][j] = Math.min(dp[i][j], cost);
	                }
	            }
	        }
			
			for ( int i = 1 ; i <= N ; i++) {
				for ( int j = 1; j <= N ; j++) {
					System.out.print(dp[i][j]+" ");
				}System.out.println();
			}
			
			
			T--;
		}
	}
	



}
