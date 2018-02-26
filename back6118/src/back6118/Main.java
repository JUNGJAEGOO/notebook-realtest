package back6118;

import java.util.*;

public class Main {
		static ArrayList<Integer> adj[];
		static int dist[];
		static int inf = 1000000000;
		
		public static void main(String args[]) {
			Scanner in = new Scanner(System.in);
			int N = in.nextInt();
			int M = in.nextInt();
			adj = new ArrayList[N+1];
			for ( int i = 1 ; i<= N ; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0 ; i < M ; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				adj[from].add(to);
				adj[to].add(from);
			}
			
			dist =new int[N+1];
			Arrays.fill(dist,inf);
			diikstra();
			int max = 0;
			for (int i = 1 ; i <= N ; i++) {
				//System.out.print(dist[i]+" ");
				if ( dist[i] > max) {
					max = dist[i];
				}
			}
			
			int maxcnt = 0;
			int maxidx = inf;
			for (int i = 1 ; i <= N ; i++) {
				if ( dist[i] == max) {
					maxcnt++;
					if ( maxidx > i) {
						maxidx = i;
					}
				}
			}
			System.out.println(maxidx+" "+max+" "+maxcnt);
			
		}
		
		public static void diikstra() {
			PriorityQueue<node> pq = new PriorityQueue<>();
			pq.add(new node(1,0));
			dist[1] = 0;
			while ( !pq.isEmpty() ) {
				int now = pq.peek().idx;
				int cost = pq.peek().cost;
				pq.poll();
				
				if ( dist[now] < cost) {
					continue;
				}
				
				for (int i = 0 ; i < adj[now].size() ; i++) {
					int next = adj[now].get(i);
					if ( dist[next] > dist[now] + 1) {
						dist[next] = dist[now] + 1;
						pq.add(new node(next,dist[now]+1));
					}
				}
				
			}
			
		}
		
		public static class node implements Comparable<node>{
			int idx;
			int cost;
			node (int idx,int cost){
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
