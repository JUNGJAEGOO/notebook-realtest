package back2812;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		String str[] = in.nextLine().split("");
		Stack<Integer> st = new Stack<>();
		int before = 0;
		int cnt = 0;
		for (int i = 0 ; i < str.length ; i++) {
			if ( i == 0 ) {
				st.add(Integer.parseInt(str[i]));
				before = Integer.parseInt(str[0]);
			}else {
				if ( Integer.parseInt(str[i]) > before ) {
					while ( before < Integer.parseInt(str[i])) {
						//System.out.println("hi");
						cnt++;
						st.pop();
						if ( cnt == K) {
							break;
						}
						if ( st.size() == 0) {
							before = Integer.parseInt(str[i]);
							break;
						}
						before = (st.peek());
					}
					st.add(Integer.parseInt(str[i]));
					before = st.peek();
				}else {
					st.add(Integer.parseInt(str[i]));
					before = Integer.parseInt(str[i]);
				}
			}
			
			if ( cnt == K) {
				for ( int j = i+1 ; j < str.length ; j++) {
					//System.out.println(str[j]);
					st.add(Integer.parseInt(str[j]));
				}
				break;
			}
		}
		
		//System.out.println(cnt);
		if ( cnt == K) {
			for ( int i = 0 ; i < st.size() ; i++ ) {
				System.out.print(st.get(i));
			}
		}else {
			while ( true ) {
				st.pop();
				cnt++;
				if ( cnt == K) {break;}
			}
			
			for ( int i = 0 ; i < st.size() ; i++ ) {
				System.out.print(st.get(i));

			}
		}
		
	}
}
