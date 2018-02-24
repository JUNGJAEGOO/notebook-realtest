package back15481;

import java.util.*;

public class Main {
	static ArrayList<node> adj[];
	static List<info> list;
	static boolean visit[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		adj = new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		list = new ArrayList<>();
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			list.add(new info(from,to,cost));
			adj[from].add(new node(to,cost));
		}
		
		for (int i = 0 ; i < list.size() ; i++ ) {
			visit = new boolean[N+1];
			int from = list.get(i).from;
			int to = list.get(i).to;
			int cost = list.get(i).cost;
			visit[from] = true;
			int sum = cost;
			sum += MST(to);
			System.out.println(sum);
		}
	}
	
	public static int MST(int start) {
		int sum = 0;
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start,0));
		while ( !pq.isEmpty() ) {
			
			node tmp = pq.poll();
			int idx = tmp.idx;
			int cost = tmp.cost;
			if ( visit[idx] ) {
				continue;
			}
			//System.out.println(idx);
			visit[idx] = true;
			sum += cost;
			
			for (int i = 0 ; i < adj[idx].size() ; i++) {
				int next = adj[idx].get(i).idx;
				int nextcost = adj[idx].get(i).cost;
				
				pq.add(new node(next,nextcost));
			}
			
		}
		return sum;
	}
	
	
	
	public static class node implements Comparable<node>{
		int idx;
		int cost;
		node (int idx,int cost){
			this.idx = idx;
			this.cost =cost;
		}
		@Override
		public int compareTo(node o) {
			if ( this.cost > o.cost) {
				return 1;
			}
			return -1;
		}
	}
	
	public static class info{
		int from;
		int to;
		int cost;
		info (int from,int to,int cost){
			this.from = from;
			this.to = to;
			this.cost =cost;
		}
	}
}
