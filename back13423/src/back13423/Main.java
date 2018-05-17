package back13423;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for ( int test = 0 ; test <T ; test++) {
			
			HashMap<Integer,Integer> hm = new HashMap<>();
			int N = in.nextInt();
			int arr[]  = new int[N];
			for ( int i = 0 ; i < N ; i++) {
				arr[i] = in.nextInt();
				hm.put(arr[i],1);
				
			}
			
			
			Arrays.sort(arr);
			
			int cnt = 0;
			for( int i = 0 ; i < N ; i++) {
				
				for ( int j = i + 1 ; j < N ; j++) {
					
					int diff = arr[j] - arr[i];
					
					if ( hm.get(arr[j]+diff) != null ) {
						cnt++;
					}
					
					
				}
			}
			
			System.out.println(cnt);
			
			
			
		}
	}
}
