package back9577;

import java.util.*;

public class Main {
	static boolean visit[];
	static ArrayList<Integer> adj[];
	static int n;
	static int min = 100000000;
	static int A[],B[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			n = in.nextInt();
			int m = in.nextInt();
			A = new int[101];
			B = new int[101];
			
			adj = new ArrayList[101];
			for (int i = 0 ; i<= 100 ; i++) {
				adj[i] = new ArrayList<>();
			}

			for (int i = 0 ; i < m  ; i++) {
				
				int start = in.nextInt();
				int end = in.nextInt();
				int num = in.nextInt();
				ArrayList<Integer> list = new ArrayList<>();
				for (int j = 0 ; j < num ; j++) {
					list.add(in.nextInt());
				}
				
				for ( int j = start ; j <= end ; j++) {
					for (int k = 0 ; k < list.size() ; k++) {
						if ( !adj[j].contains((Integer)list.get(k)) ) {
							adj[j].add(list.get(k));
						}
					}
				}
			}
			
			Arrays.fill(B,-1);
			int ans = 0;
			int time = -1;
			for (int i = 0 ; i<= 100 ;i++) {
				visit = new boolean[101];
				if ( back(i) ) {
					ans++;
				}
				if ( ans == n) {
					time = i;
					break;
				}
			}
			System.out.println(ans);
			T--;
		}
	}
	
	public static boolean back(int now) { 
		
		if ( visit[now] ) {
			return false;
		}
		visit[now] = true;
		
		for (int i = 0 ; i < adj[now].size() ; i++) {
			int next = adj[now].get(i);
			if ( B[next] == -1 || back(B[next])) {
				A[now] = next;
				B[next] = now;
				return true;
			}
		}
		
		return false;
		
	}
}
