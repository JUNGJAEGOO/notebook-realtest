package back14490;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(":");
		
		int A = Integer.parseInt(info[0]);
		int B = Integer.parseInt(info[1]);
		
		if ( A%B == 0) {
			A /= B;
			B /= B;
		}
		
		int max = Math.max(A, B);
		int cnt = 2;
		
		while ( cnt <= max/2 ) {
			
			if ( A%cnt == 0 && B%cnt == 0) {
				A/=cnt;
				B/=cnt;
			}else {
				cnt++;
			}
		}
		
		System.out.println(A+":"+B);
	}
}
