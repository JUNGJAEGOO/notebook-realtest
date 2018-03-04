package back2455;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int sum = 0;
		int max = sum;
		for (int i = 0 ; i < 4 ; i++) {
			int out = in.nextInt();
			int board = in.nextInt();
			
			sum -= out;
			sum += board;
			max =Math.max(max, sum);
		}
		System.out.println(max);
	}
}
