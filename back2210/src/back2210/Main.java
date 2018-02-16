package back2210;

import java.util.*;

public class Main {
	static int mat[][];
	static int X[] = {-1,0,1,0};
	static int Y[] = {0,1,0,-1};
	static ArrayList<String> visit = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		mat = new int[5][5];
		for (int i = 0 ; i < 5 ; i++) {
			for (int j = 0 ; j <5 ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		for (int i = 0 ; i <5 ; i++) {
			for (int j = 0 ; j < 5 ; j++) {
				BFS(i,j);
			}
		}
		
		System.out.println(visit.size());
		
	}
	
	public static void BFS(int startX,int startY) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(startX,startY,String.valueOf(mat[startX][startY])));
		while ( !q.isEmpty() ) {
			node tmp = q.poll();
			int x= tmp.x;
			int y = tmp.y;
			String now = tmp.now;
			if ( now.length() == 6) {
				if ( !visit.contains(now) ) {
					visit.add(now);
				}
				continue;
			}
			
			for (int i = 0 ; i <4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				if ( nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
					q.add(new node(nx,ny,now+String.valueOf(mat[nx][ny])));
				}
			}
		}
		
	}
	
	public static class node{
		String now;
		int x,y;
		node (int x,int y,String now){
			this.x = x;
			this.y = y;
			this.now = now;
		}
	}
	
}
