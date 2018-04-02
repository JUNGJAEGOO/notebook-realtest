package back12849;

import java.util.*;

public class Main {
	static int D;
	static long dp[][];
	static int arr[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		//D = in.nextInt();
		dp = new long[100001][9];
		for ( int i = 0 ; i <= 100000 ; i++) {
			for ( int j = 0 ; j < 9 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		arr = new int[9][9];
		arr[1][2] = 1;
		arr[1][3] = 1;
		
		arr[2][1] = 1;
		arr[2][3] = 1;
		arr[2][4] = 1;
		
		arr[3][1] = 1;
		arr[3][2] = 1;
		arr[3][4] = 1;
		arr[3][5] = 1;
		
		arr[4][2] = 1;
		arr[4][3] = 1;
		arr[4][5] = 1;
		arr[4][6] = 1;
		
		arr[5][3] =1;
		arr[5][4] =1;
		arr[5][6] = 1;
		arr[5][8] = 1;
		
		arr[6][5] =1;
		arr[6][4] =1;
		arr[6][7] = 1;
		
		arr[7][6] = 1;
		arr[7][8] = 1;
		
		arr[8][7] = 1;
		arr[8][5] = 1;
		
		ArrayList<Long> res = new ArrayList<>();
		
		long before = -1;
		int cnt  = 1;
		while( cnt < 1000010 ) {
		dp = new long[100001][9];
		for ( int i = 0 ; i <= 100000 ; i++) {
			for ( int j = 0 ; j < 9 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		D = cnt;
		
		long ans = (func(1,0));
		
		
		if ( !res.contains(ans) ) {
			res.add(ans);
		}else {
			System.out.println(cnt);
		}
		
		cnt++;
		}
	}
	
	public static long func(int idx,int len) {
		
		if ( len == D) {
			if ( idx == 1) {
				return 1;
			}else {
				return 0;
			}
		}
		
		long ret = dp[len][idx];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		for ( int i = 1 ; i <= 8 ; i++) {
			
			if ( arr[idx][i] == 1) {
				ret += (func(i,len+1));
				ret %= 1000000007;
			}
			
		}
		
		
		return dp[len][idx] = ret % 1000000007;
		
	}
	
}
