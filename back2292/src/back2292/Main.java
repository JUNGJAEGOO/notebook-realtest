package back2292;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		
		int count = 6;

		
		int idx=1;
		int start = 2;
		int next = start;
		if ( n == 1) {System.out.println(1); return;}
		while ( true ) {
			start = next;
			next = next + 6*idx;
			
			if ( n >= start && n < next) {

				System.out.println(idx+1);
				break;
			}
			
			idx++;
		}
		
	}
}
