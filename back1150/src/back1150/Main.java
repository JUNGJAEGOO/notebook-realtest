package back1150;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int arr[] = new int [n];
		for (int i = 0 ; i < n ; i++) {
			arr[i] = in.nextInt();
		}
		
		Arrays.sort(arr);
		
		int cnt = 0;
		long sum = 0;
		for (int i = 0 ; i < k ; i++) {
			
			sum = sum + arr[cnt+1] - arr[cnt];
			cnt += 2;
		}
		System.out.println(sum);
	}
}
