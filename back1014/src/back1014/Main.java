package back1014;
import java.util.*;
import java.io.*;
public class Main {

	static int mat[][];
	static ArrayList<Integer> adj[];
	static int N;
	static int M;
	static int A[];
	static int B[];
	static boolean visit[];
	
	public static void main (String args[])throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while ( T > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			mat = new int[N][M];
			for (int i = 0 ; i < N ; i++) {
				char tmp[] = br.readLine().toCharArray();
				for (int j = 0 ; j < M ; j++) {
					mat[i][j] = tmp[j];
				}
			}
			adj = new ArrayList[N*M];
			for (int i = 0 ; i < N*M ; i++) {
				adj[i] = new ArrayList<>();
			}
			A = new int[N*M];
			B = new int[N*M];
			visit = new boolean[N*M];
			Arrays.fill(A, -1);
			Arrays.fill(B, -1);
			int sum = 0;
			
			for ( int i = 0 ; i < N ; i++) {
				
				for (int j = 0 ; j < M ; j++) {
					int idx = i*M + j;
					int leftup = (i-1)*M + (j-1);
					int left = (i)*M + (j-1);
					int rightup = (i-1)*M + (j+1);
					int right= i*M + (j+1);
					int leftdown = (i+1)*M + (j-1);
					int rightdown = (i+1)*M + (j+1);
					if ( mat[i][j] == '.') {
						sum++;
					}
					
					if ( j%2 == 1 && mat[i][j] == '.') {
						
						if ( i-1 >= 0 && j-1 >=0 ) {
							if ( mat[i-1][j-1] =='.') {
								adj[idx].add(leftup);
							}
						}
						if ( j-1 >= 0 ) {
							if ( mat[i][j-1] =='.') {
								adj[idx].add(left);
							}
						}
						if ( i-1 >= 0 && j+1 < M ) {
							if ( mat[i-1][j+1] == '.') {
								adj[idx].add(rightup);
							}
						}
						if ( j+1 < M ) {
							if ( mat[i][j+1] =='.') {
								adj[idx].add(right);
							}
						}
						if ( i+1 < N && j+1 < M ) {
							if ( mat[i+1][j+1] =='.') {
								adj[idx].add(rightdown);
							}
						}
						if ( j-1 >= 0 && i+1 < N  ) {
							if ( mat[i+1][j-1] =='.') {
								adj[idx].add(leftdown);
							}
						}
						
					}
					
				}
				
			}
			
			int ans = 0;
			for (int i = 0 ; i < N*M ; i++) {
				Arrays.fill(visit,false);
				if ( DFS(i) ) {
					ans++;
				}
			}
			System.out.println(sum-ans);
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
