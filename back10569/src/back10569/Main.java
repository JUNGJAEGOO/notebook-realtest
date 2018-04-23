package back10569;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			int V = in.nextInt();
			int E = in.nextInt();
			
			int X = -V + E + 2;
			System.out.println(X);
			
			
			T--;
		}
	}
}
