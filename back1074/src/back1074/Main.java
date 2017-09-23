package back1074;
import java.util.*;
public class Main {

	static int count = 0;
	static int mat[][];
	static int size;
	static int savecount = 0;
	static int r,c;
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
	    r = in.nextInt();
		c = in.nextInt();
		
		mat = new int[(int)Math.pow(2, N)+2][(int)Math.pow(2, N)+2];
		size = N;
		r++;
		c++;
		
		BFS(size,1,1);

		
		
/*		for ( int i =1 ; i <=(int)Math.pow(2, N) ; i++ ) {
			for ( int j = 1 ; j <=(int)Math.pow(2, N) ; j++ ) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}*/
		
		System.out.println(savecount);
	}
	
	public static void BFS(int size,int x,int y) {
		
		if ( size == 1) {
		
		mat[x][y] = count;
		if(x== r && y == c) { savecount = count; return; }
		count++;
		mat[x][y+1] = count;
		if(x== r && y+1 == c) { savecount = count; return; }
		count++;
		mat[x+1][y] = count;
		if(x+1== r && y == c) { savecount = count; return;}
		count++;
		mat[x+1][y+1] = count;
		if(x+1 == r && y+1 == c) { savecount = count; return;}
		count++;
		}
		else if( size != 1) {
			
			BFS(size-1,x,y);
			BFS(size-1,x,(int)Math.pow(2, size-1)+y);
			BFS(size-1,(int)Math.pow(2, size-1)+x,y);
			BFS(size-1,(int)Math.pow(2, size-1)+x,(int)Math.pow(2, size-1)+y);
			
			
		}
		
	}
	
}
