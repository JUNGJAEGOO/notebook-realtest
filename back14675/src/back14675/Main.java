package back14675;

import java.util.*;

public class Main {
	static ArrayList<Integer> tree[];
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		tree = new ArrayList[N+1];
		for ( int i = 1 ; i<= N ; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for ( int i = 1 ; i <= N-1 ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			tree[from].add(to);
			tree[to].add(from);
			
		}
		
		
		int M = in.nextInt();
		
		for ( int i = 0 ; i < M ; i++) {
			int com = in.nextInt();
			int x = in.nextInt();
			
			if ( com == 1) {
				
				if ( tree[x].size() == 1 ) {
					System.out.println("no");
				}else {
					System.out.println("yes");
				}
				
			}else {
				System.out.println("yes");
			}
			
		}
	}

	
	public static class node{
		ArrayList<Integer> c;
		ArrayList<Integer> p;
		
	}
}
