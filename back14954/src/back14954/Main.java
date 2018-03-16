package back14954;

import java.util.*;

public class Main {
	public static void main(String args[] ){
		Scanner in = new Scanner(System.in);
		
		int start = in.nextInt();
		long x = start;
		ArrayList<Long> res = new ArrayList<>();
		res.add((long) start);
		
		while ( true) {
			
			long sum = 0;
			String tmp[] = String.valueOf(x).split("");
			for ( int i = 0 ; i < tmp.length; i++) {
				sum += (Integer.valueOf(tmp[i]) * Integer.valueOf(tmp[i]) ) ;
			}
			System.out.println(x);
			if ( x == 1 ) {
				System.out.println("HAPPY");
				return;
			}
			if ( res.contains(sum)) {
				System.out.println("UNHAPPY");
				return;
			}
			
			res.add(sum);
			x = sum;
		}
	}
}
