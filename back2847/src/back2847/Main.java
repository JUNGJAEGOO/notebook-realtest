package back2847;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		int cnt = 0;
		for ( int i = N-2 ; i>= 0 ; i--) {
			
			while ( arr[i] >= arr[i+1]) {
				arr[i]--;
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
	}
}
