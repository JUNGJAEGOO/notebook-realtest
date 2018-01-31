package back5676;

import java.util.*;
import java.io.*;

public class Main {
	static long arr[];
	static long tree[];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		
		
		//init(1,0,N-1);
		StringTokenizer st;
		while ( true ) {
			String first = br.readLine();
			if ( first == null) {
				break;
			}
			st = new StringTokenizer(first," ");
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr= new long[N];
			int H = (int)Math.ceil(Math.log(N)/Math.log(2));
			tree = new long[1<<(H+1)];
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0 ; i < N ; i++) {
				long tmp = Long.parseLong(st.nextToken());
				if ( tmp > 0) {
					tmp = 1;
				}else if ( tmp == 0) {
					tmp = 0;
				}else {
					tmp = -1;
				}
				arr[i] = tmp;
			}
			init(1,0,N-1);
			
			for (int i = 0 ; i < K ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				char com = st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if (com == 'C') {
					if ( y > 0) {
						y = 1;
					}else if ( y < 0) {
						y = -1;
					}else {
						y = 0;
					}
					update(1,0,N-1,x-1,y);
				}else if ( com == 'P') {
					long ans = sum(1,0,N-1,x-1,y-1);
					//System.out.println(ans);
					if ( ans == 0) {
						System.out.print(0);
					}else if (ans > 0){
						System.out.print("+");
					}else {
						System.out.print("-");
					}
				}
			}
			System.out.println();
		}
	}
	
	public static long init(int idx,int start,int end) {
		if ( start== end) {
			return tree[idx] = arr[start];
		}else {
			return tree[idx] = init(idx*2,start,(start+end)/2) * init(idx*2+1,(start+end)/2+1,end);
		}
	}
	public static long update(int node,int start,int end,int idx,long dist) {
		if ( start > idx || idx > end) {
			return tree[node];
		}
		if ( start == end) {
			return tree[node] = dist;
		}
		else {
			
			return tree[node] =  update(node*2,start,(start+end)/2,idx,dist)*update(node*2+1,(start+end)/2+1,end,idx,dist);
		}
	}
	
	public static long sum(int node,int start,int end,int left,int right) {
		if ( left > end || right < start) {
			return 1;
		}
		if ( left <= start && right >= end) {
			return tree[node];
		}
		
		return sum(node*2,start,(start+end)/2,left,right) * sum(node*2+1,(start+end)/2+1,end,left,right);
	}
}
