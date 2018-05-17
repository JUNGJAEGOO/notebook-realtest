package back15709;

import java.util.*;

public class Main {
	static ArrayList<node> adj[];
	static long dist[][];
	static long inf = Long.MAX_VALUE;
	static int N,M;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		int B = in.nextInt();
		int K = in.nextInt();
		int Q = in.nextInt();
		
		adj = new ArrayList[20101];
		for ( int i = 0 ; i < 20101 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		dist = new long[101][20101];
		for ( int i = 0 ; i < 101 ; i++) {
			for ( int j = 0 ; j < 20101 ; j++) {
				dist[i][j] = inf;
			}
		}
		
		for ( int i = 0 ; i < K ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			long cost = in.nextLong();
			from--;
			to--;
			adj[from].add(new node(to,cost));
			adj[to].add(new node(from,cost));
		}
		
		for ( int i = N+M ; i < N+M+B ; i++) {
			
			diik(i);

		}

		StringBuilder sb = new StringBuilder();
		
		for ( int i = 0 ; i < Q ; i++) {
			int s = in.nextInt();
			int e = in.nextInt();
			s--;
			e--;
			
			long min = inf;
			for ( int j = N+M ; j < N+M+B ; j++) {
				//System.out.println(dist[s][j]+dist[j][e]);
				min = Math.min(min, dist[j-N-M][s]+dist[j-N-M][e]);
			}
			
			if ( min >= 1e17) {
				sb.append(-1+"\n");
			}else {
				sb.append(min+"\n");
			}
		}
		
		System.out.print(sb);
	}
	
	public static void diik(int start) {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start,0));
		
		while ( !pq.isEmpty() ) {
			
			node tmp = pq.poll();
			int now = tmp.idx;
			long nowcost = tmp.cost;
			
			if ( dist[start-N-M][now] < inf && dist[start-N-M][now] != nowcost) {
				continue;
			}
			
			//System.out.println(now+" "+nowcost);
			
			for ( int i = 0 ; i <adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				long nextcost = adj[now].get(i).cost;
				
				if ( dist[start-N-M][next] > nowcost + nextcost ) {
					pq.add(new node(next,nextcost+nowcost));
					dist[start-N-M][next] = nowcost+nextcost;
				}
				
			}
			
		}
		
	}
	
	public static class  node implements Comparable<node>{
		int idx;
		long cost;
		node (int idx,long cost){
			this.idx = idx;
			this.cost = cost;
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
