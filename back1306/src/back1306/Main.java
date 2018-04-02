package back1306;

import java.util.*;

public class Main {
	static int tree[];
	static int arr[];

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		arr = new int[N];
		int H = (int)Math.ceil(Math.log(N)/Math.log(2));
		tree = new int[1<<(H+1)];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		init(1,0,N-1);
	
		StringBuilder sb = new StringBuilder();
		for ( int i = M-1 ; i <= N-M ; i++ ) {
			int left = i-(M-1);
			int right = i+(M-1);
			if ( left < 0 ) {
				left = 0;
			}
			if ( right >= N) {
				right = N-1;
			}
			sb.append(MAX(1,0,N-1,left,right)+" ");
		}
		System.out.println(sb);
	}
	
	public static int init(int node,int start,int end) {
		if ( start == end) {
			return tree[node] = arr[start];
		}else {
			return tree[node] = Math.max(init(node*2,start,(start+end)/2), init(node*2+1,(start+end)/2+1,end));
		}
	}
	
	public static int MAX(int node,int start,int end,int left,int right) {
		if ( left > end || right < start) {
			return 0;
		}
		if ( left <= start && end <= right) {
			return tree[node];
		}
		
		return Math.max(MAX(node*2,start,(start+end)/2,left,right),MAX(node*2+1,(start+end)/2+1,end,left,right));
		
	}
}
