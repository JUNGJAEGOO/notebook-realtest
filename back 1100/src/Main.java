import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[][] mat = new char[8][8];
		for ( int i = 0 ; i <  8 ; i++) {
			char[] tmp = in.nextLine().toCharArray();
			for (int j = 0 ; j  < 8 ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		
		int sum = 0;
		for (int i = 0 ; i < 8 ;i++) {
			for ( int j = 0 ; j < 8 ; j++) {
				
				if ( i % 2 == 0) {
					if ( j % 2 == 1) {
						
					}else {
						if ( mat[i][j] == 'F') {
							sum++;
						}
					}
				}else {
					if ( j % 2 == 1) {
						if ( mat[i][j] == 'F') {
							sum++;
						}
					}else {
						
					}
				}
				
			}
		}
		
		System.out.println(sum);
	}
}
