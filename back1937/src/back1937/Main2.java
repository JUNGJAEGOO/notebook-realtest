package back1937;

import java.util.Scanner;

public class Main2 {
	static int N;
	static int mat[][];
	static int dp[][];
	public static void main(String ars[]) {
		Scanner in = new Scanner(System.in);
		 N = in.nextInt();
		mat = new int[N][N];
		dp = new int[N][N];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		for ( int i = 0 ; i < N ; i++) {
			for  (int j = 0 ; j < N ; j++) {
				dp[i][j] = -1;
			}
		}
		
		
		for ( int i = 0 ; i < N ; i++) {
			for  (int j = 0 ; j < N ; j++) {
				func(i,j);
			}
		}
		
		int max = -1;
		for ( int i = 0 ; i < N ; i++) {
			for  (int j = 0 ; j < N ; j++) {
				if ( dp[i][j] > max) {
					max = dp[i][j];
				}
				//System.out.print(dp[i][j]+" ");
			}//System.out.println();
		}
		
		System.out.println(max+1);
	}
	
	public static int func(int x,int y) {
		
		//System.out.println(x+","+y);
		
		int ret = dp[x][y];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if( x+1 < N && mat[x+1][y] > mat[x][y]) {
			ret = Math.max(ret, 1+func(x+1,y) );
		}
		if( x-1 >= 0 && mat[x-1][y] > mat[x][y]) {
			ret = Math.max(ret, 1+func(x-1,y) );
		}
		if( y+1 < N && mat[x][y+1] > mat[x][y]) {
			ret = Math.max(ret, 1+func(x,y+1) );
		}
		if( y-1 >= 0 && mat[x][y-1] > mat[x][y]) {
			ret = Math.max(ret, 1+func(x,y-1) );
		}
		
		return dp[x][y] = ret;
	}
}
