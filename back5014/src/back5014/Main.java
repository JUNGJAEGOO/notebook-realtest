package back5014;

import java.util.*;

public class Main {
	static int dp[];
	static int S,G,F,U,D;
	static int inf = 100000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		F = in.nextInt();
		S = in.nextInt();
		G = in.nextInt();
		U = in.nextInt();
		D = in.nextInt();
		dp = new int[1000001];
		Arrays.fill(dp, inf);
		func(S,0);
		
		if ( S == G) {
			System.out.println(0);
			return;
		}
		
		if ( dp[G] == inf) {
			System.out.println("use the stairs");
		}else {
			System.out.println(dp[G]);
		}
		
	}
	
	public static void func(int len,int cost) {
		
		//System.out.println(len+" "+cost);
		
		if ( len == G) {
			return;
		}
		
		
		if ( len+U <= F && dp[len+U] > cost +1) {
			dp[len+U] = cost + 1;
			func(len+U,cost+1);
		}
		if ( len-D >= 1 && dp[len-D] > cost +1) {
			dp[len-D] = cost + 1;
			func(len-D,cost+1);
		}
	
		
	}
}
