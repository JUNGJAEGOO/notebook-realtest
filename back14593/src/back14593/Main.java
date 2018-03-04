package back14593;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<node> list = new ArrayList<>();
		for (int i = 0 ; i < N ; i++) {
			int score = in.nextInt();
			int tries = in.nextInt();
			int time = in.nextInt();
			list.add(new node(i+1,score,tries,time));
		}
		Collections.sort(list);
		
		System.out.println(list.get(N-1).idx+" "+list.get(N-1).score+" "+list.get(N-1).tries+" "+list.get(N-1).time);
	}
	
	public static class node implements Comparable<node>{
		int idx;
		int score;
		int tries;
		int time;
		node ( int idx,int score,int tries,int time){
			this. idx = idx;
			this.score = score;
			this.tries = tries;
			this.time = time;
		}
		@Override
		public int compareTo(node o) {
			if ( this.score > o.score ) {
				return 1;
			}else if ( this.score == o.score) {
				if ( this.tries < o.tries ) {
					return 1;
				}else if ( this.tries == o.tries) {
					if ( this.time < o.time) {
						return 1;
					}else {
						return -1;
					}
				}
				return -1;
			}
			return -1;
		}
		
	}
}
