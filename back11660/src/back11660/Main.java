package back11660;

import java.util.Scanner;

public class Main {
	static long tree[][];
	static int arr[][];
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		 N = in.nextInt();
		int M = in.nextInt();
		arr = new int[N+1][N+1];
		tree = new long[N+1][N+1];
		for ( int i = 1 ; i<= N ; i++) {
			for ( int j = 1 ; j<= N ; j++) {
				arr[i][j] = in.nextInt();
				update(i,j,arr[i][j]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < M ; i++) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			sb.append(sum(x2,y2)-sum(x1-1,y2)-sum(x2,y1-1)+sum(x1-1,y1-1)+"\n");
			
		}
		System.out.print(sb);
	}
	
	public static void update(int i,int j,int num) {
		for ( int s = i ; s <= N ; s += ( s & -s ) ) {
			for ( int k = j ; k <= N ; k += ( k & -k ) ) {
				tree[s][k] += num;
			}
		}
	}
	
	public static long sum(int i,int j) {
		long ans = 0;
		for ( int s = i ; s > 0 ; s -= ( s & -s ) ) {
			for ( int k = j ; k > 0 ; k -= ( k & -k ) ) {
				ans += tree[s][k];
			}
		}
		return ans;
	}
}
