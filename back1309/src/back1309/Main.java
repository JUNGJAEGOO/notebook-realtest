package back1309;
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner ( System.in);
		int N = in.nextInt();
		
		int dp[] = new int[100002];
		
		dp[1] = 3;
		dp[2] = 7;
		if ( N>2) {
		for ( int i = 3 ; i<=N ; i++) {
			dp[i] = 2*dp[i-1] + dp[i-2];
		}
		}
		System.out.println(dp[N]);
	}
}
