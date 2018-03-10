package back14433;

import java.util.*;

public class Main {
	static int A[],B[];
	static ArrayList<Integer> adj[];
	static boolean visit[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M  =in.nextInt();
		int K1 = in.nextInt();
		int K2 = in.nextInt();
		
		adj = new ArrayList[1001];
		for (int i = 1  ; i <= 1000 ; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0 ; i < K1 ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			adj[from].add(to);
		}

		A = new int[1001];
		B = new int[1001];
		Arrays.fill(A,-1);
		Arrays.fill(B,-1);
		visit = new boolean[1001];
		int resA = 0;
		for (int i = 1 ; i<= 1000 ;i++) {
			Arrays.fill(visit, false);
			if ( DFS(i) ) {
				resA++;
			}
		}
		
		
		adj = new ArrayList[1001];
		for (int i = 1  ; i <= 1000 ; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0 ; i < K2 ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			adj[from].add(to);
		}

		A = new int[1001];
		B = new int[1001];
		Arrays.fill(A,-1);
		Arrays.fill(B,-1);
		visit = new boolean[1001];
		int resB = 0;
		for (int i = 1 ; i<= 1000 ;i++) {
			Arrays.fill(visit, false);
			if ( DFS(i) ) {
				resB++;
			}
		}
		
		
		System.out.println(resA+" "+resB);
		
		if ( resA < resB) {
			System.out.println("네 다음 힐딱이");
		}else {
			System.out.println("그만 알아보자");
		}
		
		
	}
	
	public static boolean DFS(int start) {
		if ( visit[start] ) {
			return false;
		}
		visit[start] = true;
		//System.out.println(start);
		
		for (int i = 0 ; i < adj[start].size() ; i++) {
			int end = adj[start].get(i);
			if ( B[end] == -1 || !visit[B[end]] && DFS(B[end]) ) {
				A[start] = end;
				B[end] = start;
				return true;
			}
		}
		
		return false;
	}
}
