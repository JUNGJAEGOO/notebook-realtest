package back2618;

import java.util.*;

public class Main {

	static int dp[][];
	static int inf  = 1000000000;
	static int N,W;
	static node[] fir;
	static node[] sec;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		W = in.nextInt();
		
		fir = new node[1001];
		sec = new node[1001];
		fir[0] = new node();
		sec[0] = new node();
		fir[0].x = 1; fir[0].y = 1;
		sec[0].y = N; sec[0].y = N;
		
		
		for (int i = 1; i <= W ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			fir[i] = new node();
			sec[i] = new node();
			fir[i].x = x;
			fir[i].y =y;
			sec[i].x = x;
			sec[i].y =y;
		}
		dp = new int[1001][1001];
		for (int i = 0 ; i < 1001 ; i++) {
			for (int j = 0 ; j < 1001 ; j++) {
				dp[i][j] = -1;
			}
		}
	
		
		System.out.println(func(0,0));
		
		for (int i = 0 ; i < 8 ; i++) {
			for (int j = 0 ; j < 7; j++){
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}
	}
	
	public static int func(int x,int y) {
		
		if ( x == W || y == W) {
			return 0;
		}
		
		int ret = dp[x][y];
		if ( ret != -1) {
			return ret;
		}
		ret = inf;
		
		int p = Math.max(x, y) + 1;
		int len1 = Math.abs(fir[x].x-fir[p].x) + Math.abs(fir[x].y - fir[p].y);
		int n1 = func(p,y) + len1;
		
		int len2 = Math.abs(sec[y].x-sec[p].x) + Math.abs(sec[y].y - sec[p].y);
		int n2 = func(x,p) + len2;
		
		ret = Math.min(n1, n2);
		return dp[x][y] = ret;
	}
	
	public static class node{
		int x,y;
	
	}
}
