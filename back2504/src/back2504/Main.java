package back2504;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] input = in.nextLine().toCharArray();
		Stack<String> st= new Stack<>();
		int cnt = 0;
		long tmp = 0;
		while ( true) {
			/*if ( st.size() != 0) {
				for ( int i = 0 ; i < st.size() ; i++) {
					System.out.print(st.get(i)+" ");
				}System.out.println();
			}*/
			if ( input[cnt] == '(' || input[cnt] == '[' ) {
				st.add(String.valueOf(input[cnt]));
				cnt++;
			}else {
				if ( input[cnt] == ')' ) {
					if ( st.peek().equals("(") ) {
						if ( tmp == 0) {
							st.pop();
							st.push("2");
						}else {
							st.pop();
							st.push(String.valueOf(2*tmp));
							//System.out.println(tmp);
							tmp = 0;
						}
						cnt++;
					}else {
						if ( st.peek().equals("[") || st.peek().equals("(") ) {
							System.out.println(0);
							return;
						}
						tmp += Integer.parseInt(st.pop());
						
					}
				}
				else if ( input[cnt] == ']' ) {
					if ( st.peek().equals("[") ) {
						if ( tmp == 0) {
							st.pop();
							st.push("3");
						}else {
							st.pop();
							st.push(String.valueOf(3*tmp));
							//System.out.println(tmp);
							tmp = 0;
						}
						cnt++;
					}else {
						if ( st.peek().equals("(") || st.peek().equals("[")) {
							System.out.println(0);
							return;
						}
						tmp += Integer.parseInt(st.pop());
						
					}
				}
			}
			
			if ( cnt == input.length) {
				break;
			}
		}
		
		long res = 0;
		while ( !st.empty() ) {
			if ( st.peek().equals("(") || st.peek().equals(")") || st.peek().equals("[") || st.peek().equals("[")) {
				System.out.println(0);
				return;
			}
			res += Long.parseLong(st.pop());
		}
		System.out.println(res);
		
	}
}
