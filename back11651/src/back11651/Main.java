package back11651;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<node> list = new ArrayList<>();
		for ( int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			list.add(new node(x,y));
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < list.size() ; i++) {
			sb.append(list.get(i).x+" "+list.get(i).y+"\n");
		}
		System.out.println(sb);
	}
	
	public static class node implements Comparable<node>{
		int x,y;
		node ( int x,int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(node o) {
			if ( this.y > o.y) {
				return 1;
			}else if ( this.y == o.y) {
				if ( this.x > o.x) {
					return 1;
				}else {
					return -1;
				}
			}
			return -1;
		}
	}
}
