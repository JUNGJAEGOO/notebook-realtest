package back1753;
import java.util.*;
public class Main {
	static int inf = 1900000000;
	static ArrayList<data> adj[];
	static boolean visit[];
	static int dist[];
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int start = in.nextInt();
		adj = new ArrayList[N+1];
		visit = new boolean[N+1];
		dist = new int[N+1];
		for ( int i = 1 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
			dist[i] = inf;
		}

		for ( int i = 0 ; i < M ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int cost = in.nextInt();
			/*int x = i;
			int y = (int) Math.random()*1000;
			int cost = i*/;
			adj[x].add(new data(y,cost));
		}
		

		PriorityQueue<data> pq = new PriorityQueue<>();
		
		pq.add(new data(start,0));
		dist[start] = 0;
		
		while ( !pq.isEmpty() ) {
			data tmp = pq.poll();

			if ( visit[tmp.num] == true ) { continue; }
			visit[tmp.num] = true;
			
		
				for ( int j = 0; j<adj[tmp.num].size() ; j++) {
					if ( visit[adj[tmp.num].get(j).num] == false) {
					int e = adj[tmp.num].get(j).num;
					int w = adj[tmp.num].get(j).cost;
					
						dist[e] = Math.min(dist[e],dist[tmp.num]+w);
						
						pq.add(new data(e,dist[e]));
					}

				}
			

		}
		
		
		for ( int i = 1 ; i <= N ; i++) {
			
			if ( dist[i] == inf) {
				System.out.println("INF");
			}else {
				System.out.println(dist[i]);
			}
		}
		
	}
	
	
	public static class data implements Comparable<data>{
		int num;
		int cost;
		data(int num,int cost){
			this.num = num;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(data o) {
			if ( this.cost > o.cost) {
				return 0;
			}else {
				return 1;
			}
		}
	}
	
	
}
