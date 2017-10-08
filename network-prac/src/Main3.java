import java.util.*;

public class Main3 {

	static int inf = 1900000000;
	static int dist[];
	static boolean visit[];
	static int mat[][];
	static ArrayList<Integer> adj[];
	static int N,E;
	
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		E = in.nextInt();
		visit = new boolean[N];
		dist = new int[N];
		mat = new int[N][N];
		adj = new ArrayList[N];
		for(int i = 0 ; i< N;i++) {
			adj[i] = new ArrayList<Integer>();
			dist[i] = inf;
			for(int j = 0 ; j< N;j++) {
				mat[i][j] = inf;
			}
		}
		for(int i = 0 ; i< E;i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			int cost = in.nextInt();
			mat[x][y] = cost;
			adj[x].add(y);
			adj[y].add(x);
		}
		
		for(int i = 0 ; i< N;i++) {
			for(int j = 0 ; j< N;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		
		int start = in.nextInt()-1;
		int end = in.nextInt()-1;
		
		diikstra(start,end);
		
		for(int i = 0 ;i<N ; i++) {
			System.out.print(dist[i]+" ");
		}
	}
	
	public static void diikstra(int start,int end) {
		int minindex = start;
		int mindist = inf;
		dist[start] = 0;
		for( int count = 0 ; count < N-1 ; count++) {
			mindist = inf;
			
			for(int i = 0 ; i < adj[minindex].size() ; i++) {
				if ( !visit[i] && dist[i] < mindist ) {
					mindist = dist[i];
					minindex = i;
				}
			}
			visit[minindex] = true;
			
			for(int i = 0 ; i<N ; i++) {
				if ( dist[i] > mindist+mat[minindex][i]) {
					dist[i] = mindist+mat[minindex][i];
				}
			}
			
			for(int i = 0 ;i<N ; i++) {
				System.out.print(dist[i]+" ");
			}
			System.out.println();
		}
	}
}
