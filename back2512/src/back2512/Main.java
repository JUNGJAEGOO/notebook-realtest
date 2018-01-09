package back2512;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in= new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		int max = 0;
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
			if ( arr[i] > max) {
				max = arr[i];
			}
		}
		long M = in.nextLong();
		//Arrays.sort(arr);
		
		int left = 0;
		int right = max;
		long sum = 0;
		
		for ( int i = 0 ; i < N ; i++) {
			sum += arr[i];
		}
		if ( sum < M) {
			M = sum;
		}
		while ( left <= right ) {
			int mid = (left + right) / 2;
			sum = 0;
			int limit = mid;
			for( int i = 0 ; i < N ; i++) {
				if ( arr[i] > limit) {
					sum += limit;
				}else {
					sum += arr[i];
				}
			}
			
			
			if ( sum > M) {
				right = limit -1;
				
			}else {
				left = limit + 1;
			}
			
			
			//System.out.println(sum+" 과  "+limit);
			//System.out.println("좌: "+left+"우: "+right);
			
		}
		
		System.out.println(right);
		
		
		
	}
}
