package back11582;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		int K = in.nextInt();

		for (int i = 0 ; i < N ; i = i + N/K) {
			Arrays.sort(arr,i,i+N/K);
		}
		
		
		for (int i = 0 ; i< N ; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
