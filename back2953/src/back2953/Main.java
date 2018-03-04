package back2953;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int mat[][] = new int[5][4];
		int max = 0;
		int maxidx = 0;
		for (int i = 0 ; i < 5 ; i++) {
			int sum = 0;
			
			for (int j = 0 ; j < 4 ; j++) {
				mat[i][j] = in.nextInt();
				sum += mat[i][j];
			}
			
			if ( sum > max) {
				max = sum;
				maxidx = i;
			}
		}
		System.out.println(maxidx+1+" "+max);
		
	}
}
