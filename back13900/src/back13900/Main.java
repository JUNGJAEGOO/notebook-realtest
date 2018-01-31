package back13900;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
			
		}
		Arrays.sort(arr);
		
		long sum[] = new long[N];
		sum[0] = arr[0];
		for (int i = 1 ; i < N ; i++) {
			sum[i] = sum[i-1]+arr[i];
		}
		
		BigInteger ans = BigInteger.ZERO;
		for ( int i = 0 ; i < N-1 ; i++) {
			ans = ans.add(BigInteger.valueOf(arr[i]*(sum[N-1]-sum[i])));
		}
		System.out.println(ans);
		
	}
}
