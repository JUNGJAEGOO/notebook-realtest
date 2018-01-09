package back3986;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		int ans = 0;
		for ( int i = 0 ; i < N ; i++) {
			String input = in.nextLine();

			if ( pandan(input)) {
				ans++;
			}
		}
		System.out.println(ans);
		
	}
	
	public static boolean pandan(String input) {
		String tmp = input;
		char c[] = tmp.toCharArray();
		Stack<Character> st = new Stack<>();
		
		int cnt = c.length-1;
		st.add(c[cnt]);

		
		while ( true ) {
			cnt--;
			if( cnt < 0) {
				break;
			}
			
			if ( c[cnt] == st.peek()) {
				st.pop();
			}else {
				st.push(c[cnt]);
			}
			
			if ( st.size() == 0) {
				if ( cnt == 0) {
					break;
				}
				cnt--;
				st.push(c[cnt]);
				
			}
			
		}
		
		//System.out.println(st.size()+","+c.length);
		if ( st.size() != 0) {
			
			return false;
		}
		return true;
	}
}
