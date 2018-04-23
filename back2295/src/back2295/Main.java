package back2295;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long arr[] = new long[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextLong();
		}
		
		HashMap<Long,Long> ab = new HashMap<>();
		for (int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				ab.put(arr[i]+arr[j],arr[i]+arr[j]);
			}
		}
		
		int ans = -10000000;
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				if ( ab.get(arr[i]-arr[j]) != null) {
					ans = (int) Math.max(arr[i],ans);
				};
			}
		}
		
		System.out.println(ans);
		
	}

}
