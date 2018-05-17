package back15729;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		
		Scanner in  = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		int now[] = new int[N];
		int start = -1;
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
			
			if ( start == -1 && arr[i] == 1) {
				start = i;
			}
		}
		
		if ( start == -1) {
			System.out.println(0);
			return;
		}
		
		int cnt = 0;
		while ( true ) {
			
			if ( now[start] != arr[start]) {
				
				cnt++;
				now[start] = 1 - now[start] ;
				
				if ( start+1 < N) {
					now[start+1] = 1 - now[start+1];
				}
				
				if ( start+2 < N) {
					now[start+2] = 1 - now[start+2];
				}
			
			}
			
			start++;
			if ( start == N) {
				break;
			}
			
		}
		
		System.out.println(cnt);
		
	}
}
