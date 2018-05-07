package back3023;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(" ");
		int R = Integer.parseInt(info[0]);
		int C = Integer.parseInt(info[1]);
		char origin[][] = new char[R][C];
		
		for ( int i = 0 ; i < R ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			for ( int j = 0 ; j < C; j++) {
				origin[i][j] = tmp[j];
			}
		}
		
		String err[] = in.nextLine().split(" ");
		//System.out.println(C);
		char two[][] = new char[R][C*2];
		
		for ( int i = 0 ; i < R ; i++) {
			
			for ( int j = 0 ; j < C ; j++) {
				two[i][j] = origin[i][j];
			}
		}
		
		for ( int i = 0 ; i < R ; i++) {
			
			for ( int j = C*2-1 ; j >= C ; j--) {
				two[i][j] = origin[i][C*2-1-j];
			}
		}
		
		char res[][] = new char[R*2][C*2];

		System.out.println(res[0].length);
		
		for (int i = 0 ; i < R ; i++) {
			for ( int j = 0 ; j < C*2 ; j++) {
				res[i][j] = two[i][j];
			}
		}
		
		for ( int i = R ; i < R*2 ; i++) {
			for ( int j = 0 ; j < C*2 ; j++) {
				res[i][j] = two[R*2-1-i][j];
			}
		}
		
		
		
		int x = Integer.parseInt(err[0]);
		int y = Integer.parseInt(err[1]);
		
		
		if ( res[x-1][y-1] == '#') {
			res[x-1][y-1] = '.';
		}else {
			res[x-1][y-1] = '#';
		}
		
		for ( int i = 0 ; i < R*2 ; i++) {
			for ( int j = 0 ; j < C*2 ; j++) {
				System.out.print(res[i][j]);
			}System.out.println();
		}
		
	}
}
