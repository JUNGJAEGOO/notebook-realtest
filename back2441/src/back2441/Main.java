package back2441;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for ( int i = N ; i >= 1 ; i--) {
			for (int j = N-i ; j >= 1 ; j--) {
				System.out.print(" ");
			}
			for (int j = i ; j > 0 ; j--) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
