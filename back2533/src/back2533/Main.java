package back2533;

import java.util.*;

public class Main {
	static int tree[];
	static ArrayList<Integer> adj[];
	static int dp[][];
	static boolean isRoot[];
	static int inf = 1000000001;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		adj = new ArrayList[N+1];
		isRoot = new boolean[N+1];
		tree = new int[N];
		
		for ( int i = 1 ; i < N+1 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < N-1 ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			adj[from].add(to);
			isRoot[to] = true;
		}
		
		int root = 1;
		for ( int i = 1; i <= N ; i++) {
			if ( isRoot[i] == false) {
				root = i;
				break;
			}
		}
		
		dp = new int[1000001][2];
		for ( int i = 0 ; i <= 1000000 ; i++) {
			for (int j = 0 ; j < 2 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		int a = func(root,0);
		int b = func(root,1);
		System.out.println(a);
		System.out.println(b);
		
		/*for ( int i = 0 ; i < 10 ; i++) {
			System.out.print(dp[i][0]+" ");
		}System.out.println();
	
		for ( int i = 0 ; i < 10 ; i++) {
			System.out.print(dp[i][1]+" ");
		}System.out.println();*/
		
		
	}
	
	public static void make() {
		Queue<Integer> q=  new LinkedList<>();
		
		
	}
	
	public static int func(int now,int state) {
		
		//System.out.println(now+" "+state+" ");
		
		if ( adj[now].size() == 0) {
			if ( state == 1) {
				return dp[now][state] = 1;
			}else {
				return dp[now][state] = 0;
			}
		}
		
		int ret = dp[now][state];
		if ( ret != -1) {
			return ret;
		}

		
		ret= 0 ;
		
		if ( state == 1 ) {
			
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i);
				int a = func(next,0);
				int b=  func(next,1);
				//System.out.println("hhehehe"+a+" "+b);
				ret += Math.min(a,b);
			}
			ret++;
			//System.out.println(ret);
			return dp[now][state] = ret;
		}else {
		
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i);
				ret += ( func(next,1));
				
			}
			return dp[now][state] = ret;
		}
	
	}
}
