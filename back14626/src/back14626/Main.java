package back14626;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] str = in.nextLine().toCharArray();
		
		int idx = -1;
		int sum = 0;
		for ( int i = 0 ; i < str.length ; i++) {
			if ( str[i] == '*') {
				idx = i;
				continue;
			}
			
			if ( (i+1) % 2 == 1) {
				sum += Integer.parseInt(String.valueOf(str[i]));
			}else {
				sum += 3 * Integer.parseInt(String.valueOf(str[i]));
			}
			
		}
		
		//System.out.println(idx+" "+sum);
		
		int save = -1;
		if ( (idx + 1 ) % 2 == 1) {
			for ( int i = 0 ; i <= 9 ; i++) {
				if ( ( (sum + i) % 10 ) == 0) {
					save = i;
					break;
				}
			}
		}else {
			for ( int i = 0 ; i <= 9 ; i++) {
				//System.out.println((sum + 3*i) % 10 );
				if ( ( (sum + 3*i) % 10 ) == 0) {
					save = i;
					break;
				}
			}
		}
		
		System.out.println(save);
	}
}
