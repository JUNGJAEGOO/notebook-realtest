package back14948;

import java.util.*;

public class Main {
	static int N,M;
	static int mat[][];
	static int X[] = {0,0,1,-1};
	static int Y[] = {1,-1,0,0};
	static int go[][][];
	static int inf = Integer.MAX_VALUE;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		mat = new int[N][M];
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < M ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		go = new int[N][M][2];
		
		for  (int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < M ; j++) {
				for ( int k = 0 ; k < 2 ; k++) {
					go[i][j][k] = -1;
				}
				
			}
		}
		
	}
	
	public static int DFS(int x,int y,int jump,int max) {
		
		if ( x == N-1 && y == M-1) {
			return max;
		}
			
		int ret = go[x][y][jump];
		
		if ( ret != -1) {
			return ret;
		}
		ret = inf;
		
		if ( jump == 0) {
		
			for( int i = 0 ; i < 4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				if( nx >= 0 && ny >= 0 && nx <N && ny< M) {
					
					if ( max >= mat[nx][ny] ) {
						DFS(nx,ny,0,max);
					}else {
						DFS(nx,ny,0,mat[nx][ny]);
					}
					
				}
			}
			
		}else {
			
			for( int i = 0 ; i < 4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				if( nx >= 0 && ny >= 0 && nx <N && ny< M) {
					
					
					if ( max >= mat[nx][ny] ) {
						DFS(nx,ny,jump,max);
					}else {
						DFS(nx,ny,jump,mat[nx][ny]);
					}
					
				}
			}
			
			
			
		}
		
		
		return go[x][y][jump] = ret;
		
	}
	
	public static class node{
		int x,y;
		int level;
		int cnt;
		int dir;
		node( int x,int y,int level,int cnt,int dir){
			this.level = level;
			this.x= x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
}
