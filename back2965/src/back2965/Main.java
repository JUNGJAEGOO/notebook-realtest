package back2965;

import java.util.*;

public class Main {
	static int ans = 0;
	static int visit[][][];
	
	public static void main(String args[]) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		
		int left = in.nextInt();
		int mid = in.nextInt();
		int right = in.nextInt();
		
		visit = new int[101][101][101];
		BFS(left,mid,right);
		System.out.println(ans);
		
	}
	
	public static void BFS(int left,int mid,int right) throws InterruptedException {
		Queue<node> q = new LinkedList<>();
		q.add(new node(left,mid,right,0));
		visit[left][mid][right] = 0;
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int l = now.left;
			int m = now.mid;
			int r = now.right;
			int cnt = now.count;
			
			System.out.println(l+" "+m+" "+r+" :"+cnt);
			ans = Math.max(ans, cnt);
			
			
			for ( int i = m+1 ; i < r ; i++) {
				System.out.println(m+" "+i+" "+r+" 추가");
				if ( cnt + 1 > visit[m][i][r]) {
					visit[m][i][r] =cnt + 1;
					q.add(new node(m,i,r,cnt+1));
				}
			}
			
			for ( int i = l+1 ; i < m ; i++) {
				System.out.println(l+" "+i+" "+m+" 추가");
				if ( cnt+1 > visit[l][i][m]) {
					visit[l][i][m] =cnt + 1;
				q.add(new node(l,i,m,cnt+1));
				}
			}
		}
	}
	
	public static class node{
		int left;
		int mid;
		int right;
		int count = 0;
		node( int left,int mid,int right,int count){
			this.left = left;
			this.mid = mid;
			this.right = right;
			this.count = count;
		}
	}
}
