package back2670;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		double arr[] = new double[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextDouble();
		}
		
		double max = 0;
		
		for ( int i = 0 ; i < N ; i++) {
			
			double sum = arr[i];
			max = Math.max(sum, max);
			
			for ( int j = i+1 ; j < N ; j++) {
				
				sum *= arr[j];
				max = Math.max(sum, max);
				
			}
		}
		
		System.out.format("%.3f",max);
	}
}
