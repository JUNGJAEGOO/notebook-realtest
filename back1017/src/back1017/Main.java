package back1017;
import java.util.*;
public class Main {
	static int A[];
	static int B[];
	static Vector even;
	static Vector odd;
	static boolean visit[];
	static ArrayList<Integer> adj[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		adj = new ArrayList[N];
		even = new Vector<Integer>();
		odd = new Vector<Integer>();
		visit = new boolean[N];
		A = new int[N/2];
		B = new int[N/2];
		int evencount = 0 , oddcount = 0;
		for ( int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			if ( x % 2 == 0) {
				even.add(x);
				
			}
			else if ( x % 2 != 0 ) {
				odd.add(x);
				
			}
		}
		
		if ( even.size() != odd.size()) {
			System.out.println(-1);
			return;
		}
	  
		
		for ( int i = 0 ; i < N/2 ; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		
		
		
		for ( int i = 0 ; i < N/2 ; i++) {
			for ( int j = 0 ; j < N/2 ; j++) {
				if ( isPrime((int)odd.get(i)+(int)even.get(j)) ){
					adj[i].add(j);
				}
			}
			
		}
		System.out.println(odd.get(0));
		
		for ( int i = 0 ; i < N/2 ; i++) {
			for ( int j = 0 ; j < adj[i].size() ; j++) {
				System.out.print(adj[i].get(j)+ " ");
			}
			System.out.println();
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for ( int i = 0 ; i < adj[0].size() ; i++) {
			for ( int t = 0 ; t < N/2 ; t++) {
				A[t] = -1;
				B[t] = -1;
			}
			int count = 0;
			int tmp = adj[0].get(i);
			//System.out.println("tmp"+tmp);
			visit[0] = true;
			A[0] = tmp;  
			B[tmp] = 0;
			
			for ( int k = 1 ; k < N/2 ; k++) {
			
				for ( int j = 1 ; j < N ; j++) {
				visit[j] = false;
				}
			
				if ( DFS(k) ) { count++; }
			}
			//System.out.println(count);
			System.out.println(tmp);
			if ( count == N/2 -1 ) {
				result.add((int)even.get(tmp));
			}
		}
		
		if ( result.isEmpty() ) {
			System.out.println(-1);
		}else {
			Collections.sort(result);
			for ( int i = 0 ; i<result.size();i++) {
				if ( i == result.size() - 1) {
					System.out.print(result.get(i));
				}else {
				System.out.print(result.get(i)+" ");
				}
			}
			System.out.println();
		}
		
		
	}
	
	public static boolean DFS(int start) {
		
		if ( visit[start] == true) {
			return false;
		}
		visit[start] = true;
		
		for ( int i = 0 ; i<adj[start].size();i++) {
			int tmp = adj[start].get(i);
			
			if ( B[tmp] == -1 || !visit[B[tmp]] && DFS(B[tmp])) {
			A[start] = tmp;
			B[tmp] = start;
			//System.out.println(start+" "+tmp);
			return true;
			}
		}
		
		
		return false;
	}
	
	public static boolean isPrime(int x) {
		int count = 2;
		while ( count <= x/2) {
			if ( x % count == 0) {
				return false;
			}
			count++;
		}
		
		return true;
	}
}
