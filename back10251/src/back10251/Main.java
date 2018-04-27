package back10251;

import java.util.*;

public class Main {
	static int M,N,L,G;
	static int mat[][];
	static int cost[][];
	static int X[] = {1,0};
	static int Y[] = {0,1};
	static int time[][][][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for ( int testcase  = 0 ; testcase < T ; testcase++) {
			
			M = in.nextInt(); // 4 , 6
			N = in.nextInt();
			L = in.nextInt();
			G = in.nextInt();
			
			mat = new int[M][N];
			cost = new int[M*N+1][M*N+1];
			for ( int i = 0 ; i < M ; i++) {
				for ( int j = 0 ; j < N-1 ; j++) {
					int x = in.nextInt();
					cost[i*N+j][i*N+j+1] = x;
					cost[i*N+j+1][i*N+j] = x;
				}
			}
			
			for ( int i = 0 ; i < M-1 ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					int x = in.nextInt();
					cost[i*N+j][(i+1)*N+j] = x;
					cost[(i+1)*N+j][i*N+j] = x;
					
				}
			}
			
			time = new int[2][M][N][201];
			for ( int i = 0 ; i < M ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					
					for ( int k = 0 ; k < 201 ; k++) {
						time[0][i][j][k] = -1;
						time[1][i][j][k] = -1;
					}
				}
			}
			
			System.out.println(Math.min(DFS(0,0,0,0), DFS(0,0,0,1)));
			
		}
	}
	
	public static int DFS(int rPos,int cPos,int turn,int dir) {
		
		if ( rPos >= M || cPos >= N) {
			return Integer.MAX_VALUE;
		}
		
		if ( rPos == M-1 && cPos == N-1) {
			return 0;
		}
		
		int ret = time[dir][rPos][cPos][turn];
		if ( ret != -1) {
			return ret;
		}
		ret = Integer.MAX_VALUE;
		
		if ( dir == 0) { // 위에서 내려옴
			
			ret = Math.min(DFS(rPos+1,cPos,turn,0), DFS(rPos,cPos+1,turn+1,1));
			
		}else {
			
			ret = Math.min(DFS(rPos+1,cPos,turn,0), DFS(rPos,cPos+1,turn+1,1));
			
			
		}
		
		return time[dir][rPos][cPos][turn] = ret;
		
	}
	
	public static class node{
		int x,y;
		int time;
		int L;
		int dir;
		int turn;
		
		node (int x,int y,int time,int L,int dir,int turn){
			this.x = x;
			this.y = y;
			this.time = time;
			this.L = L;
			this.dir = dir;
			this.turn = turn;
		}
	}
}
