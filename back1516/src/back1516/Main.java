package back1516;

import java.util.*;

public class Main {
	static ArrayList<Integer> adj[];
	static ArrayList<Integer> ini[];
	static int N;
	static boolean visit[];
	static int cost[];
	static int result[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N  =  in.nextInt();
		adj = new ArrayList[N];
		ini = new ArrayList[N];
		cost = new int[N];
	
		visit = new boolean[N];
		result = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			adj[i] = new ArrayList<>();
			ini[i] = new ArrayList<>();
		}
		
		
		for ( int i = 0 ; i < N ; i++) {
			
			cost[i] = in.nextInt();
			while (true) {
				int x = in.nextInt();
				if ( x == -1 ) {
					break;
				}
				ini[i].add(x-1);
				adj[x-1].add(i);
			}
		}

		
		BFS();
		
		for ( int i = 0 ; i < N ; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void BFS() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for ( int i = 0 ; i < N ; i++) {
			if ( ini[i].size() == 0) {
				pq.add(i);
				result[i] = cost[i];
			}
		}
		
		
		while ( !pq.isEmpty() ) {
			
			int tmp = pq.poll();
			int res = cost[tmp];
			visit[tmp] = true;
			
			
			//System.out.println(tmp+" "+res);
			for ( int i = 0 ; i < adj[tmp].size() ; i++) {
				int ad = adj[tmp].get(i);
				
				for ( int j = 0 ; j < ini[ad].size() ; j++) {
					if ( ini[ad].get(j) == tmp) {
						
						ini[ad].remove(j);
					}
				}
				
				if ( result[ad] < result[tmp] + cost[ad]) {
					result[ad] = result[tmp]+cost[ad];
				}
			}
			
			for ( int i = 0 ; i < N ; i++) {
				if ( ini[i].size() == 0 && visit[i] == false) {
					//System.out.println(i+"추가");
					pq.add(i);
					visit[i] = true;
				}
			}
			
			
		}
		
	}
}
