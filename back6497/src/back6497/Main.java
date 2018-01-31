package back6497;

import java.util.*;

public class Main {
	static int m,n;
	static ArrayList<node> adj[];
	static boolean visit[];
	static int res;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while ( true ) {
			res = 0;
			m = in.nextInt();
			n = in.nextInt();
			if( m==0 && n ==0) {
				return;
			}
			adj = new ArrayList[m];
			visit = new boolean[m];
			for (int i = 0 ; i < m ; i++) {
				adj[i] = new ArrayList<>();
			}
			long sum = 0;
			for (int i = 0 ; i < n ; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				int cost = in.nextInt();
				sum += cost;
				adj[from].add(new node(to,cost));
				adj[to].add(new node(from,cost));
			}
			
			BFS();
			
			System.out.println(sum-res);
		}
	
	}
	
	public static void BFS() {
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(0,0));
		
		while ( !pq.isEmpty() ) {
			node tmp = pq.poll();
			if ( visit[tmp.idx] == true) {
				continue;
			}
			int now = tmp.idx;
			
			visit[now] = true;
			int cost = tmp.cost;
			//System.out.println(now+" "+cost);
			res += cost;
			
			for (int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				int nextCost = adj[now].get(i).cost;
				
					pq.add(new node(next,nextCost));
				
			}
			
		}
		
	}
	
	public static class node implements Comparable<node>{
		int idx;
		int cost;
		node(int idx,int cost){
			this.idx = idx;
			this.cost =cost;
		}
		@Override
		public int compareTo(node o) {
			if ( this.cost < o.cost){
				return -1;
			}
			return 1;
		}
	}
	
	
}
