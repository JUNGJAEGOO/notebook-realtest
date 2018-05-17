package back9325;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for (int test = 0 ; test < T ; test++) {
			int sum = in.nextInt();
			int n = in.nextInt();
			for ( int i = 0 ; i < n ; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				sum += x*y;
			}
			
			System.out.println(sum);
		}
	}
}
