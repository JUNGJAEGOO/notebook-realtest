package back11586;

import java.util.Scanner;

public class Main {
	static char mat[][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		mat = new char[N][N];
		for (int i = 0 ; i < N ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		
		int state = Integer.parseInt(in.nextLine());
		if ( state == 1) {
			for (int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					System.out.print(mat[i][j]);
				}System.out.println();
			}
		}else if ( state == 2) {
			char ans[][] = new char[N][N];
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					ans[i][j] = mat[i][N-j-1];
				}
			}
			
			for (int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					System.out.print(ans[i][j]);
				}System.out.println();
			}
		}else if ( state  == 3) {
			char ans[][] = new char[N][N];
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					ans[i][j] = mat[N-i-1][j];
				}
			}
			
			for (int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					System.out.print(ans[i][j]);
				}System.out.println();
			}
			
		}
	}
}
