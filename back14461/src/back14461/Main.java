package back14461;

import java.util.*;

public class Main {
	static int mat[][];
	static int cost[][][];
	static int X[] = {0,1,0,-1};
	static int Y[] = {-1,0,1,0};
	static int N,T;
	static int inf = 1000000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		T = in.nextInt();
		mat = new int[N][N];
		for (int i = 0 ; i< N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		cost = new int[3][N][N];
		for (int s = 0 ; s < 3 ; s++) {
			for (int i = 0 ; i< N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					cost[s][i][j] = inf;
				}
			}
		}
		
		BFS();
		
		int min = inf;
		for ( int s = 0 ; s < 3 ; s++) {
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					System.out.print(cost[s][i][j]+" ");
				}System.out.println();
			}System.out.println("------------");
		}
		
		min = Math.min(min, Math.min(cost[0][N-1][N-1],Math.min(cost[1][N-1][N-1], cost[2][N-1][N-1])));
		
		System.out.println(min);
	}
	
	public static void  BFS() {
		Queue<node> q = new LinkedList<>();
		q.add(new node(0,0,0,0));
		
		while ( !q.isEmpty() ) {
			node now = q.poll();
			int x=  now.x;
			int y= now.y;
			int c = now.cost;
			int count = now.count;
			
			
			for ( int i = 0 ; i < 4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				
				if ( nx >= 0 && ny >= 0 && ny < N && nx < N) {
					if ( count == 2) {
						if ( cost[0][nx][ny] > c + mat[nx][ny] + T) {
							cost[0][nx][ny] = c + mat[nx][ny] + T ;
							q.add(new node(nx,ny,c+mat[nx][ny]+ T,0));
						}
					}else {
						if ( cost[count+1][nx][ny] > c+T) {
							cost[count+1][nx][ny] = c+T;
							q.add(new node(nx,ny,c+T,count+1));
						}
					}
				}
			}
		}
	}
	
	public static class node{
		int x,y;
		int cost;
		int count;
		node (int x,int y,int cost,int count){
			this.x= x;
			this.y =y;
			this.cost = cost;
			this.count = count;
		}
	}
}
