package back1103;

import java.util.*;

public class Main {
	static int R,C;
	static char mat[][];
	static int dp[][];
	static boolean visit[][];
	static int X[] = {0,0,1,-1};
	static int Y[] = {1,-1,0,0};
	
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(" ");
		R = Integer.parseInt(info[0]);
		C = Integer.parseInt(info[1]);
		
		mat = new char[R][C];
		dp = new int[51][51];
		for ( int i = 0 ; i < R ; i++) {
			char[] tmp = in.nextLine().toCharArray();
			for ( int j = 0 ; j < C ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		
		for (int i = 0 ; i < 51 ; i++) {
			for ( int j = 0 ; j < 51 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		visit = new boolean[R][C];
		
		System.out.println(func(0,0));
	}
	
	public static int func(int r,int c) {
		
		//System.out.println(r+" "+c);
		
		if ( r < 0 || c < 0 || r >= R || c >= C || mat[r][c] == 'H') {
			return 0;
		}
		
		if ( visit[r][c]) {
			System.out.println(-1);
			System.exit(0);
		}

		
		int ret = dp[r][c];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		visit[r][c] = true;
 		for ( int i = 0 ; i < 4 ; i++) {
			int nx = r + Integer.parseInt(String.valueOf(mat[r][c]))*X[i];
			int ny = c + Integer.parseInt(String.valueOf(mat[r][c]))*Y[i];
			
			ret  = Math.max(ret, 1 + func(nx,ny));
			
		}
 		visit[r][c] = false;
		
		return dp[r][c] = ret;
	}
}
