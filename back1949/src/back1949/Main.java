package back1949;

import java.util.*;

public class Main {
	static ArrayList<Integer>[] adj;
	static int dp[][];
	static int arr[];
	static int N;
	static boolean visit[];
	static ArrayList<Integer> tree[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N+1];
		for ( int i = 1 ; i <= N ; i++) {
			arr[i] = in.nextInt();
		}
		
		visit = new boolean[N+1];
		adj = new ArrayList[N+1];
		tree = new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}
		
		dp = new int[2][10001];
		for ( int i = 0 ; i < 2 ; i++) {
			for ( int j = 0 ; j <= 10000 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		int cnt = 0;
		while ( cnt < N-1 ) {
			cnt++;
			
			int from = in.nextInt();
			int to = in.nextInt();
			adj[from].add(to);
			adj[to].add(from);
		}
		
		make(1,0);
		int ans = 0;
		ans = Math.max(func(0,1), func(1,1)+arr[1]);
		System.out.println(ans);
	}
	
	public static int func(int state,int pos) {
		
		System.out.println(state+" , "+pos);
		
		int ret = dp[state][pos];
		if ( ret != -1) {
			return ret;
		}
		 ret = 0;
		
		 for ( int i =  0 ; i < tree[pos].size() ; i++) {
			 int next = tree[pos].get(i);
			 if ( state == 0) {
				 ret += Math.max(func(0,next),arr[next]+func(1,next) );
			 }else {
				 ret += func(0,next);
			 }
		 }
		
		 System.out.println(ret);
		 
		return dp[state][pos] = ret;
	}
	
	public static void make(int here,int depth) {
		
		visit[here] = true;
		for ( int i = 0 ; i < adj[here].size() ; i++) {
			int there = adj[here].get(i);
			if ( visit[there] == true) {
				continue;
			}
			
			tree[here].add(there);
			make(there,depth+1);
			
		}
		
		
	}
}
