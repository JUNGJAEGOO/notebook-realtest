package back4740;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while ( true ) {
			
			String str = in.nextLine();
			if ( str.equals("***")) {
				break;
			}
			char c[] = str.toCharArray();
			ArrayList<Character> list = new ArrayList<>();
			for ( int i = 0 ; i < c.length ; i++) {
				list.add(c[i]);
			}
			
			Collections.reverse(list);
			
			for ( int i = 0 ; i < list.size() ; i++) {
				sb.append(list.get(i));
			}sb.append("\n");
			//System.out.println(sb);
		}
		
		System.out.println(sb);
	}
	
}
