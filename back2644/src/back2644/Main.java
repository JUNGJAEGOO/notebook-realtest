package back2644;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int start = in.nextInt()-1;
		int end = in.nextInt()-1;
		
		int mat[][] = new int[N][N];
		int M = in.nextInt();
		int inf = 1000000000;
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = inf;
			}
		}
		
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt()-1;
			int to = in.nextInt()-1;
			mat[from][to] = 1;
			mat[to][from ] = 1;
		}
		
		for (int k=0; k < N ;k++) {
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					if ( mat[i][j] > mat[i][k] + mat[k][j]) {
						mat[i][j] = mat[i][k] + mat[k][j];
					}
				}
			}
		}
		
		if ( mat[start][end] == inf) {
			System.out.println(-1);
		}else {
			System.out.println(mat[start][end]);
		}
		
		
	}
}
