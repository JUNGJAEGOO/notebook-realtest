package back10282;

import java.util.*;

public class Main {
	static ArrayList<node> adj[];
	static int[] dist;
	static int inf = 1000000000;
	
	public static void main(String args[]) {
		
		
		Scanner in = new Scanner(System.in);
		int T= in.nextInt();
		while ( T > 0) {
			
			int n = in.nextInt();
			int d = in.nextInt();
			int c = in.nextInt();
			
			adj = new ArrayList[10001];
			for (int i = 1 ; i < 10001 ; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for ( int i = 0 ; i < d ; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				int sec = in.nextInt();
				adj[to].add(new node(from,sec));
			}
			
			dist = new int[10001];
			Arrays.fill(dist,inf);
			
			BFS(c);
			
			
			int count = 0;
			int max = 0;
			for ( int i = 0 ; i < 10001 ; i++) {
				if ( dist[i] != inf) {
					max = Math.max(max, dist[i]);
					count++;
				}
			}
			System.out.println(count+" "+max);
			T--;
		}
	}
	
	public static void BFS(int start) {
		PriorityQueue<node> q = new PriorityQueue<>();
		q.add(new node(start,0));
		dist[start] = 0;
		
		while ( !q.isEmpty() ) {
			node now = q.poll();
			
			int idx = now.idx;
			int sec = now.sec;
			if ( dist[idx] < sec) {
				continue;
			}
			//System.out.println(idx);

			for (int i = 0 ; i < adj[idx].size() ; i++) {
				int next = adj[idx].get(i).idx;
				int nextcost = adj[idx].get(i).sec;
				if ( dist[next] > dist[idx] + nextcost) {
					q.add(new node(next,nextcost));
					dist[next] = dist[idx] + nextcost;
				}
			}
			
		}
		
	}
	
	public static class node implements Comparable<node>{
		int idx;
		int sec;
		node (int idx,int sec){
			this.idx = idx;
			this.sec = sec;
		}
		@Override
		public int compareTo(node o) {
			if ( this.sec > o.sec) {
				return 1;
			}
			return -1;
		}
	}
}
