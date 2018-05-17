package back10205;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		
		StringBuilder sb  =new StringBuilder();
		
		for ( int test = 1 ; test <= T ; test++) {
			
			int N = Integer.parseInt(in.nextLine());
			char[] tmp = in.nextLine().toCharArray();
			
			for ( int j = 0 ; j < tmp.length ; j++) {
				
				
				if ( tmp[j] == 'c') {
					N++;
				}else {
					N--;
				}
				
				if ( N == 0) {
					break;
				}
			}
			
			
			sb.append("Data Set "+test+":\n");
			sb.append(N+"\n\n");
		}
		
		System.out.print(sb);
	}

}
