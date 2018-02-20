package back13702;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		long left = 0;
		long right = Integer.MAX_VALUE;
		
		long ans = 0;
		while ( left<=right) {
			
			long mid = (left+right)/2;
			long sum = 0;
			for (int i = 0 ; i < N ; i++) {
				sum += (arr[i]/mid);
			}
			
			System.out.println(sum+" "+mid);
			
			if ( sum < M) {
				right = mid - 1;
				
			}else {
				left = mid + 1;
				ans = mid;
			}
			
		}
		System.out.println(ans);
	}
}
