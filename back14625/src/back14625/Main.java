package back14625;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int startH = in.nextInt();
		int startM = in.nextInt();
		int endH = in.nextInt();
		int endM = in.nextInt();
		int sniper = in.nextInt();
		char N = String.valueOf(sniper).charAt(0);
		
		int sum = 0;
		while ( true ) {
			
			char[] tmp1;
			char[] tmp2;
			if ( startH >= 10 ) {
				tmp1 = String.valueOf(startH).toCharArray();
			}else {
				tmp1 = new char[2];
				tmp1[0] = '0';
				tmp1[1] = String.valueOf(startH).charAt(0);
			}
			
			if ( startM >= 10) {
				tmp2 = String.valueOf(startM).toCharArray();
			}else {
				tmp2 = new char[2];
				tmp2[0] = '0';
				tmp2[1] = String.valueOf(startM).charAt(0);
			}
			
			boolean pass = false;
			
			for ( int i = 0 ; i < tmp1.length ; i++) {
				if ( tmp1[i] == N) {
					pass = true;
				}
			}
			
			for ( int i = 0 ; i < tmp2.length ; i++) {
				if ( tmp2[i] == N) {
					pass = true;
				}
			}
			
			//System.out.println(tmp1[0]+""+tmp1[1]+" "+tmp2[0]+""+tmp2[1]);
			if ( pass ) {
				sum++;
			}
			
			if ( startM == endM && startH == endH) {
				break;
			}
			
			startM++;
			if ( startM == 60) {
				startM = 0;
				startH++;
				if ( startH == 24) {
					startH = 0;
				}
			}
			
			
		}
		
		System.out.println(sum);
	}
}
