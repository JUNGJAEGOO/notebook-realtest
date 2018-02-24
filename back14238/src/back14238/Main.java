package back14238;

import java.util.*;

public class Main {
	static char[] N;
	static int a = 0 ,b = 0,c = 0;
	static ArrayList<String> visit = new ArrayList<>();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextLine().toCharArray();
		for (int i = 0 ; i < N.length ; i++) {
			if ( N[i] == 'C') {
				c++;
			}else if ( N[i] == 'A') {
				a++;
			}else if ( N[i] == 'B') {
				b++;
			}
		}
		
		func("");
		System.out.println(-1);
	}
	
	public static void func(String str) {
		//System.out.println(str);
		
		if ( visit.contains(str) ) {
			return;
		}
		visit.add(str);
		
		if ( str.length() == N.length) {
			System.out.println(str);
			System.exit(0);
		}
		
		if ( str.length() == 0 ) {
			if ( a > 0 ) {
				a--;
				func("A");
				a++;
			}
			if ( b >  0 ) {
				b--;
				func("B");
				b++;
			}
			if ( c > 0 ) {
				c--;
				func("C");
				c++;
			}
		}else if ( str.length() == 1) {
			if ( a > 0) {
				a--;
				func(str+"A");
				a++;
			}
			if ( b > 0 && !str.equals("B") ) {
				b--;
				func(str+"B");
				b++;
			}
			if ( c > 0 && !str.equals("C")) {
				c--;
				func(str+"C");
				c++;
			}
		}
		else {
		
			if ( a > 0 ) {
				a--;
				func(str+"A");
				a++;
			}
			if ( b >  0 && str.charAt(str.length()-1) != 'B') {
				b--;
				func(str + "B");
				b++;
			}
			if ( c > 0 && str.charAt(str.length()-1) != 'C' && str.charAt(str.length()-2) != 'C') {
				c--;
				func(str + "C");
				c++;
			}
		
		}
	}
}
