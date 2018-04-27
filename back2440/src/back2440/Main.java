package back2440;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		for ( int i = N ; i >= 1 ; i--) {
			for ( int j = 0 ; j < i ; j++) {
				System.out.print("*");
			}System.out.println();
		}
	}
}
