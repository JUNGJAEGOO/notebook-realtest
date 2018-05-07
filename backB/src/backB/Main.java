package backB;

import java.util.*;

public class Main {
	static int N,T,P;
	static int dp[];
	static int arr[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		T = in.nextInt();
		P = in.nextInt();
		
		dp = new int[100001];
		Arrays.fill(dp,-1);
		
		arr = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
	}
	
	public static int func(int idx,int time) {
		
		
		if ( idx == N) {
			return 0;
		}
		
		
		
		
	}
}
