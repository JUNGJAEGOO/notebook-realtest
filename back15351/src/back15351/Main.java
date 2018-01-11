package back15351;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		for ( int i = 0 ; i < N ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			long sum = 0;
			for ( int j = 0 ; j < tmp.length ; j++) {
				int x = tmp[j];
				x -= 64;
				if ( x > 0) {
					sum += x;
				}

			}
			if ( sum == 100) {
				System.out.println("PERFECT LIFE");
			}else {
				System.out.println(sum);
			}
		}
	}
}
