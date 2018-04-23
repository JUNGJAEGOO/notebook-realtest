package back9370;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<node> adj[];
	static int s,g,h;
	static int dist[];
	static int distg[];
	static int disth[];
	static int inf = 1000000000;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while ( T > 0 ) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine()," ");
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[n+1];
			for ( int i = 0 ; i < n+1 ; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for ( int i = 0 ; i < m ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				adj[from].add(new node(to,cost));
				adj[to].add(new node(from,cost));
				
			}
			
			dist = new int[n+1];
			distg = new int[n+1];
			disth = new int[n+1];
			Arrays.fill(dist, inf);
			Arrays.fill(distg, inf);
			Arrays.fill(disth, inf);
			diik(s);
			diikg(g);
			diikh(h);
			
			ArrayList<Integer> res = new ArrayList<>();
			
			for ( int i = 0 ; i < t ; i++) {
				int x = Integer.parseInt(br.readLine());
				
				if ( dist[g] + distg[h] + disth[x] == dist[x]) {
					res.add(x);
				}
				if ( dist[h] + disth[g] + distg[x] == dist[x]) {
					res.add(x);
				}
				
			}
			
			Collections.sort(res);
			for ( int i = 0 ; i < res.size() ; i++) {
				System.out.print(res.get(i)+" ");
			}System.out.println();
			
			T--;
		}
	}
	
	public static void diik(int start) {
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new node(start,0));
		
		while ( !pq.isEmpty() ) {
			node tmp = pq.poll();
			int now = tmp.idx;
			int nowcost= tmp.cost;
			if ( nowcost > dist[now]) {
				continue;
			}
			
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				int nextcost = adj[now].get(i).cost;
				
				if ( dist[next] > nowcost + nextcost ) {
					pq.add(new node(next,nowcost+nextcost));
					dist[next] = nowcost+  nextcost;
				}
			}
			
		}
	}
	
	public static void diikg(int start) {
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		distg[start] = 0;
		pq.add(new node(start,0));
		
		while ( !pq.isEmpty() ) {
			node tmp = pq.poll();
			int now = tmp.idx;
			int nowcost= tmp.cost;
			if ( nowcost > distg[now]) {
				continue;
			}
			
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				int nextcost = adj[now].get(i).cost;
				
				if ( distg[next] > nowcost + nextcost ) {
					pq.add(new node(next,nowcost+nextcost));
					distg[next] = nowcost+  nextcost;
				}
			}
			
		}
	}
	
	public static void diikh(int start) {
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		disth[start] = 0;
		pq.add(new node(start,0));
		
		while ( !pq.isEmpty() ) {
			node tmp = pq.poll();
			int now = tmp.idx;
			int nowcost= tmp.cost;
			if ( nowcost > disth[now]) {
				continue;
			}
			
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				int nextcost = adj[now].get(i).cost;
				
				if ( disth[next] > nowcost + nextcost ) {
					pq.add(new node(next,nowcost+nextcost));
					disth[next] = nowcost+  nextcost;
				}
			}
			
		}
	}
	
	public static class node implements Comparable<node>{
		int idx,cost;
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
}
