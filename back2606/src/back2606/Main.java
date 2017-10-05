package back2606;
import java.util.*;
public class Main {
	
	public static int inf = 10000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int mat[][] = new int[N][N];
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j <  N  ; j++) {
					mat[i][j] = inf;
			}	
		}
		
		
 		for ( int i = 0 ; i <  M  ; i++) {
			int x  = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			mat[x][y] = 1;
			mat[y][x] = 1;
		}
 		
/* 		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j <  N  ; j++) {
					System.out.print(mat[i][j]+" ");;
			}	
			System.out.println();
		}
 		System.out.println();
 		*/
 		for(int k = 0 ; k < N ; k++) {
 	 		for(int i = 0 ; i < N ; i++) {
 	 	 		for(int j = 0 ; j < N ; j++) {
 	 	 			if ( mat[i][k]+mat[k][j] < mat[i][j]) {
 	 	 				mat[i][j] = mat[i][k]+mat[k][j];
 	 	 			}
 	 	 		}	
 	 		}
 		}
 		
/* 		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j <  N  ; j++) {
					System.out.print(mat[i][j]+" ");;
			}	
			System.out.println();
		}*/
 		
 		int count = 0;
 		for ( int i = 1 ; i < N ; i ++) {
 			if( mat[0][i] != inf) {
 				count++;
 			}
 		}
 		System.out.println(count);
 		
	}
}
