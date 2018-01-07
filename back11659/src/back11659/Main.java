package back11659;

import java.util.Scanner;

public class Main {
	static int N;
	static int arr[];
	static long tree[];
	public static void update(int i,int num) {
		while ( i <= N ) {
			tree[i] += num;
			i += ( i & -i);
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int M = in.nextInt();
		arr= new int[N+1];
		tree = new long[N+1];
		for ( int i = 1 ; i <= N ; i++) {
			arr[i] = in.nextInt();
			update(i,arr[i]);
		}
		
		for ( int i = 0 ; i < M ; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			System.out.println(sum(end)-sum(start-1));
		}
	}
	
	public static long sum(int i) {
	long ans = 0;
	while ( i > 0) {
		ans += tree[i];
		i -= ( i & -i);
	}
	return ans;
	}
}
