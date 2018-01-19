package back11399;

import java.util.Arrays;
import java.util.Scanner;

public class Maijn {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		
		int sum = 0;
		int cnt = 0;
		int ans[] = new int[N];
		while ( cnt < N ) {
			sum += arr[cnt];
			ans[cnt] = sum;
			cnt++;
		}
		int res = 0;
		for (int i = 0 ; i < N ; i++) {
			res += ans[i];
		}
		System.out.println(res);
	}
}
