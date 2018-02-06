package back2157;

import java.util.*;
// 다익스트라 이용. 시간 초과 발생
public class Main {
	static int N,M,K;
	static int dist[][];
	static ArrayList<node> adj[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		K = in.nextInt();
		adj = new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0 ; i < K ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost,0));
		}
		
		dist = new int[N+1][M+1];
		
		diikstra();
		
		/*for (int i = 0 ; i <= N ; i++) {
			for (int j = 0 ; j <= M ; j++) {
				System.out.print(dist[i][j]+" ");
			}System.out.println();
		}*/
		
		int max = 0;
		for (int j = 0 ; j <= M ; j++) {
			max = Math.max(max,dist[N][j]);
		}
		System.out.println(max);
	}
	
	public static void diikstra() {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(1,0,0));
		dist[1][0] = 0;
		
		while ( !pq.isEmpty() ) {
			node tmp = pq.poll();
			int idx = tmp.idx;
			int cost = tmp.cost;
			int cnt = tmp.cnt;
			//System.out.println(idx);
			for (int i = 0 ; i < adj[idx].size() ; i++) {
				int next = adj[idx].get(i).idx;
				int nextcost = adj[idx].get(i).cost;
				if ( next > idx) {
					if ( cnt+1 <= M && dist[next][cnt+1] < dist[idx][cnt] + nextcost) {
						pq.add(new node(next,nextcost+cost,cnt+1));
						dist[next][cnt+1] = dist[idx][cnt] + nextcost;
					}
				}
			}
		}
	}
	
	public static class node implements Comparable<node>{
		int idx;
		int cost;
		int cnt;
		node( int idx,int cost,int cnt){
			this.idx = idx;
			this.cost = cost;
			this.cnt = cnt;
			
		}
		@Override
		public int compareTo(node o) {
			if ( this.cost > o.cost) {
				return -1;
			}
			return 1;
		}
	}
}
