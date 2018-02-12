package back13907;

import java.util.*;

public class Main2 {
	static int N,M,K;
	static ArrayList<node> adj[];
	static int start,end;
	static int dist[][];
	static int up[];
	static int inf = 1000000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		K = in.nextInt();
		start = in.nextInt();
		end = in.nextInt();
		adj = new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		dist = new int[1001][1001];
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost,0));
			adj[to].add(new node(from,cost,0));
		}
		
		up = new int[K+1];
		for (int i = 1 ; i <= K ; i++) {
			up[i] = in.nextInt();
		}
		
		for (int i = 0 ; i < 1001; i++) {
			for (int j = 0 ; j < 1001 ; j++) {
				dist[i][j] = inf;
			}
		}
		
		diik();
		
		/*for (int i = 0 ; i < 5 ; i++) {
			for (int j =1 ; j < 5 ; j++) {
				System.out.print(dist[i][j]+" ");
			}System.out.println();
		}*/
		
		int sum = 0;
		for (int s = 0 ; s <= K ; s++) {
			int min = inf;
			sum += up[s];
			for ( int i = 0 ; i < 1001 ; i++) {
				if ( dist[i][end] + sum*i < min) {
					min = dist[i][end] + sum*i;
				}
			}
			System.out.println(min);
		}
		
	}
	
	public static void diik() {
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start,0,0));
		dist[0][start] = 0;
		
		while ( !pq.isEmpty() ) {

			node tmp = pq.poll();
			int now = tmp.idx;
			int nowcost = tmp.cost;
			int cnt= tmp.cnt;
			
			for (int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				int nextcost = adj[now].get(i).cost;
				if ( cnt+1 <= 1000 && dist[cnt+1][next]  > dist[cnt][now] + nextcost ) {
					dist[cnt+1][next]  = dist[cnt][now] + nextcost;
					pq.add(new node(next,dist[cnt][now]+nextcost,cnt+1));
				}
				
			}
			
			
		}
		
	}
	
	public static class node implements Comparable<node>{
		int idx,cost;
		int cnt;
		node (int idx,int cost,int cnt){
			this.idx = idx;
			this.cost  =cost;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(node o) {
			if ( this.cost > o.cost) {
				return 1;
			}
			return -1;
		}
	}
}
