package back14501;

import java.util.Scanner;

public class Main {
	static int arr[][];
	static int dp[];
	static int N;
	static int res = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N+1][2];
		for ( int i = 1 ; i <= N ; i++) {
			arr[i][0] = in.nextInt(); // 날짜 
			arr[i][1] = in.nextInt(); // 임금
		}
		dp = new int[N+1];
		for ( int i = 0 ; i <= N ; i++) {
			
				dp[i] = -1;
			
		}
		
		for ( int i = 1 ; i <=N; i++) {
			//System.out.println(func(i,arr[i][0],arr[i][1]));
			//System.out.println("하하하 "+arr[i][1]);
			 func(i+arr[i][0]-1,arr[i][1]);
		}
		System.out.println(res);
	}
	
	public static int func(int now,int sum) {
		
		//System.out.println(now+","+sum+" "+res);
		
		if ( now > N) {
			return 0;
		}
		
		//System.out.println(res);
		
		if ( sum > res) {
			res = sum;
		}
		
		int ret = dp[now];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		//int ret = 0;
		//System.out.println("---");
		for ( int i = now+1; i <= N ; i++) {
			ret = Math.max(ret, func(i+arr[i][0]-1,sum+arr[i][1])); 
		}
		
		return ret;
	}
}
