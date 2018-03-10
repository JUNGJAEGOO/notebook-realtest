package back9455;

import java.util.*;

public class Main {
	static int mat[][];
	static int m,n;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			
			m = in.nextInt();
			n = in.nextInt();
			mat = new int[m][n];
			for (int i = 0 ; i < m ; i++) {
				for (int j = 0 ; j < n ; j++) {
					mat[i][j] = in.nextInt();
				}
			}
			
			
			System.out.println(godown());
			
			
			
			
			
			
			T--;
		}
	}
	
	public static int godown() {
		
		int count = 0;
		for (int j = 0 ; j < n ; j++) {
			int over = 0;
			for ( int i = m-1 ; i >= 0 ; i-- ) {
				if ( mat[i][j] == 1) {
					count += Math.abs((m-1)-i-over);
					over++;
				}
			}
			
		}
		
		return count;
		
	}
}
