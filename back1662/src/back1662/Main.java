package back1662;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		char inner[] = input.toCharArray();
		
		while ( true) {
		int savefirst = -1;
		int beforefirst = -1;
		int num = 0;
		for ( int i = 0 ; i < inner.length ; i++) {
			if ( inner[i] == '(') {
				beforefirst = savefirst;
				savefirst = i;
				num++;
			}
		}
		int savelast = inner.length;
		for ( int i = 0 ; i < inner.length ; i++) {
			if ( inner[i] == ')') {
				savelast = i;
				break;
			}
		}
		
		if ( savefirst == -1) {
			break;
		}
		String dogoo ="";
		
		for ( int i = beforefirst+1 ; i <= savelast ; i++) {
			dogoo += inner[i];
		}

		String res = back(dogoo);
		System.out.println(res);
		char tmp[] = new char[beforefirst+1+num-1+res.length()];
		for (int i = 0 ; i < beforefirst+1 ; i++) {
			tmp[i] = inner[i];
		}
		System.out.println(tmp);
		int n = savefirst;
		char tt[] = res.toCharArray();
		for ( int i = 0 ; i < tt.length ; i++ ) {
			
			tmp[n+i] = tt[i];
		}
		for ( int i = savefirst+tt.length ; i < tmp.length ; i++) {
			tmp[i] = ')';
		}
		inner = tmp;
		System.out.println(inner);
		break;
		
		}
	}
	
	public static String back(String in) {
		String ans ="";
		char[] ha = in.toCharArray();
		int saveidx = -1;
		String num ="";
		for ( int i = 0 ; i < in.length() ; i++) {
			
			if ( ha[i] == '(') {
				saveidx = i;
				break;
			}
			num += String.valueOf(ha[i]);
		}
		
		System.out.println("num: "+num);
		
		int banbok = Integer.parseInt(String.valueOf(num));
		in = in.substring(saveidx+1, in.length()-1);
		System.out.println(in);
		for ( int i = 0 ; i < banbok ; i++) {
			ans += in;
		}
		return ans;
	}
}
