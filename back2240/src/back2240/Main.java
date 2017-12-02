package back2240;

import java.util.*;

public class Main {
	static int T,W;
	static int dp[][];
	static int max = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		W = in.nextInt();
		dp = new int[T+1][2];
		for ( int i = 1 ; i <= T ;i++) {
			dp[i][in.nextInt()-1]++;
		}
		
		BFS();
		
		System.out.println(max);
	}
	
	public static void BFS() {
		
		Queue<data> q = new LinkedList<>();
		q.add(new data(0,0,0,0));
		while ( !q.isEmpty() ) {
			data tmp = q.poll();
			int X = tmp.x;
			int Y = tmp.y;
			int cost = tmp.cost;
			
			max = Math.max(max, cost);
			
			if ( X+1 <= T) {
			if ( dp[X+1][Y] == 1) {
				q.add(new data(tmp.count,X+1,Y,cost+1));
			}else if ( dp[X+1][Y] != 1) {
				q.add(new data(tmp.count,X+1,Y,cost));
			}
			
			if ( tmp.count+1 <= W) {
			
			if ( dp[X+1][1-Y] == 1) {
				q.add(new data(tmp.count+1,X+1,1-Y,cost+1));
			}else if ( dp[X+1][1-Y] != 1) {
				q.add(new data(tmp.count+1,X+1,1-Y,cost));
			}
			
			}
			}
				
			
		}
	}
	
	public static class data{
		int count;
		int x,y;
		int cost;
		data(int count,int x,int y,int cost){
			this.count = count;
			this.x = x; this.y =y;
			this.cost = cost;
		}
	}
}
