package back12738;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		int dp[] = new int[N];
		dp[0] = arr[0];
		int len = 1;
		for (int i = 1 ; i < N ; i++) {
			
			if ( arr[i] > dp[len-1]) {
				dp[len] = arr[i];
				len++;
			}else if ( arr[1] < dp[0]) {
				dp[0] = arr[1];
			}
			else {
				
				int idx = Arrays.binarySearch(arr, 0, len,arr[i]);
				
				if ( idx < 0 ) {
					idx = -idx - 1;
				}
				//System.out.println(arr[i]+" "+idx+" "+len);
				
				dp[idx] = arr[i];
				
			}
			
		}
		
		for (int i = 0 ; i < N ;  i++) {
			System.out.print(dp[i]+" ");
		}System.out.println();
		
		System.out.println(len);
		
	}
}
