package back1568;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int day = 1;
		int cnt = 1;
		while( true ) {
			
			if ( N - cnt == 0 ) {
				break;
			}
			else if ( N-cnt > 0) {
				N -= cnt;
				cnt++;
				day++;
				continue;
			}
			else if ( N-cnt < 0) {
				cnt = 1;
				continue;
			}
			
		}
		
		System.out.println(day);
	}
}
