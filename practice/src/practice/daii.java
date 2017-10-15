package practice;
import java.util.*;
public class daii {
	static int dist[];
	static int inf = 1900000000;
	static int N;
	static int mat[][];
	static boolean visit[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int E = in.nextInt();
		mat = new int[N][N];
		visit = new boolean[N];
		dist = new int [N];
		for( int i = 0 ; i < N ; i++) {
			for( int j = 0 ; j < N ; j++) {
				mat[i][j] = inf;
			}
			dist[i] = inf;
		}
		
		for( int j = 0 ; j < E ; j++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			int cost = in.nextInt();
			mat[x][y] = cost;
		}
		int start = in.nextInt()-1;
		int end = in.nextInt()-1;
		diikstra(start);
		
		for(int i = 0 ; i < N ; i++) {
			System.out.print(dist[i]+" ");
		}
	}
	
	public static void diikstra(int start) {
		dist[start] = 0;
		
		
		for ( int count = 0 ; count < N-1 ; count++) {
			int minindex = 0;
			int mindist = inf;
			for ( int i = 0 ; i < N ; i++) {
				if ( visit[i] == false && dist[i] < mindist) {
					mindist = dist[i];
					minindex = i;
				}
			}
			visit[minindex]=true;
			
			for ( int i = 0 ; i < N ; i++) {
				if ( dist[i] > dist[minindex] + mat[minindex][i]) {
					dist[i] = dist[minindex] + mat[minindex][i];
				}
			}
			
		}
	}
}
