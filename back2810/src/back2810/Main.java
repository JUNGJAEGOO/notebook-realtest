package back2810;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		Stack<Character> st = new Stack<>();
		char[] input = in.nextLine().toCharArray();
		for (int i = 0 ; i < N ; i++) {
			st.add(input[i]);
		}
		
		int cnt = 0;
		int s= 0;
		while ( !st.isEmpty() ) {
			
			char tmp = st.pop();
			if ( tmp == 'L') {
				st.pop();
			}else {
				s++;
			}
			cnt++;
		}
		if ( s == N) {
			System.out.println(N);
		}else {
			System.out.println(cnt+1);
		}
	}
}
