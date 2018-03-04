package back2979;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		HashMap<Integer,Integer> hm = new HashMap<>();
		for ( int i = 0 ; i < 3 ; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			
			for (int j = start ; j < end ; j++) {
				if ( hm.get(j) == null) {
					hm.put(j, 1);
				}else {
					hm.replace(j, hm.get(j)+1);
				}
			} 
			
		}
		int sum = 0 ;
		for (int i = 1 ; i<= 100 ; i++) {
			
			if ( hm.get(i) != null) {
				System.out.println(hm.get(i)+" "+i+"초");
				if ( hm.get(i) == 1) {
					sum += A;
				}else if ( hm.get(i) == 2) {
					sum += 2*B;
				}else if ( hm.get(i) == 3) {
					sum += 3*C;
				}
			
			}
			
		}
		
		System.out.println(sum);
		
	}
}
