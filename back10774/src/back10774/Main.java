package back10774;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int J = Integer.parseInt(in.nextLine());
		int A = Integer.parseInt(in.nextLine());
		
		char[] uniform = new char[J];
		for (int i = 0 ; i < J ; i++) {
			uniform[i] = in.nextLine().charAt(0);
		}
		
		boolean visit[] = new boolean[J];
		
		int cnt = 0;
		for ( int i = 0 ; i < A ; i++) {
			
			String info[] = in.nextLine().split(" ");
			char uni = info[0].charAt(0);
			int num = Integer.parseInt(info[1]) - 1;
			
			if ( visit[num] == false) {
				
				if ( uniform[num] == uni) {
					visit[num] = true;
					cnt++;
				}else {
					
					if ( uni == 'S') {
						if ( uniform[num] == 'M') {
							visit[num] = true;
							cnt++;
						}else if ( uniform[num] == 'L') {
							visit[num] = true;
							cnt++;
						}
					}else if ( uni == 'M') {
						if ( uniform[num] == 'L') {
							visit[num] = true;
							cnt++;			
						}
					}
					
				}
			}
		}
		
		System.out.println(cnt);
	}
}
