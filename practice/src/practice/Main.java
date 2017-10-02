package practice;
import java.util.*;
public class Main {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int mat[][] = new int[N][N];
		int min[][] = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				mat[i][j] = 1000;
			}
		}
		
		for(int i = 0 ; i < 7 ; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			int cost = in.nextInt();
			mat[x][y] = cost;
			mat[y][x] = cost;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int k = 0 ; k < N ; k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if ( mat[i][k] + mat[k][j] < mat[i][j]){
						mat[i][j] = mat[i][k] + mat[k][j];
						min[i][j] = k;
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("하악");
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(min[i][j]+" ");
			}
			System.out.println();
		}
	}
}
