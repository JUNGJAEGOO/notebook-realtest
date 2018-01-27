package back4883;

import java.util.Scanner;

public class Main {
	static long dp[][];
	static int arr[][];
	static int inf = 1000000000;
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int k = 1;
		while ( true ) {
			
			N = in.nextInt();
			if ( N == 0) {
				return;
			}
			dp = new long[N][3];
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < 3 ; j++) {
					dp[i][j] = inf;
				}
			}
			arr = new int[N][3];
			for ( int i = 0 ; i < N ; i++) {
				int one = in.nextInt();
				int two = in.nextInt();
				int three = in.nextInt();
				arr[i][0] = one;
				arr[i][1] = two;
				arr[i][2] = three;
			}
			
			func();
			
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j <  3 ; j++) {
					System.out.print(dp[i][j]+" ");
				}System.out.println();
			}
			
			System.out.println(k+". "+dp[N-1][1]);
			k++;
		}
	}
	
	public static void func() {
		
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][1] + arr[0][2];
		
		for ( int i = 1 ; i < N ; i++) {
			
			for ( int j = 0 ; j < 3 ; j++) {
				
				if ( j == 0) {
					dp[i][j] = Math.min(arr[i][0]+dp[i-1][0],arr[i][0]+ dp[i-1][1]);
				}else if ( j == 1) {
					dp[i][j] = Math.min(Math.min(arr[i][1]+dp[i-1][0],arr[i][1]+dp[i][0]), Math.min(arr[i][1]+dp[i-1][1], arr[i][1]+dp[i-1][2]));
				}else {
					dp[i][j] = Math.min(arr[i][2]+dp[i-1][1],Math.min(arr[i][2]+dp[i][1],arr[i][2]+ dp[i-1][2]));
				}
				
				
			}
		}
		
	}
}
