package back1173;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int m = in.nextInt();
		int M = in.nextInt();
		int T = in.nextInt();
		int R = in.nextInt();
		int max = M;
		int min = m;
		int sec = 0;
		int num = 0;
		
		if ( min + T > max) {
			System.out.println(-1);
			return;
		}
		
		while ( true ) {
			if ( m+T <= M) {
				m = m + T;
				num++;
				sec++;
			}else {
				m = m - R;
				if ( m < min) {
					m = min;
				}
				sec++;
			}
			
			if ( N == num) {
				break;
			}
		}
		
		System.out.println(sec);
	}
}
