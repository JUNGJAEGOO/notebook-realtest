package back11401;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		
		long boonmo = 1;
		long boonza = 1;
		
		for ( int i = N ; i >= N-K+1 ; i--) {
			boonmo = ((boonmo * i )% 1000000007);
		}
		
		for (int i = 1 ; i<= K ; i++) {
			boonza = ((boonza * i )% 1000000007);
		}
		
		boonmo %= 1000000007;
		boonza %= 1000000007;
		
		System.out.println(boonmo/boonza);
	}
	
}
