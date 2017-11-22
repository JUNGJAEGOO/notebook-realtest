package back2869;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		int V = in.nextInt();
		int day = 0;
		while ( true ) {
			V -= A;
			day++;
			if ( V <= 0 ) {
				break;
			}
			V += B;
		}
		
		System.out.println(day);
				
	}
}
