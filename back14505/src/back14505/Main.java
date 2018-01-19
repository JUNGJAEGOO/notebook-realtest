package back14505;

import java.util.Scanner;

public class Main {
	
	static int dp[][];
	static char input[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		input = in.nextLine().toCharArray();
		dp = new int[input.length][input.length];
		for ( int i = 0 ; i < input.length ; i++) {
			for ( int j = 0 ; j < input.length ; j++) {
				if ( j == i) {
					dp[i][j] = 1;
				}else {
					dp[i][j] = -1;
				}
			}	
		}
		
		System.out.println(func(0,input.length-1));
	
	}
	
	public static int func(int start,int end) {
		
		System.out.println(start+" "+end);
		
		if ( start > end) {
			return 0;
		}
		
		int ret = dp[start][end];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		for ( int i = start ; i < end ; i++) {
			if ( input[i] == input[end] ) {
				ret += func(i+1,end-1)+1;
			}
		}
		
		ret+= func(start,end-1)+1;
		
		return dp[start][end] = ret;
	}
}
