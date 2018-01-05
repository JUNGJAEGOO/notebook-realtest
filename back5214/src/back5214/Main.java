package back5214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] adj;
	static int inf = 190000000;
	static int N;
	static boolean visit[];
	static int cnt = 1;
	static int d[];
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[101001];
		visit = new boolean[N+2];
		d=  new int[101001];
		for ( int i = 0 ; i <= 101000; i++) {
			adj[i] = new ArrayList<>();
		}
		for ( int i = N+1  ; i <= M + N; i++) {
			st= new StringTokenizer(br.readLine()," ");
			for ( int  j = 0 ; j < K ; j++) {
				System.out.println(i);
				int to = Integer.parseInt(st.nextToken());
				adj[i].add(to);
				adj[to].add(i);	
			}
		}
		
		BFS();
		
		System.out.println();
	}
	
	public static void BFS() {
		Queue<Integer> pq = new LinkedList<>();
		pq.add(1);
		d[1] = 1;
		while ( !pq.isEmpty() ) {

			int now = pq.poll();
			System.out.println(now);
			if ( now == N) {
				System.out.println(d[now]/2 + 1);
				return;
			}
			
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				
				int next = adj[now].get(i);
				if ( d[next] == 0) {
					d[next] = d[now] +1;
					pq.add(next);
				}

			}
			

		}
		
		System.out.println(-1);
	}

}
