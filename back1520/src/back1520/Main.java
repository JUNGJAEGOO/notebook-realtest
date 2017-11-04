package back1520;
import java.util.*;
public class Main {
	static int mat[][];
	static int N, M;
	static int result = 0;
	static int dp[][];
	static int directx[] = {-1,1,0,0};
	static int directy[] = {0,0,-1,1};
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M  = in.nextInt();
		dp = new int[N][M];
		mat = new int[N][M];
		for ( int i = 0 ; i < N  ; i ++) {
			for ( int j  = 0 ; j < M  ; j++) {
				mat[i][j] = in.nextInt();
				dp[i][j] = -1;
			}
		}
		
		
		//DFS(1,1);
		
		dp[N-1][M-1] = 1;
		System.out.println(DFS(0,0));
		
		for( int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j< M ; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int DFS(int x,int y) {
		if ( x== M-1 && y == N-1) {
			return 1;
		}
		
		if ( dp[x][y] >= 0 ) {
			return dp[x][y];
		}
		
		if ( dp[x][y] == -1) {
		dp[x][y] = 0;
		}
		
		for ( int i = 0 ; i < 4 ; i++) {
			int nx = directx[i] + x;
			int ny = directy[i] + y;
			if ( nx >= 0 && nx < N && 0<=ny && ny<M) {
				if ( mat[x][y] > mat[nx][ny]) {
				dp[x][y] += DFS(nx,ny);
				}
			}
		}
		return dp[x][y];
	}

}
