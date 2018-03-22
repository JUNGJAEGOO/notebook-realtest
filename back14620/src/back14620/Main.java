package back14620;

import java.util.*;

public class Main {
	static int N;
	static int mat[][];
	static int ans = 1000000000;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		mat = new int[N][N];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
				
			}
		}
		
		BFS();
		System.out.println(ans);
	}
	
	
	public static void BFS() {
		
		Queue<node> q = new LinkedList<>();
		for ( int i = 1 ; i< N-1 ; i++) {
			for ( int j = 1 ; j < N-1 ; j++) {
				int up = (i-1)*N + j;
				int down = (i+1)*N + j;
				int left = i*N  + j-1;
				int right = i*N + j+1;
				int current = i*N + j;
				int cost = mat[i-1][j] + mat[i+1][j] + mat[i][j-1] + mat[i][j+1] + mat[i][j];
				ArrayList<Integer> visit = new ArrayList<>();
				visit.add(up);
				visit.add(down);
				visit.add(left);
				visit.add(right);
				visit.add(current);
				q.add(new node(i,j,1,cost,visit));
			}
		}
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			ArrayList<Integer> visit = now.visit;
			
			int cnt = now.cnt;
			int c = now.cost;
			if ( cnt == 3) {
				if ( c < ans) {
					System.out.println(c+" "+visit);
				}
				ans = Math.min(c,ans);
				
				continue;
			}
			
			for ( int i = 1 ; i < N-1 ; i++) {
				for ( int j = 1 ; j < N-1 ; j++) {
					
					int up = (i-1)*N + j;
					int down = (i+1)*N + j;
					int left = i*N  + j-1;
					int right = i*N + j+1;
					int current = i*N + j;
					if ( visit.contains(current) || visit.contains(up) || visit.contains(down) || visit.contains(left) || visit.contains(right) ) {
						continue;
					}
					int cost = mat[i-1][j] + mat[i+1][j] + mat[i][j-1] + mat[i][j+1] + mat[i][j];
					ArrayList<Integer> newvisit = new ArrayList<>();
					for ( int k = 0 ; k < visit.size() ; k++) {
						newvisit.add(visit.get(k));
					}
					newvisit.add(up);
					newvisit.add(down);
					newvisit.add(left);
					newvisit.add(right);
					newvisit.add(current);
					
					q.add(new node(i,j,cnt+1,cost+c,newvisit));
					
				}
			}
			
		}
	}
	
	public static class node{
		int x,y;
		int cnt;
		int cost;
		
		ArrayList<Integer> visit;
		
		node (int x,int y,int cnt,int cost,ArrayList<Integer> visit) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.cost = cost;
			this.visit = visit;
		}
	}
}
