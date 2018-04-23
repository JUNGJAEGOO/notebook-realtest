package back13199;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while ( T > 0) {
			
			int P = in.nextInt();
			int M = in.nextInt();
			int F = in.nextInt();
			int C = in.nextInt();
			
			int couponS = 0;
			int couponD = 0;
			
			int moneyS = M;
			int moneyD = M;
			
			int chickenS = 0;
			int chickenD = 0;
			
			while ( true ) {
				if ( moneyS >= P) {
					moneyS -= P;
					couponS += C;
					chickenS++;
					chickenD++;
					moneyD -= P;
					couponD += C;
				}else {
					break;
				}
			}
			
			while ( true) {
				
				if ( couponS >= F) {
					couponS -= F;
					chickenS++;
					couponS += C;
				}else {
					break;
				}
				
			}
			
			while ( true) {
				
				if ( couponD >= F) {
					couponD -= F;
					chickenD++;
				}else {
					break;
				}
				
			}
			
			System.out.println(chickenS-chickenD);
			
			T--;
		}
	}
}
