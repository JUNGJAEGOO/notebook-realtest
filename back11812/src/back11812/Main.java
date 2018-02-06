package back11812;

import java.util.Scanner;

public class Main {
	static int p[];
	static int d[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int Q = in.nextInt();
		p = new int[N+1];
		d = new int[N+1];
		d[1] = 0;
		int idx= 2;
		for (int i = 1 ; i<= N ; i++) {
			for (int j = 0 ; j< K ; j++) {
				if ( idx <= N) {
					p[idx] = i;
					idx++;
				}
			}
		}
		
		for (int i = 1 ; i<= N ; i++) {
			System.out.print(p[i]+" ");
		}System.out.println();
		
		for (int i = 0 ; i < Q ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int sum = 0;
			while ( true ) {
				
				if (p[x] != p[y]) {
					if ( x != 1) {
						x = p[x];
						sum++;
					}
				}else {
					break;
				}
				if (p[x] != p[y]) {
					if ( y != 1) {
						y = p[y];
						sum++;
					}
				}else {
					break;
				}
			}
			System.out.println(sum);
		}
	}
	
/*	public static int find(int x) {
		if ( p[x] == x) {
			return x;
		}else {
			return x = find(p[x]);
		}
	}
	
	public static void union(int a,int b) {
		int x = find(a);
		int y = find(b);
		if ( x == y) {
			return;
		}else {
			p[y] = x;
			d[y] = d[x]+1;
		}
	}*/
}
