package back14657;

import java.util.*;

public class Main {
	static ArrayList<node> adj[];
	static boolean visit[];
	static int inf = 1000000000;
	static int maxp = 1;
	static int minsum = inf;
	static int rootsum = inf;
	static int rootp = 1;
	static int root;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int T = in.nextInt();
		adj  =new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < N-1 ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost));
			adj[to].add(new node(from,cost));
		}
		
		visit = new boolean[N+1];
		visit[1] = true;
		findroot(1,1,0);


		visit = new boolean[N+1];
		visit[root] = true;
		func(root,1,0);
		
		//System.out.println(maxp+" "+minsum);
		int ans = minsum/T;
		if ( minsum%T != 0) {
			ans++;
		}
		System.out.println(ans);
		
	}
	
	static void findroot(int now,int problem,int sum) {
		
		if ( problem > rootp) {
			rootp = problem;
			root = now;
			rootsum = sum;
		}else if ( problem == rootp) {
			if ( rootsum > sum) {
				root = now;
				rootsum = sum;
				
			}
		}
		
		for (int i = 0 ; i < adj[now].size(); i++) {
			int next = adj[now].get(i).idx;
			int nextcost = adj[now].get(i).cost;
			
			if ( visit[next] == false ) {
				visit[next] = true;
				findroot(next,problem+1,sum+nextcost);
			}
		}
		
	}
	
	static void func(int now,int problem,int sum) {
	
		if ( problem > maxp) {
			maxp = problem;
			minsum = sum;
			
		}else if ( problem == maxp) {
			if ( sum < minsum ) {
				minsum = sum;
			}
		}
		
		for ( int i = 0 ; i < adj[now].size() ; i++) {
			
			int next = adj[now].get(i).idx;
			int nextcost = adj[now].get(i).cost;
			
			if ( visit[next] == false ) {
				visit[next] = true;
				func(next,problem+1,sum+nextcost);
			}
			
		}
		
	}
		
		
	
	static class node{
		int idx;
		int cost;
		node (int idx,int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}
}
