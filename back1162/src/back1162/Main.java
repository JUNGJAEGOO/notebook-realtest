package back1162;

import java.util.*;

public class Main {
	static ArrayList<node> adj[];
	static int dist[][];
	static final int inf = 1000000000;
	
	public static void main(String ags[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		adj = new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost,0));
			adj[to].add(new node(from,cost,0));
		}
		
		dist= new int[21][N+1];
		for (int i = 0 ; i < 21 ; i++) {
			for (int j = 0 ; j < N+1 ; j++) {
				dist[i][j] = inf;
			}
		}
		
		diik();
		
		for (int i = 0 ; i <= K ; i++) {
			System.out.print(dist[i][N]+" ");
		}
	}
	
	public static void diik() {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(1,0,0));
		dist[0][1] = 0;
		while ( !pq.isEmpty() ) {
			node now = pq.poll();
			int idx = now.idx;
			int cost = now.cost;
			int cnt = now.cnt;
			
			for (int i = 0 ; i < adj[idx].size() ; i++) {
				int next = adj[idx].get(i).idx;
				int nextcost = adj[idx].get(i).cost;
				
				if ( dist[cnt][next] > dist[cnt][idx] + nextcost ) {
					dist[cnt][next] = dist[cnt][idx] + nextcost;
					pq.add(new node(next,dist[cnt][idx]+nextcost,cnt));
				}
				if ( cnt + 1 < 21 && dist[cnt+1][next] > dist[cnt][idx] ) {
					dist[cnt+1][next] = dist[cnt][idx];
					pq.add(new node(next,dist[cnt][idx],cnt+1));
				}
				
			}
		}
	}
	
	public static class node implements Comparable<node>{
		int idx;
		int cost;
		int cnt;
		node (int idx,int  cost,int cnt){
			this.idx = idx;
			this.cost = cost;
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
