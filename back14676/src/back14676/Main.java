package back14676;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> req[];
	static ArrayList<Integer> adj[];
	static int visit[];
	static boolean ok[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		req = new ArrayList[N+1];
		adj = new ArrayList[N+1];
		for ( int i = 1 ; i<= N ; i++) {
			req[i] = new ArrayList<>();
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			req[to].add(from);
			
			
		}
		
		visit = new int[N+1];
		ok = new boolean[N+1];
		
		for ( int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int com = Integer.parseInt(st.nextToken());
			int building = Integer.parseInt(st.nextToken());
			
			if ( com == 1) {
				
				if ( ok[building] ) {
					visit[building]++;
					continue;
				}
				for ( int j = 0 ; j < req[building].size() ;j++ ) {
					int pre = req[building].get(j);

					if ( visit[pre] >= 1) {
						
					}else {
						System.out.println("Lier!");
						return;
					}
				}
				visit[building]++;
				ok[building] = true;
				
			}else {
				
				if ( visit[building] >= 1) {
					visit[building]--;
					if ( visit[building] == 0) {
						for ( int k = 0 ; k < adj[building].size() ; k++ ) {
							int next = adj[building].get(k);
							ok[next] = false;
						}
					}
				}else {
					System.out.println("Lier!");
					return;
				}
				
			}
			
		}
		
		System.out.println("King-God-Emperor");
	}
}
