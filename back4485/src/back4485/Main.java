package back4485;
import java.util.*;
import java.io.*;
public class Main {
	
	static int mat[][];
	static int X[] = {0,1,0,-1};
	static int Y[] = {-1,0,1,0};
	static int cost[][];
	static int N;
	static int inf = 1000000000;
	
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(System.in);
		int cnt = 1;
		while ( true) {
			N = in.nextInt();
			if ( N == 0) {
				break;
			}
			mat = new int[N][N];
			cost = new int [N][N];
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					mat[i][j] = in.nextInt();
					cost[i][j] = inf;
				}
			}
			
			BFS();
			
			System.out.println("Problem "+cnt+": "+cost[N-1][N-1]);
			cnt++;
			
		}
	
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		q.add(new node(0,0,mat[0][0]));
		while(!q.isEmpty()) {
			
			node tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int c = tmp.cost;
			//System.out.println(x+","+y+" : "+c);
			
			for (int i = 0 ; i < 4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				if ( nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if ( cost[nx][ny] > c + mat[nx][ny]) {
						cost[nx][ny] = c + mat[nx][ny];
						q.add(new node(nx,ny,c+mat[nx][ny]));
					}
		
				}
				
			}
			
			
		}
	}
	
	public static class node{
		int x,y;
		int cost;
		node (int x,int y,int cost){
			this.x =x;
			this.y =y;
			this.cost = cost;
		}
	}

}
