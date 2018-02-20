package back11580;

import java.util.*;

public class Main {
	static boolean mat[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		mat = new boolean[3001][3001];
		char com[] = in.next().toCharArray();
		Queue<node> q = new LinkedList<>();
		q.add(new node(1500,1500));
		int cnt = 0;
		int nextidx = 0;
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			if ( mat[x][y] == true) {
				
			}else {
				cnt++;
				mat[x][y] = true;
			}
			
			if ( nextidx >= N) {
				break;
			}
			
			if ( com[nextidx] == 'S') {
				q.add(new node(x+1,y));
			}else if ( com[nextidx] == 'E') {
				q.add(new node(x,y+1));
			}else if ( com[nextidx] == 'W') {
				q.add(new node(x,y-1));
			}else if ( com[nextidx] == 'N') {
				q.add(new node(x-1,y));
			}
			
			nextidx++;
			
		}
		System.out.println(cnt);
	}
	
	public static class node {
		int x,y;
		node (int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
