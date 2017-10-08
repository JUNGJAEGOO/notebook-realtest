package back1867;

import java.util.*;
import java.io.*;

public class Main {

	static int mat[][];
	static int A[];
	static int B[];
	static boolean visit[];
	static ArrayList<Integer> adj[];
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		st = new StringTokenizer(input," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		mat = new int[n][n];
		adj = new ArrayList[n];
		visit = new boolean[n];
		A = new int[n];
		B = new int[n];
		
		for ( int i = 0 ; i < n ; i++) {
			adj[i] = new ArrayList<Integer>();
			B[i] = -1;
		}
		
		for ( int i = 0 ; i < k ; i++) {
			String tmp = br.readLine();
			st = new StringTokenizer(tmp," ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			adj[x].add(y);
		}
		
		int result = 0;
		for ( int i = 0 ; i < n ; i++) {
			for ( int j = 0 ; j < n ; j++) {
				visit[j] = false;
			}
			if (dfs(i)) { result++;}
		}
		System.out.println(result);
	}
	
	public static boolean dfs(int start) {
		visit[start] = true;
		
		for ( int i = 0 ; i<adj[start].size();i++) {
			
		int end = adj[start].get(i);
	
		if ( B[end]== -1 || !visit[B[end]] && dfs(B[end])) {
			A[start] = end;
			B[end] = start;
			return true;
		}
		
		}
		
		return false;
	}
}
