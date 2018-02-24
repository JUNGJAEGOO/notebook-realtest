package back9237;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		
		int least = 0;
		int day = 2;
		for (int i =  N - 1 ; i >= 0 ; i--) {
			System.out.println(day+" ");
			if ( day + arr[i] > least) {
				least =  Math.max(least,day+arr[i]) ;
			}
			day++;
			
		}
	
		System.out.println(least);
	}
}
