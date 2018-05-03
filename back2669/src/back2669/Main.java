package back2669;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int mat[][] = new int[101][101];
		
		for ( int i = 0 ; i < 4 ; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int d = in.nextInt();
			
			for ( int j = a ; j < c ; j++) {
				for ( int k = b ; k < d ; k++) {
					mat[j][k] ++;
				}
			}
			
		}
		
		int sum = 0;
		for ( int i = 1 ; i <= 100 ; i++) {
			for (int j = 1 ; j <= 100 ; j ++) {
				System.out.print(mat[i][j]);
				if ( mat[i][j] >= 1) {
					sum++;
				}
			}
			System.out.println();
		}
		
		System.out.println(sum);
		
	}
}
