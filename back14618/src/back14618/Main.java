package back14618;

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int J = in.nextInt();
		int K = in.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		ArrayList<Integer> B = new ArrayList<>();
		int dist[] = new int[N+1];
		int inf = 100000000;
		Arrays.fill(dist, inf);
		ArrayList<node> adj[] = new ArrayList[N+1];
		for ( int i = 1 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0 ; i < K ; i++) {
			A.add(in.nextInt());
		}
		for (int i = 0 ; i < K ; i++) {
			B.add(in.nextInt());
		}
		for (int i = 0 ; i < M ; i ++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost));
			adj[to].add(new node(from,cost));
		}
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(J,0));
		dist[J] = 0;
		while ( !pq.isEmpty() ) {
			
			node now = pq.poll();
			int idx = now.idx;
			int cost = now.cost;
			//System.out.println(idx);
			if ( cost > dist[idx]) {
				continue;
			}
			
			for (int i = 0 ; i < adj[idx].size() ; i++) {
				int nextidx = adj[idx].get(i).idx;
				int nextcost = adj[idx].get(i).cost;
				//System.out.println("다음은 "+nextidx);
				if ( dist[nextidx] > dist[idx] + nextcost ) {
					dist[nextidx] = dist[idx] + nextcost;
					pq.add(new node(nextidx,dist[idx]+nextcost));
				}
			}
			
		}
		
		int Amin = inf;
		int Bmin = inf;
		int Acnt = 0;
		int Bcnt = 0;
		for ( int i = 1 ; i  <= N ; i++) {
			if ( i==J) {
				continue;
			}
			if ( A.contains(i) ) {
				if ( dist[i] != inf) {
					Acnt++;
					Amin = Math.min(dist[i], Amin);
				}
			}else if ( B.contains(i)) {
				if ( dist[i] != inf) {
					Bcnt++;
					Bmin = Math.min(dist[i], Bmin);
				}
			}
		}
		
		if ( Acnt == 0 && Bcnt == 0) {
			System.out.println(-1);
		}else {
			
			if ( Amin <= Bmin) {
				System.out.println("A");
				System.out.println(Amin);
			}else {
				System.out.println("B");
				System.out.println(Bmin);
			}
			
		}
		
	}
	
	public static class node implements Comparable<node>{
		int idx;
		int cost;
		node(int idx,int cost){
			this.cost = cost;
			this.idx = idx;
		}
		@Override
		public int compareTo(node o) {
			if ( this.cost < o.cost) {
				return -1;
			}
			return 1;
		}
	}
}
