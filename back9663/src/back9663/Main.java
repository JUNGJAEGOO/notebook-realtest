package back9663;
import java.util.*;

public class Main {

	
	static int mat[][];
	static int N;
	static int result = 0;
	public static void main(String args[]) {
		

		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		mat = new int[N][N];
		
		search(1);
		
		System.out.println(result);
	}
	
	public static void search(int start) {
		
		if ( start <= N ) {
			
			for(int y = 0 ; y < N ; y ++) {
		    //System.out.println(start-1+"와 "+y);
			
			if(check(start-1,y)==1) {
			mat[start-1][y] = 1;
			
			search(start+1);
			
			mat[start-1][y] = 0;
			}
			
			}

		}
		else {
			result++;
		}
		
		return;
		
		
	}
	
	public static int check(int x,int y) {
		
		for(int i = 0 ; i < N ; i++) {
			if ( mat[i][y]==1 ) { return 0; }
		}
		
		int tmpy = y;
		int tmpy2 = y;
		for(int i=  x ; i >= 0 ; i--) {
			if ( tmpy>=N ) { break; }
			 //System.out.println("원"+tmpy);
			if ( mat[i][tmpy] == 1 ) { return 0; }
			tmpy++;
		}
		for(int i=  x ; i >= 0 ; i--) {
			if ( tmpy2<0 ) { break;}
			//System.out.println(tmpy2);
			if ( mat[i][tmpy2] == 1 ) { return 0; }
			tmpy2--;
		}
		
		
		return  1;
	}
}
