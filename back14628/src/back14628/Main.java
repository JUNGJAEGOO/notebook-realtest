package back14628;

import java.util.*;

public class Main {
	static int M,N,K;
	static ArrayList<node> list = new ArrayList<>();
	static int cnt[];
	static int dp[][];
	static int inf = 100000000;
	static int ans = 100000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		K = in.nextInt();
		for ( int i = 0 ; i < N ; i++) {
			int mp = in.nextInt();
			int dmg = in.nextInt();
			list.add(new node(dmg,mp));
		}
		
		cnt = new int[101];
		Arrays.fill(cnt, -1);
		dp = new int[101][101];
		for ( int i = 0 ; i <101 ; i++) {
			for ( int j = 0 ; j < 101 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		int x = func(0,M);
		
		System.out.println(ans);
	}
	
	public static int func(int n,int m) {
		
		if ( n == M) {
			return 0;
		}
		
		int  ret = dp[n][m];
		if ( ret != - 1) {
			return ret;
		}
		ret = inf;
		
		ret = func(n+1,m);
		for ( int i = 1 ; i*list.get(n).mp <= m ; i++) {
			ret = Math.min(ret, func(n+1,m-list.get(n).mp*i) + list.get(n).dmg*i + K*i*(i-1)/2 );
		}
		
		return dp[n][m] = ret;
	}
	
	public static class node{
		int dmg;
		int mp;
		node (int dmg,int mp){
			this.dmg = dmg;
			this.mp = mp;
			
		}
	}
}
