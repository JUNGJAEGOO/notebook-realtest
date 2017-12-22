package back1789;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		long N = in.nextLong();
		
		long cnt = 1;
		
		while ( true ) {
			long before = (cnt*(cnt-1))/2 + cnt;
			long after = (cnt*(cnt+1))/2 + cnt+1;
			//System.out.println(before+","+after);
			if ( before <= N && N < after  ) {
				break;
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
