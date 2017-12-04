package back9465;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int dp[][];
		int arr[][];
		StringTokenizer st;
		while ( T > 0 ) {
			int S = Integer.parseInt(br.readLine());
			dp = new int[2][S+1];
			arr = new int[2][S+1];
			
			st = new StringTokenizer(br.readLine()," ");
			for ( int i = 1 ; i <= S ; i++) {
				arr[0][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for ( int i = 1 ; i <= S ; i++) {
				arr[1][i] = Integer.parseInt(st.nextToken());
			}
			
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			for ( int i = 2 ; i <= S ; i++) {
				dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2])+arr[0][i];
				dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2])+arr[1][i];
			}
			
			for ( int i = 1 ; i <= S ; i++) {
				System.out.println(dp[0][i]+" ");
			}
			for ( int i = 1 ; i <= S ; i++) {
				System.out.println(dp[1][i]+" ");
			}
			T--;
		}
	}
}
