package back1992;
import java.io.*;
public class Main {
	static int mat[][];
	static int N;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		
		for ( int i = 0 ; i < N ; i++) {
			char[] tmp = br.readLine().toCharArray();
			for ( int j = 0; j< N;j++) {
				mat[i][j] = Integer.parseInt(String.valueOf(tmp[j]));
			}
		}
		
		BFS(0,0,N);
		System.out.println();
		
		
		
/*8
00000000
00000000
00001111
00001111
00011111
00111111

00111111
00111111*/
		
		
	}

	
	public static void BFS(int x,int y,int count) {
		
		if ( count == 1 ) { 
			System.out.print(mat[x][y]);
			return; 
		}
		
		int c = 1;
		
		for ( int i = 0 ; i < count ; i++) {
			for ( int j = 0 ; j < count ; j++) {
				if ( mat[x][y] != mat[x+i][y+j]) {
					c=0;
					break;
				}
			}
			if ( c==0) {
				break;
			}
		}
		
		
		if ( c != 0  ) {
			System.out.print(mat[x][y]);
		}
		else {
		System.out.print("(");
		BFS(x,y,count/2);
		BFS(x,y+count/2,count/2);
		BFS(x+count/2,y,count/2);
		BFS(x+count/2,y+count/2,count/2);
		System.out.print(")");
		}
	}
}
