package back2104;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static long tree[];
	static int arr[];
	static int N;
	static int inf = 1000000000;
	static ArrayList<node> list = new ArrayList<>();
	
	public static void main (String args[]) {
		
		
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int H = (int)Math.ceil(Math.log(N)/Math.log(2));
		
		tree = new long[1<<(H+1)];
		
		arr = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		init(1,0,N-1);
		/*for (int i = 0 ; i < tree.length ; i++) {
			System.out.print(tree[i]+" ");
		}System.out.println();
		*/
		long ans = large(0,N-1);
		System.out.println(ans);
		/*for (int i = 0 ; i < list.size() ; i++) {
			if ( list.get(i).sum == ans) {
				System.out.println((list.get(i).l+1)+" "+(list.get(i).r+1));
				break;
			}
		}*/
		
	}
	
	static long large(int l,int r) {
		
		int minidx = (int)MIN(1,0,N-1,l,r);
		long s=0;
		for (int i = l ; i <= r; i++) {
			s += arr[i];
		}
		long sum = arr[minidx] * s;
		list.add(new node(sum,l,r));
		//System.out.println(l+"~"+r+" "+sum+" "+arr[minidx]+" "+s);

		if ( minidx-1 >= l ) {
			long tmp = large(l,minidx-1);
			if ( tmp > sum) {
				sum = tmp;
			}
		}
		
		if ( minidx+1 <= r){
			long tmp = large(minidx+1,r);
			if ( tmp > sum) {
				sum = tmp;
			}
		}
		return sum;
	}
	
	static long init(int node,int start,int end) {
		
		if( start == end) {
			return tree[node] = start;
		}
		long l = init(node*2,start,(start+end)/2);
		long r = init(node*2+1,(start+end)/2+1,end);
		if ( arr[(int)l] <= arr[(int)r]) {
			return tree[node] = l;
		}else {
			return tree[node] = r;
		}
		//return tree[node] = Math.min(init(node*2,start,(start+end)/2) , init(node*2+1,(start+end)/2+1,end) );
	}
	
	static long MIN(int node,int start,int end,int left,int right) {
		
		if ( left > end || right < start) {
			return inf;
		}
		if ( left <= start && end <= right) {
			return tree[node];
		}
		
		long L = MIN(node*2,start,(start+end)/2,left,right);
		long R = MIN(node*2+1,(start+end)/2+1,end,left,right);
		if ( L == inf) {
			return R;
		}else if ( R == inf) {
			return L;
		}else {
			if ( arr[(int)L] <= arr[(int)R]) {
				return L;
			}else {
				return R;
			}
		}
		
	}
	
	public static class node{
		long sum;
		int l,r;
		node(long sum,int l,int r){
			this.l= l;
			this.r =r;
			this.sum = sum;
		}
	}
}
