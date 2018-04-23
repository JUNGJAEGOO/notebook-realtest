package back2056;

import java.util.*;

public class Main {
	static int N;
	static int inner[];
	static int cost[];
	static int dist[];
	static boolean visit[];
	static ArrayList<Integer> adj[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		adj = new ArrayList[N+1];
		for ( int i = 0 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		inner = new int[N+1];
		cost = new int[N+1];
		for ( int i = 0 ; i < N ; i++) {
			int c = in.nextInt();
			int size = in.nextInt();
			cost[i+1] = c;
			for ( int j = 0 ; j < size ; j++) {
				int from = in.nextInt();
				adj[from].add(i+1);
				inner[i+1]++;
			}
		}
		
		visit = new boolean[N+1];
		dist =  new int[N+1];
		
		BFS();
		
		int max = 0;
		for ( int i = 1 ; i <= N ; i++) {
			//System.out.print(dist[i]+" ");
			max = Math.max(dist[i],max);
		}//System.out.println();
		
		System.out.println(max);
	}
	
	public static void BFS() {
		Queue<Integer> q= new LinkedList<>();
		
		for ( int i = 1 ; i<= N ; i++) {
			if ( inner[i] == 0) {
				visit[i] = true;
				dist[i] = cost[i];
				q.add(i);
			}
		}
		
		while ( !q.isEmpty() ) {
			int now = q.poll();
			//System.out.println(now);
			
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i);
				if ( dist[next] < dist[now] + cost[next]) {
					dist[next] = dist[now] + cost[next];
				}
				inner[next]--;
			}
			
			for ( int i = 1 ; i<= N ; i++) {
				if ( inner[i] == 0 && visit[i] == false) {
					visit[i] = true;
					q.add(i);
				}
			}
			
		}
	}
	
	public static class node{
		int idx,cost;
		node ( int idx,int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}
}
