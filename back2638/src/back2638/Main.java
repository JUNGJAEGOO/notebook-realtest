package back2638;

import java.util.*;

public class Main {
	static int X[] = {-1,0,1,0};
	static int Y[] = {0,1,0,-1};
	static int R,C;
	static int mat[][];
	static boolean visit[][];
	static int day = 0;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		R = in.nextInt();
		C = in.nextInt();
		mat = new int[R+2][C+2];
		for (int i = 1 ; i <= R ; i++) {
			for (int j = 1 ; j <= C ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		while ( true ) {
			visit = new boolean[R+2][C+2];
			for (int i = 0 ; i <= C+1 ; i++) {
				if ( visit[0][i] == false) {
					BFS(0,i);
					break;
				}
			}
			
			/*for (int i = 1 ; i<= R;  i++) {
				for (int j = 1 ; j<= C ;j++) {
					System.out.print(mat[i][j]+" ");
				}System.out.println();
			}*/
			
			ArrayList<node> tmp = new ArrayList<>();
			
			for (int i = 1 ; i <= R ; i++) {
				for (int j = 1 ; j<= C ; j++) {
					if ( mat[i][j] == 1) {
						int sum = 0;
						for ( int s = 0 ; s < 4 ; s++) {
							int nx = i + X[s];
							int ny = j + Y[s];
							if ( nx >= 0 && ny >= 0 && nx <= R && ny <= C && mat[nx][ny] == 2) {
								sum++;
							}
						}
						if ( sum >= 2) {
							tmp.add(new node(i,j));
						}
					}
				}
			}
			
			if (tmp.size() == 0) {
				break;
			}
			
			for ( int i = 0 ; i < tmp.size(); i++) {
				int x = tmp.get(i).x;
				int y = tmp.get(i).y;
				mat[x][y] = 2;
			}
			
			day++;
			
		}
		
		System.out.println(day);
	}
	
	public static void BFS(int startX,int startY) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(startX,startY));
		visit[startX][startY] = true;
		
		while ( !q.isEmpty() ) {
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			
			for (int i = 0 ; i < 4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				if ( nx>= 0 && nx <= R+1 && ny >= 0 && ny <= C+1 && (mat[nx][ny] == 0 || mat[nx][ny] == 2) && visit[nx][ny] == false) {
					visit[nx][ny] = true;
					mat[nx][ny] = 2;
					q.add(new node(nx,ny));
				}
			}
		}
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x = x;
			this.y =y;
		}
	}
}
