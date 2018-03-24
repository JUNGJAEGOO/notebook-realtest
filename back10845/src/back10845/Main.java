package back10845;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		Deque<Integer> q = new LinkedList<>();
		while ( N > 0) {
			
			String info[] = in.nextLine().split(" ");
			
			if ( info[0].equals("push")) {
				
				q.addFirst(Integer.parseInt(info[1]));
				
			}else if ( info[0].equals("front")) {
				
				if ( q.size() == 0) {
					System.out.println(-1);
				}else {
					System.out.println(q.peekLast());
				}
				
			}else if ( info[0].equals("back")) {
				
				if ( q.size() == 0) {
					System.out.println(-1);
				}else {
					System.out.println(q.peekFirst());
				}
				
			}else if ( info[0].equals("size")) {
				
				System.out.println(q.size());
				
			}else if ( info[0].equals("empty")) {
				
				if ( q.size() == 0) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				
			}else if ( info[0].equals("pop")) {
				
				if ( q.size() == 0) {
					System.out.println(-1);
				}else {
					System.out.println(q.removeLast());
				}
			}
			
			
			
			N--;
		}
	}
}
