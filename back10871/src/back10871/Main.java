package back10871;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int arr[] = new int[N];
		
		for (int i = 0 ; i < N ; i++) {
			int tmp = in.nextInt();
			arr[i] = tmp;
		}
		
		int i = 0;
		int j = 0;
		long sum = arr[0];
		//Arrays.sort(arr);
		int res = 0;
		while ( true ) {
			
			if ( sum > M ) {
				sum -= arr[i];
				i++;
				if ( i >= N || j >= N) {
					break;
				}
			}else if ( sum < M) {
				j++;
				if ( i >= N || j >= N) {
					break;
				}
				sum+= arr[j];
			}else if ( sum == M) {
				//System.out.println(i+","+j);
				j++;
				res++;
				if ( i >= N || j >= N) {
					break;
				}
				sum += arr[j];
				
			}
			
			
			
		}
		
		System.out.println(res);
		
	}
}
