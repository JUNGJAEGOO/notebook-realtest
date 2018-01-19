package back11657;

import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static int dist[];
	static int map[][];
	static int inf = 1900000000;
	static boolean pass;
	
	public static void main(String args[]) throws Exception {
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][3];
		dist = new int[N+1];

		
		for ( int i = 0 ; i< M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[i][0] = from;
			map[i][1] = to;
			map[i][2] = cost;
		}
		
		Arrays.fill(dist, inf);
		
		diikstra();
		
		if ( pass == true) {
			System.out.println(-1);
		}else {
			for (int i = 2 ; i <= N ; i++) {
				if ( dist[i] == inf) {
					System.out.println(-1);
				}else {
					System.out.println(dist[i]);
				}
			}System.out.println();
		}
	}
	
	
	public static void diikstra() {
		
		dist[1] = 0;
		for  ( int i = 1 ; i<= N ; i++) {
			for (int j = 0 ; j < M ; j++) {

				int cost = map[j][2];
				int to = map[j][1];
				int now = map[j][0];
				//System.out.println("지금은 "+now);
				
				if (dist[now] != inf) {
					//System.out.println(next+" "+COST);
					if ( dist[to] > dist[now] + cost) {
						dist[to] = dist[now] + cost;
						if ( i == N) {
							pass = true;
						}
					
					}
				}
			}
				
			
		}
			
		
	}

}
