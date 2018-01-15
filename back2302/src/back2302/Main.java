package back2302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int vip[];
	static long dp[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		vip = new int[M+1];
		int arr[] = new int[N+1];
		for ( int i = 1 ; i<= N ; i++) {
			arr[i] = i;
		}
		for ( int i = 1 ; i <= M ; i++) {
			
			vip[i] = in.nextInt();
			arr[vip[i]] = 0;
		}

		Arrays.sort(vip);
		dp = new long[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for ( int i = 3 ; i<= 40 ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		int cnt = 0;
		ArrayList<Integer> block = new ArrayList<>();
		for ( int i = 1 ; i <= N ; i++) {
			if ( arr[i] == 0 ) {
				block.add(cnt);
				cnt = 0;
			}else if ( i== N ){
				cnt++;
				block.add(cnt);
			}
			else {
				cnt++;
			}
		}
		
		long ans = 1;
		//System.out.println(block);
		int zeros = 0;
		for ( int i = 0 ; i < block.size() ; i++) {
			if ( block.get(i) == 0) {
				zeros++;
			}
				//System.out.println(dp[block.get(i)]);
				ans *= dp[block.get(i)];
			
		}
		if ( zeros == block.size() ) {
			System.out.println(1);
		}else {
			System.out.println(ans);
		}
	}
	
		
}
