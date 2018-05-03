package back1449;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int L = in.nextInt();
		
		boolean visit[] = new boolean[1001];
		Arrays.fill(visit, true);
		for ( int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			visit[x] = false;
		}
		
		int cnt = 0;
		for ( int i = 0 ; i < 1001 ; i++) {
			
			if ( visit[i] == false) {
				cnt++;
				for ( int j = i ; j < i + L ; j++) {
					if ( j > 1000 ) {
						break;
					}
					visit[j] = true;
				}
			}
			
		}
		
		System.out.println(cnt);
	}
}
