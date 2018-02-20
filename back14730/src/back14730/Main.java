package back14730;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long sum = 0;
		for (int i = 0 ; i < N ; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			sum += a*1*b;
		}
		System.out.println(sum);
	}
}
