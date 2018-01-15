package back2011;


import java.util.Scanner;

public class Main {
	public static String T;
	public static char[] Target;
	static long dp[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		T = in.nextLine();
		Target = T.toCharArray();
		
		if ( T.equals("0")) {
			System.out.println(0);
			return;
		}
		
		dp = new long[5001];
		for ( int i = 0 ; i<= 5000 ; i++) {
				dp[i] = -1;
			
		}
		
		long ans = 0;
		ans += func(0);

		System.out.println(ans);
	}
	
	public static long func(int len) {
		
		if ( len == T.length() ) {
			return 1;
		}
		

		if ( len > T.length() ) {
			return 0;
		}
		
		
		long ret = dp[len];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if ( Target[len] == '0') {
			return 0;
		}
		
		
		if ( len+1 < T.length() ) {
			int sib = Integer.parseInt(String.valueOf(Target[len]));
			int il = Integer.parseInt(String.valueOf(Target[len+1]));
			
			if ( sib == 1) {
				ret += func(len+2) % 1000000;
			}else if ( sib == 2 && il <= 6) {
				ret += func(len+2) % 1000000;
			}
		}
		if ( len < T.length()) {
			ret += func(len+1) % 1000000 ;
		}
		
		return dp[len] = (ret ) % 1000000;
	}
}


}

