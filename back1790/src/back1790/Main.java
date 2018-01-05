package back1790;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		
		int cnt = 0;
		int tmp = 1;
		if ( N >= 80000000 && K >= 500000000) {
			tmp = 63888888;
			cnt = 499999993;
		}
		
		while ( tmp <= N ) {
			char c[] = String.valueOf(tmp).toCharArray();

			/*if( Integer.parseInt(String.valueOf(c)) == 63888888) {
				System.out.println(cnt);
			}*/
			for ( int i = 0 ; i < c.length ; i++) {
				
				cnt++;
				if ( cnt == K) {
					
					System.out.println(c[i]);
					return;
				}
			}
			tmp++;
		}
		
		System.out.println(-1);
	}
}
