package back2281;

import java.util.Scanner;

public class Main {
	static int n,m;
	static int arr[];
	static int dp[][];
	static int inf = 1000000000;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		arr = new int[n];
		for (int i = 0 ; i < n ; i++) {
			arr[i] = in.nextInt();
		}
		
		dp = new int[1001][1002];
		for(int i = 0 ; i<= 1000 ; i++) {
			for(int j = 0 ; j <= 1001 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		boolean[] visit = new boolean[m+1];
		System.out.println(func(0,0,0));
		
	}
	
	public static int func(int row,int col,int idx) {
		
		System.out.println(row+" "+col+" "+idx+" ");

		if ( idx == n) {
			return 0;
		}
		
		int ret = dp[row][col];
		if ( ret != -1) {
			return ret;
		}
		ret = inf;
		
		int now = inf;
	
		if ( col+arr[idx]+1 <= m+1) {
			
			now = func(row,col+arr[idx]+1,idx+1);
		}

		int next = func(row+1,arr[idx],idx+1)+(m-col+1)*(m-col+1);
		
		
		ret = Math.min(ret,Math.min(now, next));
		
		System.out.println(ret);
		
		return dp[row][col] = ret;
	}
}
