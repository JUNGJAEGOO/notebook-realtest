package back2588;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		
		int B1 = B/100;
		int B2 = (B/10)%10;
		int B3 = B%10;
		
		System.out.println(A*B3);
		System.out.println(A*B2);
		System.out.println(A*B1);
		System.out.println(A*B);
		
	}
}
