package back14671;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		
		boolean pandan[][] = new boolean [2][2];
		
		for (int i = 0 ; i< K ; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			
			pandan[x&1][y&1] = true;
		
		}
	
		System.out.println(pandan[0][1] && pandan[1][0] && pandan[1][1] && pandan[0][0] ? "YES" : "NO");
		
		
	}
	
}
