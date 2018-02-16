package back2665;

import java.util.*;

import javax.xml.soap.Node;

public class Main {
	static int mat[][];
	static int cost[][];
	static int X[] = {0,1,0,-1};
	static int Y[] = {1,0,-1,0};
	static int inf = 1000000000;
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = Integer.parseInt(in.nextLine());
		mat = new int[N][N];
		cost = new int[N][N];
		for (int i = 0 ; i < N ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = Integer.parseInt(String.valueOf(tmp[j]));
			}
		}
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				cost[i][j] = inf;
			}
		}
		
		BFS();
		
		/*for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				System.out.print(cost[i][j]);
			}System.out.println();
		}*/
		
		System.out.println(cost[N-1][N-1]);
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		q.add(new node(0,0,0));
		cost[0][0] = 0;
		while ( !q.isEmpty()) {
			node now = q.poll();
			int x = now.x;
			int y=  now.y;
			int c = now.cost;
			
			for (int i = 0 ; i < 4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				if ( nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if ( mat[nx][ny] == 1) {
						if ( cost[nx][ny] > c ) {
							q.add(new node(nx,ny,c));
							cost[nx][ny] = c;
						}
					}else {
						if ( cost[nx][ny] > c + 1) {
							q.add(new node(nx,ny,c+1));
							cost[nx][ny] = c + 1;
						}
					}
				}
			}
		}
	}
	
	public static class node{
		int x,y;
		int cost;
		node (int x,int y,int cost){
			this.x= x;
			this.y = y;
			this.cost = cost;
		}
	}
}
