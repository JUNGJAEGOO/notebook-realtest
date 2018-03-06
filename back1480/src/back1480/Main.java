package back1480;

import java.util.*;

public class Main {
	static int N,M,C;
	static int arr[];
	static int dp[][][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		C = in.nextInt();
		arr = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		dp = new int[(1<<14)+1][11][21];
		
		for (int i = 0 ; i <= 1<<14 ; i++) {
			for (int j = 0 ; j < 11 ; j++) {
				for (int k = 0 ; k < 21 ; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		System.out.println(func(0,0,0));
		
	}
	
	public static int func(int visit,int bag,int w) {
		
		if ( bag == M) {
			return 0;
		}
		System.out.println(visit+" "+bag+ " "+w);
		int ret = dp[visit][bag][w];
		if ( ret  != -1) {
			return ret;
		}
		ret = 0;
		
		for ( int i = 1 ; i <= N ; i++) {
			if ( ( visit&(1<<i) ) == 0) {
				if ( arr[i-1] + w <= C) {
					ret = Math.max(ret, 1+func((visit|(1<<i)),bag,arr[i-1]+w) );
				}
			}
		}
		ret = Math.max(ret, func(visit,bag+1,0));
		
		
		return dp[visit][bag][w] = ret;
	}
}
