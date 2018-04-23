package back14498;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		
		int A[] = new int[K];
		int B[] = new int[K];
		int choice[] = new int[K];
		
		for ( int i = 0 ; i < K ; i++) {
			A[i] = in.nextInt();
			B[i] = in.nextInt();
			choice[i] = in.nextInt();
		}
		
		int ans = K;
		
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= M ; j++) {
				
				int sum = 0;
				
				for ( int k = 0 ; k < K ; k++) {
					
					if ( choice[k] == 0) {
						
						if ( A[k] == i && B[k] != j) {
							sum++;
						}
						
					}else {
						
						if ( A[k] != i && B[k] == j) {
							sum++;
						}
					}
					
				}
				System.out.println(i+" "+j+" "+sum);
				
				ans = Math.min(ans, K-sum);
			}
		}
		
		System.out.println(ans);
	}
}
