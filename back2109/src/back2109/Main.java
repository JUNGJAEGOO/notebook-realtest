package back2109;

import java.util.Scanner;

public class Main {
		static int dp[];
		public static void main (String args[]) {
			Scanner in = new Scanner(System.in);
			int N = in.nextInt();
			
			dp = new int[10001];
			for ( int i = 1 ; i <= N ; i++) {
				int pay = in.nextInt();
				int day = in.nextInt();
				minus(pay,day);
			}
			
			int sum = 0;
			for ( int i = 1 ; i <= dp.length-1 ; i++) {
				if ( dp[i] != 0 ) {
				sum+=dp[i];
				}
			}
			System.out.println(sum);
			
		}
		
		public static void minus(int pay,int day) {
			int count = day;
			if ( dp[day] == 0) {
				dp[day] = pay;
				return;
			}
			while ( true ) {
				if ( pay < dp[count]) {
					count--;
				}else {
					int tmp = dp[count];
					dp[count] = pay;
					pay = tmp;
					count--;
				}
				
				if ( count == -1) { break; }
			}
		}
}
