package back4196;

import java.util.*;

public class Main {
	static ArrayList<Integer> adj[];
	static ArrayList<Integer> rev[];
	static ArrayList<Integer> res[];
	static Stack<Integer> st;
	static boolean visit[];
	
	public static void main(String args[]) {
		Scanner in= new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			int N = in.nextInt();
			int M = in.nextInt();
			adj = new ArrayList[N+1];
			rev = new ArrayList[N+1];
			res = new ArrayList[N+1];
			visit = new boolean[N+1];
			for ( int i = 1 ; i<= N ; i++) {
				adj[i] = new ArrayList<>();
				rev[i] = new ArrayList<>();
				res[i] = new ArrayList<>();
			}
			
			st = new Stack<Integer>();
			for ( int i = 0 ; i  < M ; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				adj[from].add(to);
				rev[from].add(to);
			}
			
			visit = new boolean[N+1];
			for ( int i = 1 ; i<= N ; i++) {
				DFS(i);
			}
			//System.out.println(st);
			visit = new boolean[N+1];
			while ( !st.isEmpty() ) {
				int now = st.pop();
				revDFS(now,now);
				//System.out.println(res[now]);
			}
			
			int ans = 0;
			for ( int i = 1 ; i<= N ; i++) {
				if ( res[i].size() > 0 ) {
					ans++;
				}
			}
			System.out.println(ans);
			T--;
		}
	}
	
	public static void DFS(int start) {
		if ( visit[start] == true) {
			return;
		}
		visit[start] = true;
		for ( int i = 0 ; i < adj[start].size() ; i++) {
			int next = adj[start].get(i);
			if ( visit[next] == false) {
				DFS(next);
			}
		}
		
		st.add(start);
	}
	
	public static void revDFS(int start,int real) {
		if ( visit[start] == true) {
			return;
		}
		visit[start] = true;
		for ( int i = 0 ; i < rev[start].size() ; i++) {
			int next = rev[start].get(i);
			if ( visit[next] == false) {
				revDFS(next,real);
			}
		}
		
		res[real].add(start);
	}
}
