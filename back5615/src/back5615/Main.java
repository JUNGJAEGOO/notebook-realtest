package back5615;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int ans = 0;
		for ( int i = 0 ; i < N ; i++) {
			int S = in.nextInt();
			int x = 1;
			boolean pass = false;
			while ( true ) {
				
				if ( (S-x) % (2*x+1) == 0) {
					pass = true;
					break;
				}
				if ( x >= S ||  2 * x * (x + 1)  >= (1<<31)) {
					break;
				}
				x++;
			}
			
			if ( pass) {
				ans++;
			}
		}
		System.out.println(N-ans);
	}
}
