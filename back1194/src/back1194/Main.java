package back1194;

import java.util.*;

public class Main {
	static int R,C;
	static char mat[][];
	static int sX,sY;
	static int cost[][][];
	static int X[] = {1,0,-1,0};
	static int Y[] = {0,1,0,-1};
	static int inf = 1000000000;
	static int ans = inf;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		mat = new char[R][C];
		for (int i = 0 ; i < R ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			for (int j = 0 ; j < C ; j++) {
				mat[i][j] = tmp[j];
				if ( mat[i][j] == '0' ) {
					sX = i;
					sY = j;
				}
				
			}
		}
		
		cost = new int[(1<<6)+1][R][C];
		for (int i = 0 ; i <= 1<<6 ; i++) {
			for (int j = 0 ; j < R ; j++) {
				for (int k = 0 ; k < C ; k++) {
					cost[i][j][k] = inf;
				}
			}
		}
		
		
		BFS();
		
		if ( ans == inf) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();

		q.add(new node(sX,sY,0,0));
		cost[0][sX][sY] = 0;
		
		while ( !q.isEmpty() ) {
			node now = q.poll();
			int x =now.x;
			int y= now.y;
			int c = now.cost;
			int visit = now.visit;
			System.out.println(x+","+y+" "+c+" v: "+visit);
			if ( mat[x][y] == '1') {
				ans = Math.min(ans, c);
			}
			
			for (int i = 0 ; i <4 ; i++) {
				int nx = x+X[i];
				int ny = y+Y[i];
				if ( nx >= 0 && ny >= 0 && nx < R && ny < C) {
					if ( mat[nx][ny] == '.' || mat[nx][ny] == '1' || mat[nx][ny] == '0') {
						if (cost[visit][nx][ny] > c + 1) {
							cost[visit][nx][ny] = c + 1;
							q.add(new node(nx,ny,visit,c+1));
						}
					}else if ( mat[nx][ny] >= 'a' && mat[nx][ny] <= 'z') {
						if ( cost[visit][nx][ny] > c + 1  ) {
							cost[visit][nx][ny] = c + 1;
							if ( ( visit & 1<<(mat[nx][ny]-'a') ) != 0) {
								q.add(new node(nx,ny,visit,c+1));
							}else {
								q.add(new node(nx,ny,visit|1<<((int)(mat[nx][ny])-'a'),c+1));
							}
						}
					}else if ( mat[nx][ny] >= 'A' && mat[nx][ny] <= 'Z') {
						
						if ( ( visit & (1<<mat[nx][ny]-'A') ) != 0) {
				
							if ( cost[visit][nx][ny] > c + 1 ) {
								cost[visit][nx][ny] = c + 1;
								q.add(new node(nx,ny,visit,c+1));
							}
						}
					}
				}
			}
		}
	}
	
	public static class node{
		int x,y;
		int visit;
		int cost;
		
		node (int x,int y,int visit,int cost){
			this.x=x;
			this.y=y;
			this.visit = visit;
			this.cost = cost;
		}
	}
}
