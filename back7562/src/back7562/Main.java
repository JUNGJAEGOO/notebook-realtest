package back7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int mat[][];
	static boolean visit[][];
	static int startX,startY;
	static int endX,endY;
	static int inf = 1900000000;
	static int X[] = {-1,-2,-2,-1,1,2,2,1};
	static int Y[] = {2,1,-1,-2,-2,-1,1,2}; 
	
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T>0) {
			T--;
		
			N = in.nextInt();
			//mat = new int[N+2][N+2];
			visit = new boolean[N+2][N+2];
			
			for (int i = 0 ; i <= N+1 ; i++) {
				for (int j = 0 ; j <= N+1 ; j++) {
					visit[i][j] = false;
				}
			}
			
			startX = in.nextInt();
			startY = in.nextInt();
			endX = in.nextInt();
			endY = in.nextInt();
			
			BFS();
			
			/*for (int i = 0 ; i<= N-1 ; i++) {
				for (int j = 0 ; j<= N-1 ; j++) {
					System.out.print(visit[i][j]+" ");
				}System.out.println();
			}*/
			
			//System.out.println(visit[endX][endY]);
		}
		
		
	}
	
	public static void BFS() {
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(startX,startY,0));
		visit[startX][startY] = true;
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			int cost = now.cost;
			if ( x == endX && y == endY) {
				System.out.println(cost);
			}
			
			//System.out.println(x+" "+y);
			
			for (int i = 0 ; i < 8 ; i++) {
				int nextX = x+X[i];
				int nextY = y+Y[i];
				if ( nextX >= 0 && nextX <= N- 1 && nextY >= 0 && nextY <= N-1) {
					if ( visit[nextX][nextY] == false) {
						q.add(new node(nextX,nextY,cost+1));
						visit[nextX][nextY] = true;
					}
				}
			}
			
		}
		
	}
	
	public static class node{
		int x,y;
		int cost;
		node( int x,int y, int cost){
			this.x =x;
			this.y = y;
			this.cost = cost;
		}
	}
}
