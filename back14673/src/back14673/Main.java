package back14673;

import java.util.*;

public class Main {
	static int N,M;
	static int mat[][];
	static int best = 0;
	static int nowpoint = 0;
	static int X[]= {-1,0,1,0};
	static int Y[] = {0,1,0,-1};
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		M = in.nextInt();
		N = in.nextInt();
		mat = new int[N][M];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < M ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		BFS();
		
		System.out.println(best);
		
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		
		int origin[][] = new int[N][M];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < M ; j++) {
				origin[i][j] = mat[i][j];
			}
		}
		
		for ( int i = 0 ; i < N ; i ++) {
			for ( int j = 0 ; j < M ; j++) {
				if ( origin[i][j] != 0 ) {
					
					int copy[][] = new int[N][M];
					for ( int s = 0 ; s < N ; s++) {
						for (int k = 0 ; k < M ; k++) {
							copy[s][k] = origin[s][k];
						}
					}
					
					int arr[][] = delete(i,j,copy);
	
					
					q.add(new node(arr,1,nowpoint));
					
				}
			}
		}
		
		
		
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int cnt = now.cnt;
			int point = now.point;
			int map[][] = now.map;
			best = Math.max(best, point);
			if ( cnt == 3) {

				continue;
				
			}
			
			for ( int i = 0 ; i < N ; i ++) {
				for ( int j = 0 ; j < M ; j++) {
					if ( map[i][j] != 0 ) {
						
						int copy[][] = new int[N][M];
						for ( int s = 0 ; s < N ; s++) {
							for (int k = 0 ; k < M ; k++) {
								copy[s][k] = map[s][k];
							}
						}
						
						int arr[][] = delete(i,j,copy);
						
						q.add(new node(arr,cnt+1,point+nowpoint));
						
					}
				}
			}
			
		}
	}
	
	public static int[][] delete(int x,int y,int map[][]) {
		Queue<points> q = new LinkedList<>();
		boolean visit[][] = new boolean[N][M];
		q.add(new points(x,y));
		visit[x][y] = true;
		int target = map[x][y];
		map[x][y] = 0;

		int cnt = 0;
		
		while ( !q.isEmpty() ) {
			
			points now = q.poll();
			int xx = now.x;
			int yy = now.y;
			cnt++;
			
			for ( int i = 0 ; i < 4 ; i++) {
				int nx = xx + X[i];
				int ny = yy + Y[i];
				if ( nx >= 0 && ny >= 0 && nx < N && ny < M ) {
					if ( visit[nx][ny] == false && map[nx][ny] == target)
					{
						map[nx][ny] = 0;
						visit[nx][ny] = true;
						q.add(new points(nx,ny));
					}
				}
			}	
		}
		
		int arr[][] = new int[N][M];
		for ( int i = 0 ; i < M ; i++) {
			
			ArrayList<Integer> list = new ArrayList<>();
			for ( int j = N-1 ; j >=0  ; j--) {
				if ( map[j][i] != 0 ) {
					list.add(map[j][i]);
				}
			}
			
			//System.out.println(list);
			int idx = 0;
			for ( int j = N-1 ; j>= 0 ; j--) {
				
				if ( idx >= list.size() ) {
					break;
				}
				arr[j][i] = list.get(idx);
				idx++;
				
			}
			
		}

		nowpoint = cnt * cnt;
		return arr;
	}
	
	public static class points{
		int x,y;
		points(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static class node{
		int map[][];
		int cnt;
		int point;
		node ( int map[][], int cnt,int point){
			this.map = map;
			this.cnt = cnt;
			this.point = point;
		}
	}
}
