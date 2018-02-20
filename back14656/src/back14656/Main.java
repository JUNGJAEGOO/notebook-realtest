package back14656;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N+1];
		int cnt = 0;
		for (int i = 1 ; i <= N ; i++) {
			arr[i] = in.nextInt();
			if ( arr[i] != i) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
