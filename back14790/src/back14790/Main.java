package back14790;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int count = 1;
		while ( T> 0) {
			
			int N = in.nextInt();
			int save = N;
			
			for ( int i = N ; i >= 1 ; i--) {
				
				boolean pass = check(i);
				if ( pass ) {
					save = i;
					break;
				}
				
			}
		
			
			System.out.println("Case #"+count+": "+save);
			count++;
			
			T--;
		}
	}
	
	public static boolean check(int x) {
		char[] tmp = String.valueOf(x).toCharArray();
		for ( int i = 1 ; i < tmp.length ; i++) {
			
			if ( tmp[i] < tmp[i-1]) {
				return false;
			}
			
		}
		
		return true;
	}
}
