package backB;

import java.util.*;

public class MainG {
	static int N,H;
	static ArrayList<node> arr = new ArrayList<>();
	static int dp[] = new int[100001];
	static HashMap<Integer,Integer> hm = new HashMap<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int H = in.nextInt();
		
		Arrays.fill(dp, -1);
		
		for ( int i = 0 ; i < N ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			
			arr.add(new node(from,to));
			
			if ( hm.get(from) == null ) {
				hm.put(from, to);
				
			}else {
				if ( hm.get(from) < to ) {
					hm.replace(from, to);
				}
			}
		}
		
		
		Collections.sort(arr);
		
		int now = 0;
		
		while ( true ) {
			
			if ( now < 0) {
				break;
			}
			
			if ( hm.get(now) == null ) {
				
			}else {
				now += hm.get(now);
			}
			
			
			
			
		}
		
		
	}
	
	public static class node implements Comparable<node>{
		int start;
		int to;
		node (int start,int to) {
			this.start = start;
			this.to = to;
			
		}
		@Override
		public int compareTo(node o) {
			if ( this.start > o.start) {
				return 1;
			}
			return -1;
		}
	}
}
