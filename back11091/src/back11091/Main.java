package back11091;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		
		for ( int i = 0 ; i < N ; i++) {
			
			int alpha[] = new int[26];
			
			char c[] = in.nextLine().toLowerCase().toCharArray();
			
			for ( int j = 0 ; j < c.length ; j++) {
				
				if( c[j] - 'a' >= 0 && c[j] - 'a' < 26 ) {
					alpha[c[j]-'a']++;
				}
				
			}
			
			String missing =  "";
			for ( int j = 0 ; j < 26 ; j++) {
				if ( alpha[j] == 0 ) {
					missing += (char)(j + 'a');
				}
			}
			
			if ( missing.length() == 0) {
				System.out.println("pangram");
			}else {
				System.out.println("missing "+missing);
			}
			
		}
	}
}
