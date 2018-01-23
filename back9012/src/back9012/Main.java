package back9012;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while ( T > 0 ) {
			
			Stack<Character> st = new Stack<>();
			char [] input = in.nextLine().toCharArray();
			for ( int i = 0 ; i < input.length ; i++) {
				char x = input[i];
				if ( !st.isEmpty() ) {
					if ( x == '(' ) {
						st.add(x);
					}else if ( x== ')') {
						if ( st.peek() == '(' ) {
							st.pop();
						}
					}
				}else {
					st.add(x);
				}
				
			}
			
			if ( st.size() > 0) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
			
			T--;
		}
	}
}
