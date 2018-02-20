package back14655;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr1[] = new int[N];
		int arr2[] = new int[N];
		long sum1 = 0;
		long sum2 = 0;
		for (int i = 0 ; i < N ; i++) {
			arr1[i] = in.nextInt();	
			sum1+= arr1[i];
		}
		for (int i = 0 ; i < N ; i++) {
			arr2[i] = in.nextInt();
			sum2+= arr2[i];
		}
		
		
		for (int i = 0 ; i < N-2 ; i++) {
			
			if ( arr1[i] < 0) {
				arr1[i] = -arr1[i];
				arr1[i+1] = -arr1[i+1];
				arr1[i+2] = -arr1[i+2];
			}
			
		}
		
		for (int i = 0 ; i < N-2 ; i++) {
			if ( arr2[i] > 0) {
				arr2[i] = -arr2[i];
				arr2[i+1] = -arr2[i+1];
				arr2[i+2] = -arr2[i+2];
			}
			
		}
		long max = 0 , min = 0;
		for (int i = 0 ; i < N ; i++) {
			max += arr1[i];
			min += arr2[i];
		}
		
		System.out.println(max-min);
		
	}
}
