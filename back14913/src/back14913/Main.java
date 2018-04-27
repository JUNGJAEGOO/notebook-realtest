package back14913;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int d = in.nextInt();
		int k = in.nextInt();
		
		int cnt = 1;
		
		while ( true ) {
			
			if ( a == k ) {
				System.out.println(cnt);
				return;
			}
			
			if ( cnt > 10000000) {
				break;
				
			}
			cnt++;
			a+=d;
		}
		
		System.out.println("X");
	}
}
