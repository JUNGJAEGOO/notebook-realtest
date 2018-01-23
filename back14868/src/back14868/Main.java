package back14868;

import java.util.*;

public class Main {
	static int map[][];
	static boolean visit[][];
	static int[] X = new int[4];
	static int[] Y = new int[4];
	static int N;
	
	static ArrayList<node> initial= new ArrayList<>();
	static ArrayList<node> now = new ArrayList<>();
	static ArrayList<node> tmpnow = new ArrayList<>();
	
	public static void main(String args[]) {
		X[0] = 0; X[1] = 1; X[2] = 0; X[3] = -1;
		Y[0] = 1; Y[1] = 0; Y[2] = -1; Y[3] = 0;
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int K = in.nextInt();
		map = new int[N+2][N+2];
		visit = new boolean[N+2][N+2];
		for ( int i = 0 ; i < K ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			map[x][y] = 1;
			initial.add(new node(x,y));
			now.add(new node(x,y));
		}
		
		int cnt = 0;
		while ( true) {
			
			int nX = initial.get(0).x;
			int nY = initial.get(0).y;
			
			visit = new boolean[N+2][N+2];
			
			BFS(nX,nY);
			
			boolean pass = true;
			for ( int i = 0 ; i < initial.size() ; i++ ) {
				int nextX = initial.get(i).x;
				int nextY = initial.get(i).y;
				if ( visit[nextX][nextY] == false) {
					pass = false;
					break;
				}
			}
			
			if ( pass) {
				System.out.println(cnt);
				return;
			}
			cnt++;
			
			// 확장 정책
			
			tmpnow = new ArrayList<>();
			for ( int i = 0 ; i < now.size() ; i++) {
				int nowX = now.get(i).x;
				int nowY = now.get(i).y;
				for ( int j = 0 ; j < 4 ; j++) {
					if ( nowX+X[j] < 1 || nowX+X[j] > N || nowY+Y[j] > N || nowY+Y[j] < 1) {
						continue;
					}else {
						if ( map[nowX+X[j]][nowY+Y[j]] == 0) {
							map[nowX+X[j]][nowY+Y[j]] = 1;
							tmpnow.add(new node(nowX+X[j],nowY+Y[j]));
						}
					}
				}
			}
			
			/*for ( int i = 1 ; i<= N ; i++) {
				for ( int j = 1 ; j<= N ; j++) {
					System.out.print(map[i][j]+" ");
				}System.out.println();
			}
			System.out.println();	*/
			
			now = new ArrayList<>();
			for (int i = 0 ; i < tmpnow.size() ; i++) {
				now.add(new node(tmpnow.get(i).x,tmpnow.get(i).y));
			}
			
		}
	}
	
	public static void BFS(int sX,int sY) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(sX,sY));
		visit[sX][sY] = true;
		
		while ( !q.isEmpty() ) {
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			
			for ( int i = 0 ; i < 4 ; i++) {

				if ( x+X[i] < 1 || x+X[i] > N || y+Y[i] > N || y+Y[i] < 1) {
					continue;
				}
				if ( visit[x+X[i]][y+Y[i]] == false) {
					if ( map[x+X[i]][y+Y[i]] == 1) {
						visit[x+X[i]][y+Y[i]] = true;
						q.add(new node(x+X[i],y+Y[i]));
					}
				}
			}
			
		}
		
	}
	
	public static class node{
		int x,y;
		node(int x,int y){
			this.x =x;
			this.y =y;
		}
	}
}

