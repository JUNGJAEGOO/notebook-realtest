package back2490;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		for ( int i = 0 ; i < 3 ; i++) {
			int zero = 0;
			int one = 0;
			
			for ( int j = 0 ; j < 4 ; j++) {
				int x = in.nextInt();
				if ( x == 0) {
					zero++;
				}else {
					one++;
				}
			}
			
			if ( zero == 4) {
				System.out.println("D");
			}else if ( zero == 1 && one == 3) {
				System.out.println("A");
			}else if ( zero == 2 && one == 2) {
				System.out.println("B");
			}else if ( zero == 3 && one == 1) {
				System.out.println("C");
			}else if ( one == 4) {
				System.out.println("E");
			}
			
		}
	}
}
