package back10990;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for ( int i = 0 ; i < N ; i++) {
			
			for ( int j = 0 ; j < 2*N - 1 ; j++ ) {
				
				if ( j == (2*N - 1 )/ 2 - i) {
					sb.append("*");
				}else if ( j == ( 2*N - 1)/2 + i ) {
					sb.append("*");
				}
				else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
