package back10159;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		int mat[][] = new int[N][N];
		
		
		for ( int i = 0 ; i < M ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			mat[x-1][y-1] = 1;
			//mat[y-1][x-1] = 1;
		}
		
		for ( int k = 0 ; k < N ; k++) {
			for ( int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					if ( mat[i][k] ==1 &&  mat[k][j] == 1) {
						mat[i][j] = 1;
					}
				}
			}
		}
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				System.out.print(mat[i][j]+" ");
			}System.out.println();
		}
		
		
		
		for ( int i = 0 ; i < N ; i++) {
			int cnt = 0;
			for ( int j = 0 ; j < N ; j++) {
				if ( mat[i][j] == 0 && mat[j][i] == 0) {
					cnt++;
				}
			}
			System.out.println(cnt-1);
		}
		
	}
}
