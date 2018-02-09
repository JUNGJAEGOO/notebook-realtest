package back1002;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			long x1 = in.nextLong();
			long y1 = in.nextLong();
			long r1 = in.nextLong();
			long x2 = in.nextLong();
			long y2 = in.nextLong();
			long r2 = in.nextLong();
			
			
			if ( x1 == x2 && y1 == y2) {
				
				if ( r1 != r2) {
					System.out.println(0);
				}else {
					System.out.println(-1);
				}
				
			}else {
				
				double length = Math.sqrt( Math.pow(x1-x2,2) + Math.pow(y1-y2,2) );
				
				if ( Math.abs(r1-r2) < length && length < r1 + r2 ) {
					System.out.println(2);
				}else if (  Math.abs(r1-r2) == length || r1 + r2 == length) {
					System.out.println(1);
				}else if ( length == 0 || length > r1 + r2 || length < Math.abs(r1-r2) ) {
					System.out.println(0);
				}
			}
			
			
			T--;
		}
	}
}
