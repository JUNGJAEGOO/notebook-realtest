package back10872;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long sum = 1;
		for (int i = 1 ; i <= N ; i++) {
			sum *= i;
		}
		System.out.println(sum);
	}
}
