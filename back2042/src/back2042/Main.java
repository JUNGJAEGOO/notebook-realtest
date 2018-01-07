package back2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long tree[];
	static int arr[];
	static int N;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		N =Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		tree = new long[N+1];
		for ( int i = 1 ; i <= N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			update(i,arr[i]);
		}
		
	/*	for ( int i = 1 ; i <= N ; i++ ) {
			System.out.print(tree[i]+" ");
		}System.out.println();
		*/
		for ( int i = 0 ; i < M + K ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int com = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if ( com == 1) {
				long diff = y-arr[x];
				arr[x] = y;
				update(x,diff);
			}else if ( com == 2) {
				System.out.println(sum(y)-sum(x-1));
			}
		}
	}
	
	public static void update(int idx,long num) {
		while ( idx <= N ) {
			tree[idx] += num;
			idx += ( idx & -idx);
		}
	}
	
	public static long sum(int i) {
		long ans = 0;
		while ( i > 0) {
			ans += tree[i];
			i -= ( i & -i );
		}
		return ans;
	}
}
