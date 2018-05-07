package back7662;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		
		for ( int testcase = 0 ; testcase < T ; testcase++ ) {
			
			int N = Integer.parseInt(in.nextLine());
			boolean visit[] = new boolean[N+1];
			
			PriorityQueue<maxnode> maxpq = new PriorityQueue<>();
			PriorityQueue<minnode> minpq = new PriorityQueue<>();
			
			for ( int i = 0 ; i < N ; i++) {
				
				String info[] = in.nextLine().split(" ");
				if ( info[0].equals("I")) {
					int x = Integer.parseInt(info[1]);
					maxpq.add(new maxnode(i,x));
					minpq.add(new minnode(i,x));
					
				}else {
					
					int x = Integer.parseInt(info[1]);
					
					if ( x == 1) { // 최대 삭제
						
						if ( !maxpq.isEmpty() ) {
							maxnode now = maxpq.peek();
							if ( !visit[now.i] ) {
								maxpq.poll();
								visit[now.i] = true;
							}
						}
						
					}else {
						if ( !minpq.isEmpty() ) {
							minnode now = minpq.peek();
							if ( !visit[now.i] ) {
								minpq.poll();
								visit[now.i] = true;
							}
						}
						
						
					}
					
				}
				
				while ( !minpq.isEmpty() ) {
					if ( !visit[minpq.peek().i]) {
						break;
					}else {
						minpq.poll();
					}
				}
				
				while ( !maxpq.isEmpty() ) {
					if ( !visit[maxpq.peek().i]) {
						break;
					}else {
						maxpq.poll();
					}
				}
				
				for ( int j = 0 ; j < N ; j++) {
					System.out.print(visit[j]+" ");
				}System.out.println();
			}
			
			if ( maxpq.isEmpty() || minpq.isEmpty() ) {
				System.out.println("EMPTY");
				continue;
			}
			maxnode maxnode = maxpq.poll();
			minnode minnode = minpq.poll();
			
			int max = maxnode.idx;
			int min = minnode.idx;
			int maxi = maxnode.i;
			int mini = minnode.i;
			
			System.out.println(max+" "+min);
			
			
		}
	}
	
	public static class maxnode implements Comparable<maxnode>{
		int idx;
		int i;
		maxnode(int i,int idx){
			this.idx = idx;
			this.i = i;
		}
		@Override
		public int compareTo(maxnode o) {
			if ( this.idx < o.idx) {
				return 1;
			}
			return -1;
		}
	}
	
	public static class minnode implements Comparable<minnode>{
		int idx;
		int i;
		minnode(int i, int idx){
			this.idx = idx;
			this.i  = i;
		}
		@Override
		public int compareTo(minnode o) {
			if ( this.idx > o.idx) {
				return 1;
			}
			return -1;
		}
	}
}
