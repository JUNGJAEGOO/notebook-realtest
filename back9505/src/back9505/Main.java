package back9505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static HashMap<String,Integer> hm;
	static char[][] map;
	static int[][] zido;
	static int inf = 1900000000;
	static int W,H;
	public static void main(String args[]) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while ( T > 0 ) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int K = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			hm = new HashMap<>();
			for ( int i = 0 ; i < K ;i++) {
				st= new StringTokenizer(br.readLine()," ");
				String key = st.nextToken();
				int time = Integer.parseInt(st.nextToken());
				hm.put(key,time);
			}
			map = new char[W+2][H+2];
			zido = new int[W+2][H+2];
			for ( int i = 1; i <= W ; i++) {
				for ( int j = 1 ; j <= H ; j++) {
					zido[i][j] = inf;
				}
			}
			for ( int i = 0; i <= W+1 ; i++) {
				for ( int j = 0 ; j <= H+1 ; j++) {
					map[i][j] = 'a';
				}
			}
			
			int startX = 1,startY = 1;
			for ( int i = 1 ; i <= W ; i++) {
				char[] tmp = br.readLine().toCharArray();
				for ( int j = 1 ; j<= H ;j++){
					if ( tmp[j-1] == 'E') {
						startX = i;
						startY = j;
					}
					map[i][j] = tmp[j-1];
				}
			}
			
			BFS(startX,startY);
			
			/*int ans = inf;
			for ( int i = 1 ; i <= W ; i++) {
				for ( int j = 1 ; j<= H ; j++) {
					if ( i > 1 && i < W) {
						if ( j == 1 || j == H) {
							ans = Math.min(zido[i][j], ans);
						}
					}else if ( i == 1 || i == W) {
						ans = Math.min(zido[i][j], ans);
					}
					System.out.print(zido[i][j]+" ");
				}System.out.println();
			}
			System.out.println(ans);*/
			T--;
		}
	
	}
	
	public static void BFS(int x,int y) {
		PriorityQueue<node> q = new PriorityQueue<>();
		q.add(new node(x,y,0));
		zido[x][y] = 0;
		
		while ( !q.isEmpty() ) {
			node tmp = q.poll();
			int X = tmp.x;
			int Y = tmp.y;
			int cost = tmp.cost;
			
			if ( X==1 || Y == 1 || X == W || Y == H) {
				System.out.println(zido[X][Y]);
				break;
			}
			
			//System.out.println(map[X][Y]+" "+X+" "+Y);
			if ( map[X+1][Y] != 'a' && map[X+1][Y] != 'E') {
				String key1 = String.valueOf(map[X+1][Y]);
				int a = hm.get(key1);
				if ( zido[X+1][Y] > cost + a) {
					zido[X+1][Y] = cost + a;
					q.add(new node(X+1,Y,cost+a));
				}
			}
			if( map[X-1][Y] != 'a' && map[X-1][Y] != 'E') {
				String key2 = String.valueOf(map[X-1][Y]);
				int b = hm.get(key2);
				if ( zido[X-1][Y] > cost + b) {
					zido[X-1][Y] = cost + b;
					q.add(new node(X-1,Y,cost+b));
				}
			}
			if ( map[X][Y+1] != 'a' && map[X][Y+1] != 'E') {
				String key3 = String.valueOf(map[X][Y+1]);
				int c = hm.get(key3);
				if ( zido[X][Y+1] > cost + c) {
					zido[X][Y+1] = cost + c;
					q.add(new node(X,Y+1,cost+c));
				}
			}
			if ( map[X][Y-1] != 'a' && map[X][Y-1] != 'E') {
				String key4 = String.valueOf(map[X][Y-1]);
				int d = hm.get(key4);
				if ( zido[X][Y-1] > cost + d) {
					zido[X][Y-1] = cost + d;
					q.add(new node(X,Y-1,cost+d));
				}
			}
			
		}

	}
	
	public static class node implements Comparable<node>{
		int x,y;
		int cost;
		node(int x,int y,int cost){
			this.x =x;
			this.y =y;
			this.cost =cost;
		}
		@Override
		public int compareTo(node o) {
			if (this.cost > o.cost ) {
				return 1;
			}else {
				return -1;
			}
		}
	}
}
