package back3058;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			int sum = 0;
			ArrayList<Integer> even = new ArrayList<>();
			for (int i = 0 ; i < 7 ; i++) {
				int tmp = in.nextInt();
				if ( tmp % 2 == 0) {
					even.add(tmp);
					sum += tmp;
				}
			}
			
			Collections.sort(even);
			System.out.println(sum+" "+even.get(0));
			
			T--;
		}
	}
}
