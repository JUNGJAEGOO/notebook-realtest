package back11058;

import java.util.Scanner;

public class Main {
	static int dp[];
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		dp = new int[N+1];
		//for (int i = 0 ; i < 5 ; i++) {
			for ( int j = 0 ; j <= N ; j++) {
				dp[j] = -1;
			}
		//}
		dp[1] =1;
		System.out.println(func(0));
	}
	

}
