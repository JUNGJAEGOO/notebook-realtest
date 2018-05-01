package back9011;

import java.util.Scanner;

// 그리디 ?

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for ( int testcase = 0 ; testcase < T ; testcase++) {
			
			int N = in.nextInt();
			int arr[] = new int[N];
			for ( int i = 0 ; i < N ; i++) {
				arr[i] = in.nextInt();
			}
			
			int res[] = new int[N];
			boolean ok[] = new boolean[N+1];
			
			res[N-1] = arr[N-1] + 1;
			ok[arr[N-1]+1] = true;
			
			boolean pass = true;
			
			lop:
			for ( int i = N-2 ; i >= 0 ; i--) {

				int limit = arr[i] + 1;
				while ( true ) {
					
					int sum = 0;
					for ( int j = 1 ; j<= limit ; j++) {
						if ( ok[j] == false) {
							sum++;
						}
					}
					
					if ( sum >= arr[i] + 1 ) {
						break;
					}
					limit++;
					
					if ( limit > N ) {
						pass = false;
						break lop;
					}
					
				}
				
				res[i] = limit;
				ok[limit] = true;
			}
			if ( pass == false) {
				System.out.println("IMPOSSIBLE");
			}else {
				
				for (int i = 0 ; i < res.length ; i++) {
					System.out.print(res[i]+" ");
				}System.out.println();
				
			}
			
			
		}
	}
}
