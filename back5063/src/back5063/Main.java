package back5063;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0 ) {
			
			int r = in.nextInt();
			int e = in.nextInt();
			int c = in.nextInt();
			
			if ( e - r > c) {
				System.out.println("advertise");
			}else if ( e - r == c) {
				System.out.println("does not matter");
			}else {
				System.out.println("do not advertise");
			}
			
			
			T--;
		}
	}
}
