package back9372;

import java.util.*;

public class Main {
	static int p[];
	static int cnt[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			int N = in.nextInt();
			int M = in.nextInt();
			p = new int[N+1];
			cnt = new int[N+1];
			for (int i = 1 ; i <= N ; i++) {
				p[i] = i;
				cnt[i] = 0;
			}
			
			for (int i = 0 ; i < M ; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				union(from,to);
				
			}
			
			int sum = 0;
			for (int i = 1 ; i<= N ; i++) {
				//System.out.println(cnt[i]);
				sum += cnt[i];
			}
			System.out.println(sum);
			T--;
			
		}
	}
	
	public static int find(int x) {
		if ( p[x] == x) {
			return x;
		}else {
			return x = find(p[x]);
		}
	}
	
	public static void union(int a,int b) {
		int X = find(a);
		int Y = find(b);
		
		if ( X == Y) {
			return;
		}else {
			p[b] = a;
			cnt[b]++;
		}
	}
}
