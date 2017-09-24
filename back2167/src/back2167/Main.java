package back2167;
import java.util.*;
public class Main {

	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int mat[][] = new int[N+2][M+2];
		
		
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= M ; j++ ) {
				mat[i][j] = in.nextInt();
			}
		}
		
		int K = in.nextInt();
		int x1;
		int y1;
		int x2;
		int y2;
		int sum[] = new int[K];
		for ( int i = 0 ; i < K ; i++) {
			x1 = in.nextInt();
			y1 = in.nextInt();
			x2 = in.nextInt();
			y2 = in.nextInt();
			
			for ( int k = x1 ; k <= x2 ; k++) {
				for ( int j = y1 ; j <= y2 ; j++ ) {
					sum[i] = sum[i] + mat[k][j]; 
				}
			}
			
		}
		

		for(int i = 0 ; i < K ; i++) {
			System.out.println(sum[i]);
		}
		
	}
}
