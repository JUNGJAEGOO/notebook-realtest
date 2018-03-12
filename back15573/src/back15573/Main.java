package back15573;

import java.util.*;

public class Main {
	static int mat[][];
	static int N,M;
	static int X[] = {-1,0,1,0};
	static int Y[] = {0,1,0,-1};
	static boolean visit[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		int K = in.nextInt();
		mat = new int[N][M];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		int left = 0;
		int right = 100000000;
		int ans = 0;
		while ( left <= right) {
			
			int mid = (left + right) / 2 ;
			visit = new boolean[N][M];
			int res = BFS(mid);
			System.out.println(res+" "+mid);
			if ( res < K) {
				left = mid + 1;
				
			}else {
				right = mid - 1;
				ans = mid;
			}

		}
		
		System.out.println(ans);
		
	}
	
	public static int BFS(int target) {
		Queue<node> q = new LinkedList<>();
		int count = 0;
		
		for ( int i = 0 ; i < M ; i++) {
			if ( mat[0][i] <= target) {
				q.add(new node(0,i));
				visit[0][i] = true;
			}
		}
		
		for ( int i = 0 ; i < N ; i++) {
			if ( visit[i][0] == false && mat[i][0] <= target) {
				q.add(new node(i,0));
				visit[i][0] = true;
			}
			if ( visit[i][M-1] == false && mat[i][M-1] <= target) {
				q.add(new node(i,M-1));
				visit[i][M-1] = true;
			}
		}
		
		
		while ( !q.isEmpty() ) {
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			//System.out.println(x+" "+y+"     "+target);
			count++;
			
			for ( int i = 0 ; i< 4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				
				if ( nx >=0 && ny>= 0 && nx < N && ny < M) {
					if ( mat[nx][ny] <= target && visit[nx][ny] == false) {
						visit[nx][ny] = true;
						q.add(new node(nx,ny));
					}
				}
			}
		}
		
		return count;
	}
	
	public static class node{
		int x,y;
		node(int x,int y){
			this.x =x;
			this.y= y;
		}
	}
}
