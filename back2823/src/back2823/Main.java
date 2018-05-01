package back2823;

import java.util.*;

public class Main {
	
	static int R,C;
	static char mat[][];
	static ArrayList<node> list = new ArrayList<>();
	static boolean visit[][];
	static int X[] = {0,0,1,-1};
	static int Y[] = {1,-1,0,0};
	static boolean vis[][];
	static boolean pass = false;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		String info[] = in.nextLine().split(" ");
		R = Integer.parseInt(info[0]);
		C = Integer.parseInt(info[1]);
		
		mat = new char[R][C];
		
		for ( int i = 0 ; i < R ; i++) {
			char[] tmp = in.nextLine().toCharArray();
			for ( int j = 0 ; j < C ; j++) {
				mat[i][j] = tmp[j];
				if ( mat[i][j] == '.') {
					list.add(new node(i,j));
				}
			}
		}
		
		visit = new boolean[R][C];
		
		boolean pass = BFS(list.get(0).x,list.get(0).y);
		
		if ( !pass) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
		
	}
	
	public static boolean BFS(int sX,int sY) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(sX,sY));
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			
			int cnt = 0;
			for ( int i = 0 ; i < 4 ; i++) {
				
				int nx = X[i] + x;
				int ny = y + Y[i];
				
				if ( nx>=0 && ny>=0 && nx < R && ny < C) {

						
						if ( mat[nx][ny] == '.') {
							cnt++;
							if ( visit[nx][ny] == false) {
								visit[nx][ny] = true;
								q.add(new node(nx,ny));
							}
						}
						
					
					
				}
				
			}
			
			//System.out.println(x+","+y+" "+cnt);
			if ( cnt <= 1) {
				return false;
			}
			
			
		}
		
		return true;
	}
	
	public static class node{
		int x,y;

		node (int x,int y){
			this.x =x ;
			this.y = y;
		}
	}
}
