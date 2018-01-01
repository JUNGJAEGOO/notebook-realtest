package back13560;

import java.util.Scanner;

public class Main {
	static int N;
	static int dp[][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int arr[] = new int[10001];
		for( int i = 1 ; i <= N ; i++) {
			arr[i] = in.nextInt();
		}
		
		
	}
	
	public static int f(int len) {
		if ( len == N) {
			return 0;
		}
		
		
		int ret = dp[][];
		ret = 0;
		
		return ret;
	}
}
