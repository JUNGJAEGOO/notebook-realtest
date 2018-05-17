package back2010;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int now = in.nextInt();
		
		
		for ( int i = 1 ; i < N ; i++) {
			int x= in.nextInt();
			now--;
			pq.add(x);
			
			if ( now == 0) {
				now = pq.poll();
			}
			
			
			
		}
		
		long sum =0 ;
		
		while ( !pq.isEmpty() ) {
			sum += pq.poll();
		}
		
		sum += now;
		
		System.out.println(sum);
	}
}
