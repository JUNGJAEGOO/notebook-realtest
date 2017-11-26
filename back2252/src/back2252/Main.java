package back2252;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		ArrayList<Integer> adj[] = new ArrayList[N+1];
		ArrayList<Integer> inner[] = new ArrayList[N+1];
		for ( int i = 1 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
			inner[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < M ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			adj[x].add(y);
			inner[y].add(x);
			
		}
		
		Queue<Integer> q = new LinkedList<>();
		for ( int i = 1 ; i <= N ; i++) {
			if ( inner[i].size() == 0) {
				q.add(i);
				
			}
		}
		
		while ( !q.isEmpty() ) {
			int x =q.poll();
			int size = adj[x].size();
			for ( int j = 0 ; j < size; j++) {
				
				int size2 = inner[adj[x].get(j)].size();
				
				for ( int k = 0 ; k < size2; k++) {
					//System.out.println(inner[adj[x].get(j)]);
					if ( inner[adj[x].get(j)].get(k) == x ) {
						inner[adj[x].get(j)].remove(k);
						//System.out.println(x+"제거");
						break;
					}
				}
				
			}
			System.out.print(x+" ");
			
				
			for(int i = 0 ; i< adj[x].size() ; i++) {
				if ( inner[adj[x].get(i)].size() == 0) {
				q.add(adj[x].get(i));
				}
			}
				
			
		}
		
	}
	
}
