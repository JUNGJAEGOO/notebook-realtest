package back11658;

import java.util.Scanner;

public class Main {

	static long tree[][];
	static long arr[][];
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int M = in.nextInt();
		arr = new long[N+1][N+1];
		tree = new long[N+1][N+1];
		
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= N ; j++) {
				arr[i][j] = in.nextInt();
				update(i,j,arr[i][j]);
			}
		}
		
		for ( int i = 0 ; i < M ; i++) {
			int com = in.nextInt();
			if ( com == 1) {
				int x1 = in.nextInt();
				int y1 = in.nextInt();
				int x2 = in.nextInt();
				int y2 = in.nextInt();
				
				long sum = sum(x2,y2) - sum(x1-1,y2) - sum(x2,y1-1) + sum(x1-1,y1-1);
				System.out.println(sum);
			}else {
				int x1 = in.nextInt();
				int y1 = in.nextInt();
				int want = in.nextInt();
				long dis = want - arr[x1][y1];
				arr[x1][y1] = want;
				update(x1,y1,dis);
				
			}
		}
	}
	
	public static void update(int x,int y,long num) {
		for ( int i = x ; i <= N ; i += ( i & -i)) {
			for ( int j = y ; j <= N ; j += ( j & -j)) {
				tree[i][j] += num;
			}	
		}
		
	}
	public static long sum(int x,int y) {
		long ans = 0;
		for ( int i = x ; i > 0 ; i -= ( i & -i)) {
			for ( int j = y ; j > 0 ; j -= ( j & -j)) {
				ans += tree[i][j];
			}	
		}
		return ans;
	}
}
