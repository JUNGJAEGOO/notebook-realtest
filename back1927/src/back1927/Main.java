package back1927;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		PriorityQueue<node> pq = new PriorityQueue<>();
		int N = in.nextInt();
		
		for ( int i = 0 ; i < N ; i++) {
			
			int x = in.nextInt();
			if ( x == 0) {
				if ( !pq.isEmpty() ) {
					System.out.println(pq.poll().idx);
					
				}else {
					System.out.println(0);
				}
			}
			else {
				
				pq.add(new node(x));
				
				
			}
			
			
		}
	}
	
	public static class node implements Comparable<node>{
		int idx;
		
		node ( int idx){
			this.idx = idx;
		}
		
		public int compareTo(node o) {
			if ( this.idx > o.idx) {
				return 1;
			}
			return -1;
		}
	}
}
