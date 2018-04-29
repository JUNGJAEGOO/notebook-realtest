package back3372;

import java.util.*;
import java.math.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		boolean visit[][] = new boolean[N][N];
		int mat[][] = new int[N][N];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		BigInteger dp[][] = new BigInteger[N+1][N+1];
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				dp[i][j] = BigInteger.ZERO;
			}
		}
		
		dp[0][0] = BigInteger.ONE;
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				
				if ( !(j==N-1 && i==N-1) && dp[i][j].compareTo(BigInteger.ZERO) != 0 && visit[i][j] == false) {
					if ( i + mat[i][j] < N) {
						dp[i+mat[i][j]][j] = dp[i+mat[i][j]][j] .add(dp[i][j] );
					}
					
					if ( j + mat[i][j] < N) {
						dp[i][j+mat[i][j]] = dp[i][j+mat[i][j]] .add(dp[i][j] );
					}
					
					visit[i][j] = true;
				}
			}
		}
		
		for (int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}
		
		System.out.println(dp[N-1][N-1]);
		
	}
}
