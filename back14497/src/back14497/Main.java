package back14497;

import java.util.*;

public class Main {
	static char mat[][];
	static int N,M;
	static int x1,y1,x2,y2;
	static int ans = 10000000;
	static int X[] = {0,0,1,-1};
	static int Y[] = {1,-1,0,0,};
	
	public static void main(String args[]) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(" ");
		N = Integer.parseInt(info[0]);
		M = Integer.parseInt(info[1]);
		
		String position[] = in.nextLine().split(" ");
		x1 = Integer.parseInt(position[0]) -1;
		y1 = Integer.parseInt(position[1]) -1;
		x2 = Integer.parseInt(position[2]) -1;
		y2 = Integer.parseInt(position[3]) -1;
		
		
		mat = new char[N][M];
		for ( int i = 0 ; i < N ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			for ( int j = 0 ; j < M ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		
		BFS();
		
	}
	
	public static void BFS() throws InterruptedException {
		Queue<node> q = new LinkedList<>();
		boolean visit[][] = new boolean[N][M];
		int count = 1;
		ArrayList<node> delete = new ArrayList<>();
		
		lop:
		while ( true ) {
			
			visit = new boolean[N][M];
			q.add(new node(x1,y1,1));
			visit[x1][y1] = true;
			
			while ( !q.isEmpty() ) {
				node now = q.poll();
				int x = now.x;
				int y = now.y;
				int cnt  = now.cnt;
				//System.out.println(x+" "+y+" "+cnt);
				
				if ( x == x2 && y == y2) {
					System.out.println(count);
					break lop;
				}
				if ( cnt == 0) {
					continue;
				}
				
				for ( int i = 0 ; i < 4 ; i++) {
					int nx = x + X[i];
					int ny = y + Y[i];
					
					if ( nx >= 0 && ny >=0 && nx < N && ny < M && visit[nx][ny] == false) {

						if ( mat[nx][ny] == '0' || mat[nx][ny] == '#' ) {
							q.add(new node(nx,ny,cnt));
							visit[nx][ny] = true;
						}else if ( mat[nx][ny] == '1' ) {
							delete.add(new node(nx,ny,0));
						}
						
					}
					
				}
				
			}
			
			//Thread.sleep(500);
			
			for ( int i = 0 ; i < delete.size() ; i++) {
				int x = delete.get(i).x;
				int y = delete.get(i).y;
				mat[x][y] = '0';
			}
			delete  = new ArrayList<>();
			
			/*for (int i= 0 ; i < N ; i++) {
				for ( int j = 0 ; j < M ; j++) {
					System.out.print(mat[i][j]);
				}System.out.println();
			}System.out.println();
			*/
			
			count++;
			
		}
		
	}
	
	public static class node{
		int x,y;
		int cnt;
		node (int x,int y,int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
