package back2942;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int R = in.nextInt();
		int G = in.nextInt();
		StringBuilder sb= new StringBuilder();
		
		int max = Math.max(R,G);
		int cnt = 1;
		
		while ( cnt <= max ) {
			
			if ( R%cnt == 0 && G%cnt == 0) {
				sb.append(cnt+" "+(R/cnt)+" "+(G/cnt)+"\n");
			}
			cnt++;
		}
		
		System.out.println(sb);
	}
}
