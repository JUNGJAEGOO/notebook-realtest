package back4949;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		while ( true ) {
			
			String now = in.nextLine();
			if ( now.equals(".")) {
				break;
			}
			
			Stack<Character> st = new Stack<>();
			for ( int i = 0 ; i < now.length() ; i++) {
				st.add(now.charAt(i));
			}
			
			boolean pass = true;
			
			Stack<Character> res = new Stack<>();
			
			while ( !st.isEmpty() ) {
				
				char c = st.pop();
				if ( c == ']') {
					res.add(c);
				}
				if ( c == ')') {
					res.add(c);
				}
				
				if ( c == '[') {
					if ( res.size() == 0) {
						pass= false;
						break;
					}
					if ( res.peek() == ']') {
						
						res.pop();
					}else {
						pass =false;
						break;
					}
				}
				if ( c == '(') {
					if ( res.size() == 0) {
						pass= false;
						break;
					}
					if (  res.peek() == ')') {
						res.pop();
					}else {
						pass = false;
						break;
					}
				}
				
				
			}
			
			if ( res.size() != 0) {
				pass = false;
			}
			
			if ( pass ) {
				sb.append("yes\n");
			}else {
				sb.append("no\n");
			}
			
			
		}
		
		System.out.print(sb);
		
	}
}
