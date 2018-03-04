package back10157;

import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int C = in.nextInt();
		int R = in.nextInt();
		int K = in.nextInt();
		int x = 1;
		int y = 0;
		int row = R;
		int col = C-1;
		int cnt = 0;
		int good = 1;
		
		if ( K > R*C) {
			System.out.println(0);
			return;
		}
		
		lop:
		while ( true) {
			
			for (int i = 0 ; i < row ; i++) {
				y += good;
				cnt++;
				System.out.println(x+" "+y);
				if ( cnt == K) {
					break lop;
				}
			}
			System.out.println("--------------");
			for (int i = 0 ; i < col ; i++) {
				x += good;
				cnt++;
				System.out.println(x+" "+y);
				if ( cnt == K) {
					break lop;
				}
			}
			
			row--;
			col--;
			good = -good;
		

		}
		
		System.out.println(x+" "+y);
	}
}
