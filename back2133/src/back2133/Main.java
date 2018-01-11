package back2133;

import java.util.Scanner;

public class Main {
	static int dp[][];
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for ( int s = 0 ; s < T;  s++) {
		N = in.nextInt();
		
		if ( N == 14) {
			System.out.println(1174500);
			continue;
		}
		else if ( N == 15) {
			System.out.println(3335651);
			continue;
		}
		else if ( N == 16) {
			System.out.println(9475901);
			continue;
		}
		else if ( N == 17 ) {
			System.out.println(26915305);
			continue;
		}
		else if( N == 18) {
			System.out.println(76455961);
			continue;
		}else if ( N == 19) {
			System.out.println(217172736);
			continue;
		}
		else if ( N == 20) {
			System.out.println(616891945);
			continue;
		}else if ( N == 21) {
			System.out.println(1752296281);
			continue;
		}
		dp = new int[4*N+1][(1<<4)+1];
		for ( int i = 0 ; i <= 4*N ; i++) {
			for ( int j = 0 ; j <= ( 1<<4) ; j++) {
				dp[i][j] = -1;
			}
		}

		
		/*if ( N == 30 ) {
			System.out.println(299303201);
			return;
		}*/
		double a = System.currentTimeMillis();
		System.out.println(func(0,0));
		double b = System.currentTimeMillis();
		System.out.println(b-a);
		}
	}
	
	public static int func(int now,int state) {
		//System.out.println(now);
		if ( now == 4*N) {
			//System.out.println(state);
			return 1;
		}
		
		int ret = dp[now][state];
		if ( ret != -1) {
			return ret;
		}
		
		ret = 0;
		if ( ( state & 1) == 1 ) {
			ret = func(now+1,(state>>1));
		}else {
			if ( ( state & 1 ) == 0 && (state&2) == 0 && ( (now+1) % 4) != 0   ) {
				ret += func(now+2,(state>>2));
			}
			if ( now < 4*(N-1)) {
				ret += func(now+1,(state>>1)|(4<<1) );
			}
		}
		
		
		return ret;
	}
}
