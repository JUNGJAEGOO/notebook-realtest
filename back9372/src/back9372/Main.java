package back9372;

import java.util.*;

public class Main {
	static int p[];
	static int ans;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			int N = in.nextInt();
			int M = in.nextInt();
			p = new int[N+1];
			
			ans = 0;
			for (int i = 1 ; i <= N ; i++) {
				p[i] = i;
			}
			
			for (int i = 0 ; i < M ; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				union(from,to);
				
			}
			
		
			System.out.println(ans);
			T--;
			
		}
	}
	
	public static int find(int x) {
		if ( p[x] == x) {
			return x;
		}else {
			return p[x] = find(p[x]);
		}
	}
	
	public static void union(int a,int b) {
		int X = find(a);
		int Y = find(b);
		
		if ( X == Y) {
			return;
		}else {
			p[Y] = X;
			ans++;
		}
	}
}
