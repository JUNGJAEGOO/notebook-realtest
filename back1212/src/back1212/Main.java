package back1212;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] c = in.nextLine().toCharArray();
		
		if ( c.length == 1) {
			int x = Integer.parseInt(String.valueOf(c));
			if ( x == 0) {
				System.out.println(0);
				return;
			}
		}
		
		char[] ans = new char[c.length*3];
		int cnt = 3;
		
		for ( int i = 0 ; i < c.length; i++) {
			
			if ( c[i] == '0') {
				ans[cnt*i] = '0';
				ans[cnt*i+1] = '0';
				ans[cnt*i+2] = '0';
			}else if ( c[i] == '1') {
				ans[cnt*i] = '0';
				ans[cnt*i+1] = '0';
				ans[cnt*i+2] = '1';
			}else if ( c[i] == '2') {
				ans[cnt*i] = '0';
				ans[cnt*i+1] = '1';
				ans[cnt*i+2] = '0';
			}else if ( c[i] == '3') {
				ans[cnt*i] = '0';
				ans[cnt*i+1] = '1';
				ans[cnt*i+2] = '1';
			}else if ( c[i] == '4') {
				ans[cnt*i] = '1';
				ans[cnt*i+1] = '0';
				ans[cnt*i+2] = '0';
			}else if ( c[i] == '5') {
				ans[cnt*i] = '1';
				ans[cnt*i+1] = '0';
				ans[cnt*i+2] = '1';
			}else if ( c[i] == '6') {
				ans[cnt*i] = '1';
				ans[cnt*i+1] = '1';
				ans[cnt*i+2] = '0';
			}else if ( c[i] == '7') {
				ans[cnt*i] = '1';
				ans[cnt*i+1] = '1';
				ans[cnt*i+2] = '1';
			}
			
			
		}
		
		StringBuilder sb = new StringBuilder();
		boolean pass = false;
		for (int i = 0 ; i < ans.length ; i++) {
			if ( ans[i] == '1') {
				pass = true;
			}
			if ( pass) {
				sb.append(ans[i]);
			}
		}
		System.out.print(sb);
	}
}
