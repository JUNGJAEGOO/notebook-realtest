package back13700;

import java.util.*;

public class Main {
	static int police[];
	static boolean dp[];
	static int S,E,F,B;
	static int inf = 1000000000;
	
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		S = in.nextInt();
		E = in.nextInt();
		F = in.nextInt();
		B = in.nextInt();
		int K = in.nextInt();
		police = new int[100001];
		for (int i = 0 ; i < K ; i++) {
			int x = in.nextInt();
			police[x] = 1;
		}
		
		dp = new boolean[100001];
		
		
		func();
		
		
		System.out.println("BUG FOUND");
		
	}
	
	public static void func() {
		
		Queue<node> q=  new LinkedList<>();
		q.add(new node(S,0));
		dp[S] = true;
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int idx = now.idx;
			int cost = now.cost;
			if ( idx == E) {
				System.out.println(cost);
				System.exit(0);
			}
			
			if ( idx+F <= E && police[idx+F] == 0  && dp[idx+F] == false) {
				dp[idx+F] = true;
				q.add(new node(idx+F,cost+1));
			}
			
			if ( idx-B >= 1 && police[idx-B] == 0 && dp[idx-B] == false) {
				dp[idx-B] = true;
				q.add(new node(idx-B,cost+1));
			}
			
			
		}
		
	}
	
	public static class node{
		int idx;
		int cost;
		node (int idx,int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}
}
