package back2167;
import java.util.*;

public class Practice {

	static Scanner in = new Scanner(System.in);
	static int adj[][];
	static int A[];
	static int B[];
	static boolean visit[];
	static ArrayList<Integer> list[]; 
	
	public static void main(String args[]) {
	
		int N = in.nextInt();
		int M = in.nextInt();
		visit = new boolean[N+1];
		adj = new int[N+1][N];
		int count = 1;
		int result = 0;
		B = new int[N+1];
		A = new int[N+1];
		list = new ArrayList[N+1];
		
		
		for(int i=0;i<N+1;i++) {
		list[i] = new ArrayList();
		}
		
		
		
		while(count <= M) {
		int adjnum = in.nextInt();
		
		for(int i=1;i<=adjnum;i++) {
			int tmp = in.nextInt();
			list[count].add(tmp);
		}
		
		count++;
		}
		
		
/*		int search = 1;
		while ( search < N + 1) {
		for(int i = 0 ; i <list[search].size() ;i++) {
			System.out.print(list[search].get(i)+" ");
		}
		System.out.println();
		search++;
		}
		*/
		
		
		
		for (int i = 1 ; i <= N ; i++) {
			A[i] = -1;
			B[i] = -1;
		}
		
		for ( int i = 1 ; i <= N ; i ++) {
			
			for(int j = 0 ; j <= N ; j++) {
			visit[j] = false;        // DFS 호출할때마다 펄즈처리 필수

			}
			if (DFS(i)) { result++; }
		}
		
		
		for(int i = 1 ; i <= N ; i++) {
			System.out.println("A["+i+"]의결과는: "+A[i]);
		}
		System.out.println(result);
	}
	
	public static boolean DFS(int start) {
 
		if ( visit[start] == true) { return false; } 		visit[start] = true;
		
		for ( int i =0 ; i < list[start].size() ; i++ ) {
			int b = list[start].get(i);
		if(B[b]==-1 || !visit[B[b]] && DFS(B[b]) ) {
			
			A[start] = b;
			B[b] = start;
			return true;
		}
		}
		
		return false;
		
	}
}
