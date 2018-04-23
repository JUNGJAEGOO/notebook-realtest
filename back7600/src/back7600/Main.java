package back7600;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		
		while ( true ) {
			int cnt[] = new int[26];
			char[] str = in.nextLine().toUpperCase().toCharArray();
			if(  str[0] == '#') {
				break;
			}
			
			for ( int i = 0 ; i < str.length ; i++) {
				
				if ( str[i] >= 'A' && str[i] <= 'Z') {
					cnt[str[i]-'A']++;
				}
				
			}
			
			int res = 0;
			for ( int i = 0 ; i < 26;i++) {
				if ( cnt[i] >= 1) {
					res++;
				}
			}

			System.out.println(res);
		}
		
	}
}
