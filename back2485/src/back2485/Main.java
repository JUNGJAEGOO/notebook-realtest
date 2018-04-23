package back2485;

import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		ArrayList<Integer> diff = new ArrayList<>();
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
			if ( i >= 1 ) {
				if ( !diff.contains(arr[i]-arr[i-1]) ) {
					diff.add(arr[i]-arr[i-1]);
				}
			}
			
		}
		//System.out.println(diff);
		BigInteger A = BigInteger.valueOf(diff.get(0));
		//System.out.println(A.gcd(BigInteger.valueOf(diff.get(1))));
		for ( int i = 1 ; i < diff.size() ; i++) {
			A = A.gcd(BigInteger.valueOf(diff.get(i)));
		}
		
		//System.out.println(A);
		int sum = 0;
		for ( int i = 1 ; i < N ; i++) {
			sum += ( (arr[i]-arr[i-1]) / A.intValue() ) - 1;
		}
		System.out.println(sum);
		
	}
}
