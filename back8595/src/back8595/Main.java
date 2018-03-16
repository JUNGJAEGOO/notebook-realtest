package back8595;

import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		char arr[] = in.nextLine().toCharArray();
		Deque<Character> dq = new LinkedList<Character>();
		for (int i = 0 ; i < N ; i++) {
			dq.addLast(arr[i]);
		}
		//System.out.println((int)'0');
		BigInteger sum = BigInteger.ZERO;
		StringBuilder str = new StringBuilder();;
		while (!dq.isEmpty() ) {
			
			char now = dq.removeFirst();
			
			boolean pass = false;
			
			if ( (int)now >= 48 && (int)now <= 57) {
				pass = true;
			}
			//System.out.println(pass+" "+now);
			
			if ( pass ) {
				str.append(now);
				
			}else {
				
				//System.out.println(str);
				if ( str.length() <= 6 && str.length() >= 1) {
					sum = sum.add(BigInteger.valueOf(Long.parseLong(str.toString())));
				}
				str = new StringBuilder();;;
			}

		}
		
		if ( str.length() <= 6 && str.length() >= 1) {
			sum = sum.add(BigInteger.valueOf(Long.parseLong(str.toString())));
		}
		
		
		System.out.println(sum);
		
	}
	

}
