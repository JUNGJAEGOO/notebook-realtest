package back2240;

import java.util.Scanner;

public class Main2 {
	static int time[];
	static int dp[][][];
	static int T,W;
	static int ans = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		W = in.nextInt();
		time = new int[T+1];
		for ( int i = 1 ; i <= T; i ++) {
			time[i] = in.nextInt();
		}
		dp = new int[2][1001][31];
		
			for ( int j = 0 ; j < 2 ; j++) {
				for ( int k = 0 ; k< 1001 ; k++) {
					for ( int s = 0 ; s < 30 ; s++) {
							dp[j][k][s] = -1;
						
					}
				}
			}
		
		
		System.out.println(func(1,0,0));
		//System.out.println(ans);
		
	}
	
	public static int func(int len,int lr,int move) {
		
		//System.out.println(left+","+right+" "+len+"초 "+sum+" 움직임  "+move+" "+time[len]);
		
		System.out.println(lr+" "+len+"초 "+" 움직임  "+move);
		
		if ( len == T+1) {
			return 0;
		}
		
		
		//System.out.println("쌀았다");
		
		int ret = dp[lr][len][move];
		if ( ret != -1) {
			return ret;
		}
		
		if ( time[len] == lr) {
			int A = 0;
			int B = 0;
			
			if ( move < W) {
				A = Math.max(func(len+1,lr,move)+1, func(len+1,lr^1,move+1));
			}else {
				B = func(len+1,lr,move)+1;
			}
			return ret = Math.max(A, B);
			
		}
		else {
			int A = 0;
			int B = 0;
			
			if ( move < W) {
				A = Math.max(func(len+1,lr,move), func(len+1,lr^1,move+1)+1);
			}else {
				B = func(len+1,lr,move);
			}
			return ret = Math.max(A, B);
			
		}

	}
}
