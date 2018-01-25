package back14438;

import java.util.Scanner;

public class Main {
	static int arr[];
	static int tree[];
	static int inf = 1000000001;
	
	public static int init(int idx,int start,int end) {
		if ( start == end) {
			return tree[idx] = start;
		}else {
			int l = init(idx*2,start,(start+end)/2);
			int r = init(idx*2+1,(start+end)/2+1,end);
			if( arr[l] <= arr[r] ) {
				return tree[idx] = tree[idx*2];
			}else {
				return tree[idx] = tree[idx*2+1];
			}
		}
	}
	
	public static int update(int node,int start,int end,int idx,int val) {
		if ( start > idx || idx > end){
			return tree[node];
		}
		if ( start == end) {
			return tree[node] = val;
		}
		else {
			int l = update(node*2,start,(start+end)/2,idx,val);
			int r = update(node*2+1,(start+end)/2+1,end,idx,val);
			if ( l == inf) {
				return r;
			}else if ( r == inf) {
				return l;
			}else {
				if ( arr[l] <= arr[r]) {
					return tree[node] = tree[node*2];
				}else {
					return tree[node] = tree[node*2+1];
				}
			}
		}
	}
	
	public static int min(int node,int start,int end,int left,int right) {
		if ( left > end || right < start) {
			return inf;
		}
		if ( left <= start && right >= end ) {
			return tree[node];
		}
		int l = min(node*2,start,(start+end)/2,left,right);
		int r = min(node*2+1,(start+end)/2+1,end,left,right);
		if ( l == inf) {
			return r;
		}
		else if ( r == inf) {
			return l;
		}else {
			if ( arr[l] > arr[r] ) {
				return r;
			}else {
				return l;
			}
		}
		//return Math.min(min(node*2,start,(start+end)/2,left,right), min(node*2+1,(start+end)/2+1,end,left,right));
	}
	
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		int N = in.nextInt();
		arr = new int[N];
		int H = (int)Math.ceil(Math.log(N)/Math.log(2));
		tree = new int[1<<(H+1)];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		init(1,0,N-1);
		for (int x = 0 ; x < tree.length ; x++) {
			System.out.print(tree[x]+" ");
		}System.out.println();
		
		int M =  in.nextInt();
		for ( int i = 0 ; i < M ; i++) {
			int com = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			if ( com == 1) {
				update(1,0,N-1,x-1,y);
			}else {
				System.out.println(min(1,0,N-1,x-1,y-1)+1);
			}
		}
		
	}
}
