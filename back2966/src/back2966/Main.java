package back2966;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		
		char[] st = in.nextLine().toCharArray();
		
		char sang[] = {'A','B','C'};
		char chang[] = {'B','A','B','C'};
		char hyun[] = {'C','C','A','A','B','B'};
		
		char sangANS[] = new char[st.length];
		char changANS[] = new char[st.length];
		char hyunANS[] = new char[st.length];
		
		int cnt = 0;
		for ( int i = 0 ; i  < sangANS.length ; i++ ) {
			sangANS[i] = sang[cnt];
			cnt++;
			if ( cnt >= sang.length) {
				cnt = 0;
			}
		}
		
		cnt = 0;
		for ( int i = 0 ; i  < changANS.length ; i++ ) {
			changANS[i] = chang[cnt];
			cnt++;
			if ( cnt >= chang.length) {
				cnt = 0;
			}
		}
		
		cnt = 0;
		for ( int i = 0 ; i  < hyunANS.length ; i++ ) {
			 hyunANS[i] =  hyun[cnt];
			cnt++;
			if ( cnt >=  hyun.length) {
				cnt = 0;
			}
		}
		
		int s = 0;
		int c = 0;
		int h = 0;
		//System.out.println(sangANS.length+" "+changANS.length+" "+hyunANS.length);
		for ( int i = 0 ; i < sangANS.length ; i++) {
			if ( sangANS[i] == st[i]) {
				s++;
			}
		}
		
		for ( int i = 0 ; i < changANS.length ; i++) {
			if ( changANS[i] == st[i]) {
				c++;
			}
		}
		
		for ( int i = 0 ; i < hyunANS.length ; i++) {
			if ( hyunANS[i] == st[i]) {
				h++;
			}
		}
		
		int max = 0;
		max = Math.max(max, s);
		max = Math.max(max, c);
		max = Math.max(max, h);
		
		System.out.println(max);
		if ( max == s) {
			System.out.println("Adrian");
		}
		if ( max == c) {
			System.out.println("Bruno");
		}
		if ( max == h) {
			System.out.println("Goran");
		}
		
	}
}
