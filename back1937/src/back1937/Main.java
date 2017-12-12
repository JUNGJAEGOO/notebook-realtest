package back1937;

import java.util.*;

public class Main {
	static int mat[][];
	static int dp[][];
	static Stack<data> st = new Stack<data>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		mat = new int[N+2][N+2];
		dp = new int[N+2][N+2];
		
		for(int i =0; i <= N+1 ; i++ ) {
			for (int j = 0 ; j <= N+1 ; j++) {
				mat[i][j] = -1;
			}
		}
		
		for(int i = 1 ; i <= N ; i++ ) {
			for (int j = 1 ; j <= N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		for(int i = 1 ; i <= N ; i++ ) {
			for (int j = 1 ; j <= N ; j++) {
				DFS(i,j);
			}
		}
		
		int max = 0;
		for(int i = 1 ; i <= N ; i++ ) {
			for (int j = 1 ; j <= N ; j++) {
				System.out.print(dp[i][j]+" ");
				if ( dp[i][j] > max) {
					max = dp[i][j];
				}
			}System.out.println();
		}
		
		System.out.println(max);
	}
	
	public static int DFS(int X,int Y) {
		
		
		st.add(new data(X,Y));
		
		data tmp = st.pop();
		int x = tmp.x;
		int y = tmp.y;
		//int day = tmp.day;
		
		if ( dp[x][y] != 0) {
			return dp[x][y];
		}
		
		dp[x][y] = 1;
		
		if ( mat[x+1][y] != -1 && mat[x+1][y] > mat[x][y]) {
			dp[x][y] = Math.max(dp[x][y], DFS(x+1,y)+1);
		}
		if ( mat[x-1][y] != -1 && mat[x-1][y] > mat[x][y]) {
			dp[x][y] = Math.max(dp[x][y], DFS(x-1,y)+1);
		}
		if ( mat[x][y+1] != -1 && mat[x][y+1] > mat[x][y]) {
			dp[x][y] = Math.max(dp[x][y], DFS(x,y+1)+1);
		}
		if ( mat[x][y-1] != -1 && mat[x][y-1] > mat[x][y]) {
			dp[x][y] = Math.max(dp[x][y], DFS(x,y-1)+1);
		}
		
		return dp[x][y];
	}
	
	public static class data{
		int x,y;
		int day;
		data(int x, int y){
			this.x = x;
			this.y = y;
			//this.day =day;
		}
	}
}
