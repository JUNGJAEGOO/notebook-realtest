package back1939;

import java.io.*;
import java.util.*;

public class Maoj {
	static ArrayList<node> adj[];
	static int S,E;
	static boolean visit[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		for ( int j = 0 ; j < M ; j++) {
			st= new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[from].add(new node(to,cost));
			adj[to].add(new node(from,cost));
			
		}
		st= new StringTokenizer(br.readLine()," "); 
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		
		int start = 0;
		int end = 100000000;
		int mid;
		int ans = 0;
		while ( start <= end) {
			mid = start+ (end-start)/2;
			visit = new boolean[N+1];
			
			if ( BFS(S,mid) ) {
				ans = mid;
				start = mid+1;
			}else {
				end = mid-1;
			}
			
		}
		System.out.println(ans);
		
	}
	
	public static boolean BFS(int start,int limit) {
		Queue<Integer> q = new LinkedList<>();
		q.add((start));
		visit[start] = true;
		while ( !q.isEmpty()) {
			
			int now = q.poll();
			if ( now == E) {
				return true;
			}

			
			for (int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				int nextcost = adj[now].get(i).cost;
				if ( visit[next] == false) {
					if ( nextcost >= limit) {
						visit[next] = true;
						q.add(next);
					}
				}
			}
			
			
		}
		
		return false;
		
		
	}
	
	public static class node{
		int idx;
		int cost;
		node(int idx,int cost){
			this.idx = idx;
			this.cost =cost;
		}
	}
}
