package back12024;

import java.util.*;

public class Main {
	static int N;
	static long mat[][];
	static boolean visit[];
	static int dist[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		mat = new long[N][N];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		long before[][] = new long[N][N];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				before[i][j] = mat[i][j];
			}
		}
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				
				for ( int k = 0 ; k < N ; k++) {
					mat[i][j] += before[i][k] * before[k][j];
				}
				
			}
		}


		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				System.out.print(mat[i][j]+" ");
			}System.out.println();
		}
		
	}

}
