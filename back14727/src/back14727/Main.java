package back14727;

import java.util.Scanner;

public class Main {
	static long tree[];
	static long arr[];
	static int inf = -1;
	static int N;
	
	public static long init(int idx,int start,int end) {
		if( start==end) {
			return tree[idx] = start;
		}else {
			long l = init(idx*2,start,(start+end)/2);
			long r = init(idx*2+1,(start+end)/2+1,end);
			if ( arr[(int)l] <= arr[(int)r]) {
				return tree[idx] = l;
			}else {
				return tree[idx] = r;
			}
		}
	}
	
	public static long MIN(int idx,int start,int end,int left,int right) {
		if ( left > end || right < start) {
			return inf;
		}
		if ( left <= start && end <= right) {
			return tree[idx];
		}
		
		long l = MIN(idx*2,start,(start+end)/2,left,right);
		long r = MIN(idx*2+1,(start+end)/2+1,end,left,right);
		if ( l == inf) {
			return r;
		}else if ( r == inf){
			return l;
		}else {
			if ( arr[(int)l] <= arr[(int)r]) {
				return l;
			}else {
				return r;
			}
		}
	}
	
	public static long large(int start,int end) {
		int height = (int)MIN(1,0,N-1,start,end);
		long w = (end-start+1) * arr[height];
		//System.out.println(height);
		if ( start <= height-1) {
			long tmp = large(start,height-1);
			if ( tmp > w ) {
				w = tmp;
			}
		}
		
		if ( end >= height+1) {
			long tmp = large(height+1,end);
			if ( tmp > w) {
				w = tmp;
			}
		}
		
		return w;
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int H = (int)Math.ceil(Math.log(N)/Math.log(2));
		tree = new long[1<<(H+1)];
		arr = new long[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		init(1,0,N-1);
		
		System.out.println(large(0,N-1));
	}
}
