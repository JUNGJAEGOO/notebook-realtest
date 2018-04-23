package back5893;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] ori = new char[2000];
		char[] str = in.nextLine().toCharArray();
		
		for ( int i = 0 ; i < str.length ; i++) {
			ori[2000-i-1] = str[str.length-i-1];
		}
		
	/*	for ( int i = 0 ; i < 2000 ; i ++) {
			System.out.print(ori[i]);
		}System.out.println();
		*/
		char[] gob = {'1','0','0','0','1'};
		
		char[] ans = new char[2000];
		Arrays.fill(ans, '0');
		
		for ( int i = 1999 ; i >= 0 ; i--) {
			if ( ori[i] == '1') {
				for( int j = 4 ; j >= 0 ; j--) {
					if ( ans[i+j-4] == '0') {
						ans[i+j-4] = gob[j];
					}else if ( gob[j] == '1' && ans[i+j-4] == '1'){
						
						int now = i+j-4;
						ans[now] = '0';
						now--;
						while ( true ) {
							if ( ans[now] == '1' ) {
								ans[now] = '0';
								now--;
							}else {
								ans[now] = '1';
								break;
							}
						}
						
					}
					
				}
			}
		}
		
		boolean firstone = true;
		for ( int i = 0 ; i < 2000 ; i ++) {
			if ( firstone == true && ans[i] == '1') {
				firstone = false;
				System.out.print(1);
				continue;
			}
			if ( firstone == false) {
				System.out.print(ans[i]);
			}
		}
		
	}
}
