package back3987;

import java.io.*;
import java.util.*;

public class Main {
	static char mat[][];
	static int X[] = {0,0,1,-1};
	static int Y[] = {1,-1,0,0};
	static int R,C;
	static int N,M;
	static int visit[][];
	static int inf = 1000000000;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mat = new char[N][M];
		for (int i = 0 ; i < N ; i++) {
			 char[] tmp = br.readLine().toCharArray();
			for (int j = 0 ; j < M ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int max = -2;
		int maxidx = 0;
		int arr[] = new int[4];
		for (int i = 0;  i < 4 ; i++) {
			visit = new int[N][M];
			int x = BFS(i);
			//System.out.println(x);
			arr[i] = x;
			if ( x > max) {
				max = x;
				maxidx = i;
			}
			
		}
		char res = ' ';
		if ( maxidx == 0 ) {
			res = 'R';
		}else if ( maxidx == 1) {
			res = 'L';
		}else if ( maxidx == 2) {
			res = 'D';
		}else if ( maxidx == 3) {
			res = 'U';
		}
		ArrayList<Character> good = new ArrayList<>();
		for (int i = 0 ; i < 4 ; i++) {
			if ( arr[i] == max) {
				if ( i == 0) {
					good.add('R');
				}else if ( i == 1) {
					good.add('L');
				}else if ( i == 2) {
					good.add('D');
				}else if ( i == 3) {
					good.add('U');
				}
				
			}
		}
		
		if ( good.size() == 1) {
			if ( max == inf) {
				System.out.println(res);
				System.out.println("Voyager");
				return;
			}
			System.out.println(res);
			System.out.println(max);
		}
		else if ( good.size() == 2) {
			if ( good.contains('U') ) {
				if ( max == inf) {
					System.out.println('U');
					System.out.println("Voyager");
					return;
				}
				System.out.println('U');
				System.out.println(max);
			}else if ( !good.contains('U') && good.contains('R') ) {
				if ( max == inf) {
					System.out.println('R');
					System.out.println("Voyager");
					return;
				}
				System.out.println('R');
				System.out.println(max);
			}else if ( !good.contains('U') && !good.contains('R') ) {
				if ( max == inf) {
					System.out.println('D');
					System.out.println("Voyager");
					return;
				}
				System.out.println('D');
				System.out.println(max);
			}
			
		}else if ( good.size() == 3) {
			if ( good.contains('U') ) {
				if ( max == inf) {
					System.out.println('U');
					System.out.println("Voyager");
					return;
				}
				System.out.println('U');
				System.out.println(max);
			}else if ( !good.contains('U')) {
				if ( max == inf) {
					System.out.println('R');
					System.out.println("Voyager");
					return;
				}
				System.out.println('R');
				System.out.println(max);
			}
		}else if ( good.size() == 4) {
			if ( max == inf) {
				System.out.println('U');
				System.out.println("Voyager");
				return;
			}
			System.out.println('U');
			System.out.println(max);
		}
	}
	
	public static int BFS(int firstdirection) {
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(R-1,C-1,firstdirection,0));
		
		while ( !q.isEmpty() ) {
			
			node tmp = q.poll();
			int x = tmp.x;
			int y=  tmp.y;
			int d = tmp.direction;
			int cost = tmp.cost;
			//System.out.println(x+" , "+y+" d:"+d+" cost:"+cost);
			if ( x < 0 || x >= N || y < 0 || y >= M) {
				return cost;
			}
			visit[x][y]++;


			int nx = x + X[d];
			int ny = y + Y[d];
			
			if ( nx < 0 || nx >= N  || ny < 0 || ny >= M) {
				return cost+1;
			}
			if ( mat[nx][ny] == 'C') {
				return cost+1;
			}
			if ( visit[nx][ny] > 2 ) {
				return inf;
			}else {
				if ( d == 0) {
					if ( mat[nx][ny] == '.') {
						q.add(new node(nx,ny,d,cost+1));
					}else if ( mat[nx][ny] == '/') {
						q.add(new node(nx,ny,3,cost+1));
					}else if ( mat[nx][ny] == '\\') {
						q.add(new node(nx,ny,2,cost+1));
					}
				}else if ( d == 1) {
					if ( mat[nx][ny] == '.') {
						q.add(new node(nx,ny,d,cost+1));
					}else if ( mat[nx][ny] == '/') {
						q.add(new node(nx,ny,2,cost+1));
					}else if ( mat[nx][ny] == '\\') {
						q.add(new node(nx,ny,3,cost+1));
					}
				}else if ( d == 2) {
					if ( mat[nx][ny] == '.') {
						q.add(new node(nx,ny,d,cost+1));
					}else if ( mat[nx][ny] == '/') {
						q.add(new node(nx,ny,1,cost+1));
					}else if ( mat[nx][ny] == '\\') {
						q.add(new node(nx,ny,0,cost+1));
					}
				}else {
					if ( mat[nx][ny] == '.') {
						q.add(new node(nx,ny,d,cost+1));
					}else if ( mat[nx][ny] == '/') {
						q.add(new node(nx,ny,0,cost+1));
					}else if ( mat[nx][ny] == '\\') {
						q.add(new node(nx,ny,1,cost+1));
					}
				}
			}
			
		}
		
		return -1;
	
	}
	
	public static class node{
		int direction;  // 0 ~ 3 순서로 동 서 남 북
		int x,y;
		int cost;
		node (int x,int y,int direction,int cost){
			this.x = x;
			this.y= y;
			this.direction = direction;
			this.cost = cost;
		}
		
	}
}
