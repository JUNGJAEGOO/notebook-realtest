package back13910;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static PriorityQueue<node> pq = new PriorityQueue<node>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for ( int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			if ( x == 0) {
				delete();
			}else {
				insert(x);
			}
		}
		System.out.print(sb);
	}
	public static void insert(int x) {
		pq.add(new node(x));
	}
	public static void delete() {
		node tmp = pq.poll();
		if ( tmp == null) {
			sb.append(0+"\n");
		}else {
			sb.append(tmp.x+"\n");
		}
	}
	public static class node implements Comparable<node>{
		int x;
		node(int x){
			this.x = x;
		}
		@Override
		public int compareTo(node o) {
			if ( this.x < o.x) {
				return 1;
			}else {
				return -1;
			}
		}
	}
}
