package back2798;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int arr[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		int ans = 0;
		boolean first = true;
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = i+1 ; j < N ; j++ ) {
				for ( int k = j+1 ; k < N ; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if ( first ) {
						if ( M - sum >= 0) {
						first = false; 
						ans = sum; 
						}
						continue;
					}
					if ( M - sum >= 0) {
						if ( M - sum < M - ans) {
							ans = sum;
						}
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}
