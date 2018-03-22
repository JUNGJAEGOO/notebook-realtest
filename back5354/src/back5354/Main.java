package back5354;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			int N = in.nextInt();
			for ( int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < N ;j++) {
					if ( j == 0 || j == N-1 || i == 0 || i == N-1) {
						System.out.print("#");
					}else {
						System.out.print("J");
					}
				}System.out.println();
			}System.out.println();
			
			
			T--;
		}
	}
}
