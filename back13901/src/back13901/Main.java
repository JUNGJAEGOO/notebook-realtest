package back13901;

import java.util.*;

public class Main {
	static int R,C;
	static int mat[][];
	static int count[][];
	static boolean visit[][];
	static ArrayList<Integer> command = new ArrayList<>();
	public static void main(String args[]) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		R = in.nextInt();
		C = in.nextInt();
		mat = new int[R][C];
		visit = new boolean[R][C];
		count = new int[R][C];
		int b = in.nextInt();
		for (int i = 0 ; i < b ; i++) {
			int br = in.nextInt();
			int bc = in.nextInt();
			mat[br][bc] = -1;
		}
		int sx = in.nextInt();
		int sy = in.nextInt();
		for (int i = 0 ; i < 4 ; i++) {
			command.add(in.nextInt()-1);
		}
		
		BFS(sx,sy);
	}
	
	public static void BFS(int sx,int sy) throws InterruptedException {
		Queue<node> q = new LinkedList<>();
		q.add(new node(sx,sy,0));
		visit[sx][sy] = true;
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int x=  now.x;
			int y = now.y;
			int idx = now.idx;
			System.out.println(x+" "+y+" "+idx);
			if ( count[x][y] > 5) {
				System.out.println(x+" "+y);
				break;
			}
			
			int com = command.get(idx);
			// 0 1 2 3 순으로 상 하 좌 우
			if ( com == 0) {
				int nx = x - 1;
				int ny = y;
				if ( nx < 0 || mat[nx][ny] == -1 || visit[nx][ny] == true) {
					q.add(new node(x,y,(idx+1)%4));
					count[x][y]++;
				}else {
					visit[nx][ny] = true;
					q.add(new node(nx,ny,idx));
				}
			}else if ( com == 1) {
				int nx = x + 1;
				int ny = y;
				if ( nx >= R || mat[nx][ny] == -1 || visit[nx][ny] == true) {
					q.add(new node(x,y,(idx+1)%4));
					count[x][y]++;
				}else {
					visit[nx][ny] = true;
					q.add(new node(nx,ny,idx));
				}
			}else if ( com == 2) {
				int nx = x;
				int ny = y-1;
				if ( ny < 0 || mat[nx][ny] == -1 || visit[nx][ny] == true) {
					q.add(new node(x,y,(idx+1)%4));
					count[x][y]++;
				}else {
					visit[nx][ny] = true;
					q.add(new node(nx,ny,idx));
				}
			}else {
				int nx = x;
				int ny = y+1;
				if ( ny >= C || mat[nx][ny] == -1 || visit[nx][ny] == true) {
					q.add(new node(x,y,(idx+1)%4));
					count[x][y]++;
				}else {
					visit[nx][ny] = true;
					q.add(new node(nx,ny,idx));
				}
			}
			
		}
	}
	
	public static class node{
		int x,y;
		int idx;
		node (int x,int y,int idx){
			this.x =x;
			this.y =y;
			this.idx = idx;
		}
	}
}
