import java.util.*;

public class Main2 {
	static int N;
	static int inf = 1900000000;
	static ArrayList<Integer> adj[];
	static int capa[][];
	static int flow[][];
	static int result = 0;
	static int prev[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int E = in.nextInt();
		adj = new ArrayList[N];
		prev = new int[N];
		flow = new int[N][N];
		capa = new int[N][N];
		
		for ( int i = 0 ; i< N ; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for ( int i = 0 ; i< N ; i++) {
			for ( int j = 0 ; j< N ; j++) {
				capa[i][j] = inf;
			}
		}
		
		for( int i = 0 ; i < E ; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			int cost = in.nextInt();
			capa[x][y] = cost;
			adj[x].add(y);
			adj[y].add(x);
			System.out.println(i+1);
		}
		
		int start = in.nextInt()-1;
		int end = in.nextInt()-1;
		
		BFS(start,end);
		
		System.out.println(result);
	}
	
	public static void BFS(int start,int end) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		while ( true ) {
			
			for(int i = 0 ; i<N ; i++) {
				prev[i] = -1;
			}
			q.add(start);
			
			while ( !q.isEmpty() ) {
				int tmp = q.remove();
				for ( int i = 0 ; i < adj[tmp].size(); i++) {
					int next = adj[tmp].get(i);
					if ( prev[next] != -1 ) {
						continue;
					}
					
					if ( capa[tmp][next] - flow[tmp][next] > 0) {
						q.add(next);
						prev[next] = tmp;
						if( next == end) {
							break;
						}
					}
					
				}
			}
			if ( prev[end] == -1) {
				break;
			}
			int min = inf;
			for ( int i = end ; i!=start ; i=prev[i]) {
				min = Math.min(min,capa[prev[i]][i] - flow[prev[i]][i]);
			}
			System.out.println(min);
			for ( int i = end ; i!=start ; i=prev[i]) {
				flow[prev[i]][i] += min;
				flow[i][prev[i]] -= min;
			}
			
			result += min;
		}
	}
}
