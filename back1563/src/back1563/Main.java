package back1563;

import java.util.Scanner;

public class Main {
	static int N;
	static int dp[][][][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		dp = new int[N+1][3][2][N+1];  // 결 지 출
		for ( int i = 0 ; i <= N ; i++) {
			for ( int j = 0 ; j <= 2 ; j++) {
				for ( int k = 0 ; k <= 1 ; k++) {
					for ( int s = 0 ; s <= N ; s++) {
						dp[i][j][k][s] = -1;
					}
				}
			}
		}
		
		System.out.println(func(0,0,0,0));
		
	}
	
	public static int func(int len,int O,int L,int A) {
		
		if ( L >= 2 || O >= 3) {
			return 0;
		}
		
		if ( len == N) {
			return 1;
		}

		int ret = dp[len][O][L][A];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		ret += func(len+1,O+1,L,A);  // 연석 결속 + 1
		ret += func(len+1,0,L+1,A);  // 지각 +1 연속결석 정보는 초기화
		ret += func(len+1,0,L,A+1); // 출석 +1 연속결석 정보는 초기화
		
		return dp[len][O][L][A] = (ret % 1000000);
	}
}
