package back7570;

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
		int len = 0;
		for ( int i = 1 ; i < N ; i++) {
			
			if ( arr[i] > dp[len] ) {
				len++;
				dp[len] = arr[i];
			}else {
				
				int idx = Arrays.binarySearch(dp,0,len, arr[i]);
				if ( idx < 0) {
					idx = -idx - 1;
				}
				//System.out.println(arr[i]+" "+len+" "+idx);
				dp[idx] = arr[i];
				
			}
			
		}
		
		/*for (int i = 0 ; i < N ; i++) {
			System.out.print(dp[i]+" ");
		}*/
		
		System.out.println(N-(len+1));
	}
}
