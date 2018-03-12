package back5573;

import java.util.*;

public class Main {
	static int H,W,N;
	static int mat[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		H = in.nextInt();
		W = in.nextInt();
		N = in.nextInt();
		mat = new int[H+1][W+1];
		
		for (int i = 0 ; i < H ; i++) {
			for ( int j = 0 ; j < W ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		int ansX=0,ansY=0;
		for ( int s = 0 ; s < N ; s++) {
			
			int nx = 0;
			int ny = 0;
			
			
			while ( true ) {
				if ( mat[nx][ny] == 1 ) {
					int bx = nx;
					int by = ny;
					nx = nx;
					ny = ny + 1;
					if ( ny == W) {
						if ( s == N-1) {
							ansX = nx;
							ansY = ny;
						}
						//System.out.println(nx+" "+ny);
						break;
					}else {
						mat[bx][by] = 0;
					}
				}else {
					int bx = nx;
					int by = ny;
					nx = nx+1;
					ny = ny;
					if ( nx == H) {
						if ( s == N-1) {
							ansX = nx;
							ansY = ny;
						}
						//System.out.println(nx+" "+ny);
						break;
					}else {
						mat[bx][by] = 1;
					}
				}
			}
			
		}
		ansX++;
		ansY++;
		System.out.println(ansX+" "+ansY);
	}
}
