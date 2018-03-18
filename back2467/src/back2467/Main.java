package back2467;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		int left = 0;
		int right = N-1;
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		int sum = arr[left] + arr[right];
		int min = sum;
		int i = -1,j = -1;
		while ( true ) {
			
			if ( sum > 0) {
				if ( Math.abs(sum) <= Math.abs(min) ) {
					i = left;
					j = right;
					min = sum;
				}
				right--;
				if ( right == left) {
					break;
				}
				sum = arr[left] + arr[right];
			}
			if ( sum == 0) {
				i = left;
				j = right;
				break;
			}
			if ( sum < 0 ) {
				
				
				
				if ( Math.abs(sum) <= Math.abs(min) ) {
					i = left;
					j = right;
					min = sum;
				}
				left++;
				if ( left == right) {
					break;
				}
				sum = arr[left] + arr[right];
			}
			
			
			
			
		}
		System.out.println(arr[i]+" "+arr[j]);
	}
}
