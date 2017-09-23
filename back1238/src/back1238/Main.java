package back1238;
import java.util.*;
public class Main {
	
	static int mat[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int X = in.nextInt();
		mat = new int[N][N];

		
		
		for(int i = 0 ; i < N ; i++) {
			for (int j = 0;j<N ; j++) {
				mat[i][j]=987654321;
			}
		}
		
		for ( int i = 0 ; i < M ; i ++) {
		   int x = in.nextInt();
		   int y = in.nextInt();
		   int cost = in.nextInt();
		   mat[x-1][y-1] = cost;
		}
		

		
		for(int i = 0 ; i < N ; i++) {
			for (int j = 0;j<N ; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		for ( int k = 0 ; k < N ; k++) {
			for(int i = 0 ; i < N ; i ++) {
				for( int j = 0 ; j < N ; j++) {
					if(i==j) { continue; }
					if( mat[i][k]+mat[k][j] < mat[i][j] ) {
						mat[i][j]= mat[i][k]+mat[k][j];
					}
				}
			}
		}
		
		int max = 0 ; 
		for (int i = 0 ; i < N ; i++) {
			if( i != X-1) {
				max = Math.max(mat[i][X-1]+mat[X-1][i],max);
			}
		}
		
		
		for(int i = 0 ; i < N ; i++) {
			for (int j = 0;j<N ; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(max);
	}
	
	

	
}
