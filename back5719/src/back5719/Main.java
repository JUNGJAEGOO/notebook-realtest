package back5719;

import java.util.*;

public class Main {
	static int dist[];
	static int inf = 1000000000;
	static ArrayList<node> adj[];
	static boolean visit[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		while ( true) {
		int N = in.nextInt();
		int M = in.nextInt();
		if ( N == 0 && M == 0) {
			break;
		}
		int start = in.nextInt();
		int end = in.nextInt();
		adj = new ArrayList[N];
		for (int i = 0 ; i < N ; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0 ; i < M; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			
			adj[from].add(new node(to,cost));
			
		}
		dist = new int[N];
		Arrays.fill(dist, inf);
		diikstra(start);
		int target = dist[end];
		//System.out.println(target);
		ArrayList<Integer> path = new ArrayList<>();
		path.add(start);
		visit = new boolean[N];
		
		if (dist[end] == inf) {
			System.out.println(-1);
			continue;
		}
		
		DFS(start,end,0,target,path);
		
		Arrays.fill(dist, inf);
		diikstra(start);
		//System.out.println(dist[end]);
		if (dist[end] == inf) {
			System.out.println(-1);
		}else {
			System.out.println(dist[end]);
		}
		}
	}
	
	public static void DFS(int now,int T,int sum,int Tcost,ArrayList<Integer> path) {
		
		if ( sum > Tcost) {  // 핵심!!!!!!
			return;
		}
		
		if ( now == T) {
			if ( sum == Tcost) {
				//System.out.println(path);
				for (int i = 0 ; i < path.size()-1 ; i++) {
					int from = path.get(i);
					int to = path.get(i+1);
					for (int j = 0 ; j < adj[from].size() ; j++) {
						if ( adj[from].get(j).idx == to) {
							adj[from].get(j).cost = inf;
							//System.out.println(from+"~"+to+" "+adj[from].get(j).cost);
							break;
						}
	
					}
					
				}
				
				return;
			}
		}
		
		
		for (int i = 0 ; i < adj[now].size() ; i++ ) {
			int next = adj[now].get(i).idx;
			int nextCost = adj[now].get(i).cost;
			if( visit[next] == false) {
				
				visit[next] = true;
				path.add(next);
				DFS(next,T,sum+nextCost,Tcost,path);
				visit[next] = false;
				path.remove(path.size()-1);
			}
		}
		
		
	}
	
	public static void diikstra(int start) {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start,0));
		dist[start] = 0;
		while ( !pq.isEmpty()) {
			
			node tmp = pq.poll();
			int idx = tmp.idx;
			int cost = tmp.cost;
			
			if ( dist[idx] < cost) {
				continue;
			}
			
			for (int i = 0 ; i < adj[idx].size() ; i++) {
				int next =adj[idx].get(i).idx;
				int nextCost = adj[idx].get(i).cost;
				if ( dist[next] > dist[idx] + nextCost) {
					dist[next] = dist[idx] + nextCost;
					pq.add(new node(next,nextCost));
				}
			}
			
			
		}
	
	}
	
	public static class node implements Comparable<node>{
		int idx;
		int cost;
		node(int idx,int cost){
			this.idx= idx;
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
}
