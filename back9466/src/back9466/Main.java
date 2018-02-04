package back9466;

import java.util.*;

public class Main {
	static boolean visit[];
	static int N;
	static int adj[];
	static int idg[];
	static int ans;
	
	public static void main(String args[]) {
		Scanner in = new Scanner ( System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			N = in.nextInt();
			ans = 0;
			adj = new int[N+1];
			idg = new int[N+1];
			for (int i = 1 ; i <= N ; i++) {
				int from = i;
				int to = in.nextInt();
				adj[from] = to;
				idg[adj[from]]++;
			}
			
			visit = new boolean[N+1];
			
			for (int i = 1 ; i<= N ; i++) {
				if ( visit[i] == false && idg[i] == 0) {
					DFS(i);
				}
			}
			System.out.println(ans);
			T--;
		}
	}
	
	public static void DFS(int idx) {
		visit[idx] = true;
		ans++;
		idg[adj[idx]]--;
		if (visit[adj[idx]] == false && idg[adj[idx]] == 0) {
			DFS(adj[idx]);
		}
	}
	


}
