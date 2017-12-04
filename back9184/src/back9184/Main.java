package back9184;

import java.util.Scanner;

public class Main {
	static int dp[][][];
	public static void main(String args[]) {
		func();
		Scanner in = new Scanner(System.in);
		while ( true ) {
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int A=a,B=b,C=c;
		if ( a == -1 && b == -1 && c == -1 ) {
			break;
		}
		
		if ( a <= 0 || b <= 0 || c <=0) {
			a= 0 ; b = 0 ; c=0;
		}
		
		else if ( a > 20 || b > 20 || c > 20) {
			a = 20; b = 20 ; c = 20;
		}
		System.out.println("w("+A+", "+B+", "+C+")" + " = "+dp[a][b][c]);
		
		
		}
		
	}
	
	public static void func () {
		dp = new int[21][21][21];
		
			for ( int j = 0 ; j <= 20 ; j++) {
				for ( int k = 0 ; k <= 20 ; k++) {
					dp[0][j][k] = 1;
					dp[j][k][0] = 1;
					dp[j][0][k] = 1;
				}
			}
		
		for ( int i = 1 ; i <= 20 ; i++) {
			for ( int j = 1 ; j <= 20 ; j++) {
				for ( int k = 1 ; k <= 20 ; k++) {
					if ( i < j && j < k) {
						dp[i][j][k] = dp[i][j][k-1]+dp[i][j-1][k-1]-dp[i][j-1][k];
						
					}else {
						dp[i][j][k] = dp[i-1][j][k]+dp[i-1][j-1][k]+dp[i-1][j][k-1]-dp[i-1][j-1][k-1];

					}
				}
			}
		}
	}
}
