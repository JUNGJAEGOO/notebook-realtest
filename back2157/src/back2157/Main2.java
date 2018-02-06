package back2157;

import java.util.*;

public class Main2 {
	static int N,M,K;
	static ArrayList<node> adj[];
	static int dp[][];
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
			adj[from].add(new node(to,cost));
		}
		
		dp = new int[301][301];
		for (int i = 0 ; i < 301 ; i++) {
			for (int j = 0 ; j < 301 ; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(func(1,1));
	}
	
	public static int func(int idx,int cnt) {

		if ( cnt >= M && idx < N) {
			return -1000000000;
		}
		
		if ( idx == N && cnt < M) {
			return 0;
		}
		
		int ret = dp[idx][cnt];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		for (int i = 0 ; i < adj[idx].size() ; i++) {
			int next = adj[idx].get(i).x;
			if ( next > idx ) {
				ret = Math.max(ret, adj[idx].get(i).cost + func(next,cnt+1));
			}
		}
		
		return dp[idx][cnt] = ret;
	}
	
	public static class node{
		int x;
		int cost;
		node (int x, int cost) {
			this.x =x;
			this.cost = cost;
		}
	}
}
