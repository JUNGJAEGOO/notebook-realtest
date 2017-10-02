package back1760;
import java.util.*;
public class Main {
	static int mat[][];
	static int M,N;
	static int max = 0;
	static int count = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
	
		M = in.nextInt();
		N = in.nextInt();
		mat = new int[M][N];
		
		for ( int i = 0 ; i < M ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		
		BFS(0);
		
		System.out.println(max);
	}
	
	
	public static void BFS(int start) {
		
		if ( start < M) {
			
			for ( int i = 0 ; i< M ; i++) {
				
				if ( search(start,i) == 1) {
				mat[start][i] = 3;
				}
				BFS(start+1);
				if(mat[start][i] == 3) {
				mat[start][i] = 0;
				}
				
			}
			
			
		}
		
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < N ; j++) {
				//System.out.print(mat[i][j]+" ");
				if(mat[i][j]==3) {count++;}
			}
			//System.out.println();
		}
		
		//System.out.println(count);
		if ( max < count ) {
			max = count;
		}
		
		count = 0;
	}
	
	public static int search(int x,int y) {
		
	int right = 0 , left = 0 , up = 0 , down = 0;	
	
	if ( mat[x][y] == 2 || mat[x][y] == 1) {
		return 0;
	}
	
	for(int i=0; y+i<N;i++) {
		if ( mat[x][y+i] == 2 ) {
			right = y+i;
			break;
		}
		else {
			right = N-1;
		}
	}
	for(int i=0; y-i>=0;i++) {
		if ( mat[x][y-i] == 2 ) {
			left = y-i;
			break;
		}
		else {
			left = 0;
		}
	}
	for(int i=0; x+i<M;i++) {
		if ( mat[x+i][y] == 2 ) {
			down = x+i;
			break;
		}
		else {
			down = N -1 ;
		}
	}
	for(int i=0; x-i>=0;i++) {
		if ( mat[x-i][y] == 2 ) {
			up = x-i;
			break;
		}
		else {
			up = 0;
		}
	}

		for(int i=0;y+i<right;i++) {
			if ( mat[x][y+i] == 1 ) {
				continue;
			}
			if ( mat[x][y+i] == 3 ) {
				return 0;
			}
		}
		for(int i=0;y-i>left;i++) {
			if ( mat[x][y-i] == 1 ) {
				continue;
			}
			if ( mat[x][y-i] == 3 ) {
				return 0;
			}
		}
		for(int i=0;x-i>up;i++) {
			if ( mat[x-i][y] == 1 ) {
				continue;
			}
			if ( mat[x-i][y] == 3 ) {
				return 0;
			}
		}
		for(int i=0;x+i<down;i++) {
			if ( mat[x+i][y] == 1 ) {
				continue;
			}
			if ( mat[x+i][y] == 3 ) {
				return 0;
			}
		}
		
		return 1;
	}
}
