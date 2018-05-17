package back11780;

import java.io.*;
import java.util.*;

public class Main {
	static int prev[];
	static int dist[];
	static ArrayList<node> adj[] ;
	static int inf = 1000000000;
	static int N;
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int mat[][] = new int[N][N];

		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = inf;
			}
		}
		
		adj = new ArrayList[N];
		for ( int i = 0 ; i < N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < M ; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			if ( mat[from][to] > cost) {
				if ( adj[from].contains((Integer)to)) {
					adj[from].remove((Integer)to);
				}
				adj[from].add(new node(to,cost));
				mat[from][to] = Math.min(cost,mat[from][to]);
				
			}
			
		}
		
		for ( int k = 0 ; k < N ; k++) {
			for ( int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					if ( mat[i][j] > mat[i][k] + mat[k][j]) {
						mat[i][j] = mat[i][k] + mat[k][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				if ( mat[i][j] == inf || i == j) {
					sb.append(0+" ");
				}else {
					int x = mat[i][j];
					
					sb.append((x)+" ");
				}
			}sb.append("\n");
		}
		
		
		for ( int i = 0 ; i < N ; i++) {
			
			dist = new int[N];
			prev = new int[N];
			Arrays.fill(dist, inf);
			diik(i);

			int cnt = 0;

			for ( int j = 0 ; j < N ; j++) {
				
				if ( i == j ) {
					sb.append(0+"\n");
					continue;
				}else {
					
					ArrayList<Integer> list = new ArrayList<>();
					int NOW = j;
					list.add(NOW+1);
					while ( true ) {
						list.add(prev[NOW]+1);
						NOW = prev[NOW];
						if ( prev[NOW] == -1) {
							break;
						}
					}
					
					Collections.reverse(list);
					sb.append(list.size()+" ");
					for ( int k  = 0 ; k < list.size() ; k++) {
						sb.append(list.get(k)+" ");
					}sb.append("\n");
					
				}
				
			}
		}
		
		System.out.print(sb);
	}
	
	static void diik(int start) {
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start,0));
		prev[start] = -1;
		dist[start] = 0;
		
		while ( !pq.isEmpty() ) {
			node tmp = pq.poll();
			int now  = tmp.idx;
			int nowcost = tmp.cost;
			//System.out.println(now);
			if ( dist[now] < nowcost) {
				continue;
			}
			
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				int nextcost = adj[now].get(i).cost;
				//System.out.println(next);
				if ( dist[next] > nowcost+ nextcost) {
					prev[next] = now;
					dist[next] = nowcost + nextcost;
					pq.add(new node(next,nowcost+nextcost));
				}
			}
			
		}
	}
	
	public static class node implements Comparable<node>{
		int idx;
		int cost;
		node ( int idx,int cost){
			this.idx = idx;
			this.cost  = cost;
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
