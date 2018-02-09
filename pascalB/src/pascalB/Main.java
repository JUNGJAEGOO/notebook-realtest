package pascalB;

import java.util.*;

public class Main {
	static int arr[];
	static int dp[];
	static int N,K;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		arr = new int[N+2];
		for (int i = 2 ; i <= N+1 ; i++) {
			arr[i] = in.nextInt();
		}
		dp = new int[N+3];
		
		for (int j = 0 ; j <= N+2 ; j++) {
			dp[j] = -1;
		}
		
		System.out.println(func(0,0,false));
		
	}
	
	public static int func(int len,int idx,boolean first) {
		
		System.out.println(len+" "+idx);
		
		if ( len == K) {
			return 0;
		}
		
		int ret = dp[len];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if ( first) {
			for (int i = idx+2 ; i <= N ; i++) {
				if ( i == 2) {
					ret= Math.max(ret, arr[i]+func(len+1,i,true));
				}
				ret = Math.max(ret, arr[i]+func(len+1,i,first) );
			}
		}else {
			for (int i = idx+2 ; i <= N+1 ; i++) {
				if ( i == 2) {
					ret= Math.max(ret, arr[i]+func(len+1,i,true));
				}
				ret = Math.max(ret, arr[i]+func(len+1,i,first) );
			}
		}
		
		return dp[len] = ret;
	}
}
