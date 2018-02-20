package back14652;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		
		int r = (K) / M;
		int c = (K) % M;
		System.out.println(r+" "+(c));
	}
}
