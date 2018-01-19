package back2666;

import java.util.Scanner;

public class Main {
	static int left;
	static int right;
	static int N,M;
	static int dp[][][];
	static int want[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		left = in.nextInt();
		right = in.nextInt();
		M = in.nextInt();
		want = new int[M];
		for ( int i = 0 ; i < M ; i++) {
			want[i] = in.nextInt();
		}
		
		dp = new int[21][21][21];
		for ( int i = 0 ; i < 21 ; i++) {
			for ( int j = 0 ; j < 21 ; j++) {
				for ( int k = 0 ; k < 21 ; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		System.out.println(func(left,right,0));
	}
	
	public static int func(int l,int r,int pos) {
		
		
		
		if ( pos == M) {
			return 0;
		}
		
		
		int ret = dp[l][r][pos];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		ret += Math.min( Math.abs(want[pos]-l)+func(want[pos],r,pos+1), Math.abs(want[pos]-r)+func(l,want[pos],pos+1) );
				
		
		
		return ret;
		
	}
}


