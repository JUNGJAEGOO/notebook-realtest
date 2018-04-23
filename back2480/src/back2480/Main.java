package back2480;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		
		if ( A == B && B == C) {
			System.out.println(10000+A*1000);
		}else if ( A == B && B != C) {
			System.out.println(1000+A*100);
		}else if ( A == C && C != B) {
			System.out.println(1000+A*100);
		}else if ( B == C && A != B) {
			System.out.println(1000+B*100);
		}else {
			int max = Math.max(A,B);
			max = Math.max(max,C);
			System.out.println(max*100);
		}
	}
}
