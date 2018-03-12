package back15560;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Q = in.nextInt();
		int U = in.nextInt();
		int V = in.nextInt();
		int arr[] = new int[N+1];
		for ( int i = 1 ; i <= N ; i++) {
			arr[i] = in.nextInt()*U+V;
		}
		
		for ( int i = 0 ; i < Q ; i++) {
			
			int com = in.nextInt();
			if ( com == 0) {
				int A = in.nextInt();
				int B = in.nextInt();
				
				int max = -1000000000;
				
				int sum = 0;
				for ( int j = A ; j<= B ; j++) {
					sum = Math.max(sum, 0) + arr[j];
					max = Math.max(sum, max);
				}
				
				System.out.println(max-V);
			}else {
				int A = in.nextInt();
				int B = in.nextInt();
				arr[A] = B*U+V;
				
			}
			
		}
	}
}
