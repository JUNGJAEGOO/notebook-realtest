package back10423;

import java.util.*;

public class Main {
	static int N,M,K;
	static int energy[];
	static ArrayList<node> adj[];
	static boolean visit[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		K = in.nextInt();
		adj = new ArrayList[N+1];
		energy = new int[K];
		for ( int i = 0 ; i < K ; i++) {
			energy[i] = in.nextInt();
		}
		
		for ( int i = 0 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < M ; i++) {
			
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost));
			adj[to].add(new node(from,cost));
			
		}
		
		visit = new boolean[N+1];
		
		
		int sum = BFS();
		
		System.out.println(sum);
	}
	
	public static int BFS() {
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		int sum = 0;
		
		for ( int i = 0 ; i < energy.length ; i++) {
			
			int now = energy[i];
			visit[now] = true;
			for ( int j = 0 ; j < adj[now].size() ; j++) {
				pq.add(new node(adj[now].get(j).idx,adj[now].get(j).cost));
			}
			
		}
		
		while ( !pq.isEmpty() ) {
			
			node now = pq.poll();
			int idx = now.idx;
			int cost = now.cost;
			if ( visit[idx] == false) {
				visit[idx] = true;
			}else {
				continue;
			}
			//System.out.println(idx+" "+cost);
			sum += cost;
			
			for ( int i = 0 ; i < adj[idx].size() ; i++) {
				pq.add(new node(adj[idx].get(i).idx,adj[idx].get(i).cost));
			}
			
		}
		
		
		return sum;
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
