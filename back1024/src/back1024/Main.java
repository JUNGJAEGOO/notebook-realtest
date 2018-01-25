package back1024;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int L = in.nextInt();
		long dp[] = new long[102];
	
		for ( int i = 1 ; i<= 101 ; i++) {
			dp[i] = (i * ( i - 1)) / 2 ;
		}
		
		boolean pass = true;
		int cnt = L;
		long start = 0;
		while ( true) {
			
			if ( (N - dp[cnt]) % ( cnt) == 0 ) {
				start = (N - dp[cnt]) / ( cnt);
				break;
			}
			
			cnt++;
			if ( cnt > 100) {
				pass = false;    // cnt 가 100이 넘으면 못구하는거이므로 더 볼 필요 없이 -1
				break;
			}
			
		}
		
		for ( int i = 0 ; i < cnt ; i++) {
			if ( start+i < 0 ) {
				pass = false;   // 수열에 음수가 있으면 더 볼 필요 없이 -1
				break;
			}
		}
		
		if ( pass) {
			for ( int i = 0 ; i < cnt ; i++) {
				System.out.print(start+i+" ");
			}
		}else {
			System.out.println(-1);
		}
	}
}
