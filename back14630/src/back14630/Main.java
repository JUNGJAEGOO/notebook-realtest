package back14630;

import java.util.*;

public class Main {
	static int N;
	static long dist[];
	static ArrayList<node> adj[];
	static int len;
	static String arr[];
	static long inf = Long.MAX_VALUE;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = Integer.parseInt(in.nextLine());
		arr = new String[N];
		
		for ( int i = 0 ; i < N ; i++) {
			
			String str = in.nextLine();
			arr[i] = str;
			
		}
		
		adj = new ArrayList[N+1];
		for ( int i = 0 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = i+1 ; j < N ; j++) {
				
				long sum = 0;
				for ( int k = 0 ; k < arr[i].length() ; k++) {
					sum += Math.pow(arr[i].charAt(k) - arr[j].charAt(k) , 2);
				}
				adj[i+1].add(new node(j+1,sum));
				adj[j+1].add(new node(i+1,sum));
			}
		}
		
		/*for ( int i = 1 ; i <= N ; i++) {
			System.out.println(i);
			for ( int j = 0 ; j < adj[i].size() ; j++) {
				System.out.println(adj[i].get(j).idx+" "+adj[i].get(j).cost);
			}
		}*/
		
		dist = new long[N+1];
		Arrays.fill(dist,inf);
		String info[] = in.nextLine().split(" ");
		int start = Integer.parseInt(info[0]);
		int end = Integer.parseInt(info[1]);
		BFS(start,end);
		
		System.out.println(dist[end]);
	}
	
	public static void BFS(int start,int end) {
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start,0));
		dist[start] = 0;
		
		while ( !pq.isEmpty() ) {
			
			node tmp = pq.poll();
			int now = tmp.idx;
			long cost = tmp.cost;
			//System.out.println(now);
			
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				
				int next = adj[now].get(i).idx;
				long nextcost = adj[now].get(i).cost;
				
				if ( dist[next] > dist[now] + nextcost) {
					dist[next] = dist[now] + nextcost;
					pq.add(new node(next,nextcost));
				}
				
			}
			
		}
		
		
	}
	
	public static class node implements Comparable<node>{
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
