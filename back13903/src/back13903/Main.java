package back13903;

import java.util.*;

public class Main {
	static int R,C;
	static int mat[][];
	static int cost[][];
	static int inf = 100000000;
	static ArrayList<Integer> X = new ArrayList<>();
	static ArrayList<Integer> Y = new ArrayList<>();;
	static ArrayList<node> starting = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		R = in.nextInt();
		C = in.nextInt();
		mat = new int[R][C];
		
		for (int i = 0 ; i < R ; i++) {
			for (int j = 0 ; j < C ; j++) {
				
				mat[i][j] = in.nextInt();
				if ( i == 0 && mat[i][j] == 1) {
					starting.add(new node(i,j,0));
				}
			}
		}
		
		int M = in.nextInt();
		for (int i = 0 ; i < M ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			X.add(x);
			Y.add(y);
		}
		cost = new int[R][C];
		for (int s = 0 ; s < R ; s++) {
			for (int k = 0 ; k < C ; k++) {
				cost[s][k] = inf;
			}
		}
		int min = inf;
		
			BFS(starting);
			
			
			for (int k = 0 ; k < C ; k++) {
				if ( mat[R-1][k] == 1) {
					min = Math.min(min, cost[R-1][k]);
				}
			}
			
			/*for (int s = 0 ; s < R ; s++) {
				for (int k = 0 ; k < C ; k++) {
					System.out.print(cost[s][k]+" ");
				}System.out.println();
			}System.out.println("---------");
		*/
		if ( min == inf) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		
	}
	
	public static void BFS(ArrayList<node> starts) {
		Queue<node> q= new LinkedList<>();
		for (int i = 0 ; i < starts.size() ; i++) {
			q.add(new node(starts.get(i).x,starts.get(i).y,0));
			cost[starts.get(i).x][starts.get(i).y] = 0;
		}
		
		while ( !q.isEmpty()) {
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			int c = now.cost;
			for (int i =0 ; i < X.size(); i++) {
				int nx = x + X.get(i);
				int ny = y + Y.get(i);
				if ( nx >= 0 && nx < R && ny >= 0 && ny < C) {
					if ( mat[nx][ny] == 1 && cost[nx][ny] > c + 1 ) {
						cost[nx][ny] = c + 1;
						q.add(new node(nx,ny,c+1));
					}
				}
			}
		}
		
		
	}
	
	public static class node{
		int x,y;
		int cost;
		node(int x,int y,int cost){
			this.x =x;
			this.y = y;
			this.cost = cost;
		}
	}
}
