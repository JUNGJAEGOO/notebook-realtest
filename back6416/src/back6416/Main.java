package back6416;

import java.util.*;

public class Main {

	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int k = 0;
		while ( true) {
			k++;
			
			HashSet<Integer> hs = new HashSet<>();
			HashSet<Integer> check = new HashSet<>();
			boolean pass = true;
			int branch = 0;
			while ( true) {
				int x = in.nextInt();
				int y = in.nextInt();
				
				
				if ( x == 0 && y == 0) {
					break;
				}
				
				if ( x == -1 && y == -1) {
					return;
				}
				
				branch ++;
				if ( !check.contains(y) ) {
					check.add(y);
				}else {
					pass = false;
				}
				hs.add(x);
				hs.add(y);
				
			}

			//System.out.println(branch+" "+hs.size());
			
			
			if ( branch >0 &&  branch + 1 != hs.size()  ) {
				pass = false;
			}
			
			
			if ( pass == false ) {
				System.out.println("Case "+k+" is not a tree.");
			}else {
				System.out.println("Case "+k+" is a tree.");
			}
			
		}
	}
	

}
