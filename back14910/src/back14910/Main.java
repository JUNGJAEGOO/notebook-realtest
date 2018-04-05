package back14910;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		boolean isGood = true;
		
		int before = -1000001;
		while( in.hasNext() ) {
			
			int x = in.nextInt();
			if ( x >= before ) {
				
			}else {
				
				isGood = false;
			}
			
			before = x;
			
		}
		
		if ( isGood) {
			System.out.println("Good");
		}else {
			System.out.println("Bad");
		}
	}
}
