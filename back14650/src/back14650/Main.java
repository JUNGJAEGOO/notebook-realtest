package back14650;

import java.util.*;

public class Main {
	static int N;
	static HashSet<Integer> hs = new HashSet<>();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		long a = 0;
		if ( N > 1) {
			a = 2;
		}
		while ( N > 2) {
			a = (long) ((a * 3) % (1e9 + 9));
			N--;
		}
		System.out.println(a);
	}
	

}
