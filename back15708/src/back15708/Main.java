package back15708;

import java.util.*;

public class Main {

	static int N,T,P;
	static int arr[];
	static int MAX = 0;
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		T = in.nextInt();
		P = in.nextInt();
		
		arr = new int[N];
		
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		long sum = 0;
		for (int i = 0 ; i < N ; i++) {
			
			pq.add(new node(arr[i]));
			sum += arr[i];

			if ( sum <= T - P*(i+1) ) {
				MAX =Math.max(pq.size(), MAX);
				continue;
			}else {
			
				while ( true ) {
					
					long x = pq.poll().idx;
					sum -= x;
					if ( sum <= T - P*(i+1) ) {
						MAX =Math.max(pq.size(), MAX);
						break;
					}
					
				}
				
				
			}
		}
		
		
		System.out.println(MAX);
	}
	
	
	public static class node implements Comparable<node>{
		int idx;

		node ( int idx){
			this.idx = idx;

					
		}

		@Override
		public int compareTo(node o) {
			if (this.idx > o.idx) {
				return -1;
			}
			return 1;
		}
	}
}
