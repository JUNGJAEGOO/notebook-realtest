package back1507;

import java.util.Scanner;

public class Main {
	static boolean visit[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int mat[][] = new int[N][N];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		visit= new boolean[N];
	
	}
	
	
}
