package back5585;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = {500,100,50,10,5,1};
		int cnt = 0;
		N = 1000 -N;
		int start = 0;
		while ( true ) {

			if ( N - arr[start] >= 0) {
				N -= arr[start];
				cnt++;
			}else {
				start++;
			}
			
			if ( N == 0) {
				break;
			}
		}
		
		System.out.println(cnt);
	}
}
