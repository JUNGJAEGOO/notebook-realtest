package back1613;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		long inf = 19000000;
		long mat[][] = new long[N+2][N+2];
		for (int i = 0 ; i <= N + 1 ; i++) {
			for (int j = 0 ; j <= N + 1 ; j++) {
				mat[i][j] = inf;
			}	
		}
		
		for ( int i = 0 ; i < K ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			mat[x][y] = 1;
			//mat[y][x] = -1;
		}
		
		for ( int k = 1 ; k <= N ; k++) {
			for ( int i = 1 ; i<= N ; i++) {
				for ( int j = 1 ; j <= N ; j++) {
					if ( mat[i][k]+ mat[k][j] < mat[i][j]) {
						mat[i][j] = mat[i][k] + mat[k][j];
					}
				}
			}
		}
		
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= N ; j++) {
				System.out.print(mat[i][j]+" ");
			}System.out.println();
		}
		
		int s = in.nextInt();
		for ( int i = 0 ; i < s ; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			if ( mat[start][end] == inf) {
				if ( mat[end][start] == inf) {
					System.out.println(0);	
				}
				else {
					System.out.println(1);
				}
			}else if ( mat[start][end] != inf){
					System.out.println(-1);
			}
		}
	}
}
