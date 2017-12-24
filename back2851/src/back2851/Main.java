package back2851;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in  = new Scanner(System.in);
		int arr[] = new int[10];
		for ( int i = 0 ; i < 10 ; i++) {
			arr[i] = in.nextInt();
		}
		
		int sum[] = new int[10];
		sum[0] = arr[0];
		for ( int i = 1 ; i < 10 ; i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		
		int ans = 0;
		int before = sum[0];
		for (int i = 1 ; i < 10 ; i++) {
			
			if ( Math.abs(sum[i] - 100) > Math.abs(before - 100)) {
				System.out.println(before);	
				return;
			}else if (Math.abs(sum[i] - 100) == Math.abs(before - 100) ) {
				System.out.println(sum[i]);
				return;
			}
			before = sum[i];
		}
		
		System.out.println(sum[9]);
	}
	
}
