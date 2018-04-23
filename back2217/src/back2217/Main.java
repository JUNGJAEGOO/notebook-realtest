package back2217;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];

		int max = 0;
		int maxcnt = 1;
		int min = 10001;
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
			if ( arr[i] > max) {
				max = arr[i];
			}
		}
		
		Arrays.sort(arr);
		
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = arr[i] * (N-i);
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[N-1]);
		
	}
}
