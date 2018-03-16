package back1315;

import java.util.*;

public class Main {
	static int STR[];
	static int INT[];
	static int PTR[];
	static int dp[][];
	static boolean visit[];
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		INT = new int[N];
		STR = new int[N];
		PTR = new int[N];
		dp = new int[1001][1001];
		visit = new boolean[N+1];
		for (int i = 0 ; i < 1001 ; i++) {
			for (int j = 0 ; j <1001 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		for ( int i = 0 ; i < N ; i++) {
			STR[i] = in.nextInt();
			INT[i] = in.nextInt();
			PTR[i] = in.nextInt();
			
		}
		
		System.out.println(func(1,1,0));
	}
	
	public static int func(int strstr,int intint,int sum) {
		
		System.out.println(strstr+" "+intint+" "+sum);
		
		int ret = dp[strstr][intint];
		if ( ret != - 1) {
			return ret;
		}
		ret = 0;
		int point = 0;
		
		boolean pass = false;
		for ( int i = 0 ; i < N ;i++) {
			
				if ( strstr >= STR[i] || intint >= INT[i] ) {
					if ( visit[i] == false) {
						visit[i] = true;
						pass = true;
						point = PTR[i];
						for ( int s = strstr ; s <= Math.min(1000, strstr + point ) ; s++) {
							
							int k = Math.min(1000, point - (s-strstr) + intint);
								
							ret = Math.max(ret, func(s,k,sum+1));

						}
						
						visit[i] = false;
					}
					
				}
				
			
		}
		
		if ( pass == false) {
			System.out.println(strstr+" "+intint+" "+sum+" 종료 ");
			
			return sum;
		}
		
		
		return dp[strstr][intint] = ret;
	}
}
