package back11583;

import java.util.*;

public class Main {
	static int arr[];
	static int N,K;
	static int dp[];
	static int inf = 1000000000;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			N = in.nextInt();
			K = in.nextInt();
			arr = new int[N+1];
			for (int i = 1 ; i <= N ; i++) {
				arr[i] = in.nextInt();
			}
			dp = new int[100001];
			Arrays.fill(dp, -1);
			System.out.println(func(1,arr[1],0));
			T--;
		}
	}
	
	public static int func(int idx,long sum,int cnt) {
		
		
		if ( idx == N) {
			System.out.println(idx+" "+sum+" "+cnt);
			
			return cnt;
		}
		
		int ret = dp[idx];
		if ( ret != -1) {
			return ret;
		}
		ret = inf;
		for (int i = idx+1 ; i <= N ; i++) {
			if (  i-idx <=  K) {
				int tmpcnt = 0;
				long tmp = sum*arr[i];
				while ( true) {
					if ( (tmp)%10 == 0) {
						(tmp) /= 10;
						tmpcnt++;
					}else {
						break;
					}
				}
				ret = Math.min(ret, func(i,tmp,cnt+tmpcnt));
			}
		}
		
		return dp[idx] = ret;
	}
}
