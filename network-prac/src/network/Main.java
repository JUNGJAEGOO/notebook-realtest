package network;
import java.util.*;


public class Main {

	static int capa[][];
	static int inf = 1100000000;
	static Vector<Integer> adj[];
	static int flow[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int e = in.nextInt();
		capa = new int[n][n];
		flow = new int[n][n];
		adj = new Vector[n];
		
		for(int i = 0; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				capa[i][j] = inf;
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			adj[i] = new Vector<Integer>();
		}
		
		for(int i = 0 ; i < e ; i++) {
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			int cost = in.nextInt();
			capa[x][y] = cost;
			adj[x].add(y);
			adj[y].add(x);
			
		}
		int start = in.nextInt()-1;
		int end = in.nextInt()-1;
		
		DFS(start,end,n);
		
		
		
	}
	
	public static void DFS(int start,int end,int n) {
		int minindex = 0;
		int mincost = inf;
		
		boolean visit[];
		
		
		while(true) {
			
			int pre[] = new int[n];
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(start);
			
			while(!q.isEmpty() ) {
				
				int tmp = q.remove();
				
				for(int i = 0 ; i < n ; i++) {
					
					int next = adj[tmp].get(i);
					
					if ( visit[next] == true ) {
						continue;
					}
					
					if( capa[tmp][next] - flow[tmp][next] > 0 ) {
					
						q.add(next);
						pre[next] = tmp;
						if(next==end) {
						break;
						}
					
					}
					
					
					
				}
				
			}
			
			if(pre[end]==-1) {
				break;
			}
			
			int f = inf;
			
			for ( int i = 0 ; i < n ; i++) {
			f = Math.min(f, capa[pre[i]][i] - flow[pre[i]][i]);
			}
			
			
			
		}
		
	}
}
