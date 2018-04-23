package back11005;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int B = in.nextInt();
		
		String str = "";
		while ( N > 1 ) {
			
			int X = (N%B);
			char plus = ' ';
			if ( X >= 10) {
				plus = (char)('A' + (X-10) );
			}else {
				plus = String.valueOf(X).charAt(0);
			}
			
			str += plus;
			N /= B;
			//System.out.println(N);
			
		}
		
		if ( N != 0) {
			str += N;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		sb = sb.reverse();
		
		
		System.out.println(sb);
	}
}
