package back10156;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int K = in.nextInt();
		int N = in.nextInt();
		int M = in.nextInt();
		
		int ans = K*N - M;
		if ( ans >= 0) {
			System.out.println(ans);
		}else {
			System.out.println(0);
		}
	}
}
