package back3985;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		int N = in.nextInt();
		
		int arr[] = new int[L+1];
		
		int originMAX = 0;
		int originMAXER = 0;
		
		for ( int i = 0 ; i < N ; i++) {
			
			int from = in.nextInt();
			int to = in.nextInt();
			
			if ( to - from > originMAX) {
				originMAX = to - from;
				originMAXER = i+1;
			}else if ( to - from == originMAX) {
				if ( i+1 < originMAXER ) {
					originMAXER = i + 1;
				}
			}
			
			for ( int j = from ; j <= to ; j++) {
				if ( arr[j] == 0 ) {
					arr[j] = i+1;
				}
			}
			
		}
		
		int sum [] = new int[N+1];
		for ( int i = 1 ; i < L  ; i++) {
			
			sum[arr[i]]++;
			
		}
		
		int MAX = 0;
		int MAXER = 0;
		
		for ( int i = 1 ; i<= N ; i++) {
			//System.out.println(i+" "+sum[i]);
			
			if ( MAX < sum[i] ){
				MAX = sum[i];
				MAXER = i;
			}else if ( MAX == sum[i]) {
				if ( i < MAXER) {
					MAXER = i;
				}
			}
		}
		
		
		System.out.println(originMAXER+"\n"+MAXER);
	}
}
