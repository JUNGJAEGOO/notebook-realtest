package back9576;

import java.util.*;

public class Main {
	static int A[];
	static int B[];
	static boolean visit[];
	static ArrayList<Integer> adj[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			int N = in.nextInt();
			int M = in.nextInt();
			
			B = new int[1001];
			A = new int[1001];
			
			adj = new ArrayList[1001];
			for (int i = 1 ; i<= 1000 ; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 1 ; i <= M ; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				for (int j = from ; j <= to ; j++) {
					adj[i].add(j);
				}
			}
			
			Arrays.fill(B, -1);
			int ans = 0;
			for (int i = 1 ; i <= M ; i++) {
				visit = new boolean[1001];
				if ( DFS(i) ) {
					ans++;
				}
			}
			
			System.out.println(ans);
			
			T--;
		}
		
	}
	
	public static boolean DFS(int start) {
		if ( visit[start]) {
			return false;
		}
		visit[start] = true;
		
		for (int i = 0 ; i < adj[start].size() ; i++) {
			int end = adj[start].get(i);
			if ( B[end] == -1 || DFS(B[end])) {
				A[start] = end;
				B[end] = start;
				return true;
			}
		}
		return false;
	}
}
