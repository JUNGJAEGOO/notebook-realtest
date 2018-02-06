package back2615;

import java.util.Scanner;

public class Main {
	static int top;
	static int left;
	static int lx,ly;
	static int rx,ry;
	static int mat[][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		mat = new int[20][20];
		for (int i = 1 ; i <= 19 ; i++) {
			for (int j = 1 ; j <= 19 ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		for (int i = 1 ; i <= 19 ; i++) {
			for (int j = 1 ; j <= 19 ; j++) {
				
				if ( mat[i][j] == 0) {
					continue;
				}
				
				if ( updown(i,j) == 5) {
					System.out.println(mat[i][j]);
					System.out.println(top+" "+j);
					return;
				}
				if ( rightleft(i,j) == 5) {
					System.out.println(mat[i][j]);
					System.out.println(i+" "+left);
					return;
				}
				if ( upleftright(i,j) == 5) {
					System.out.println(mat[i][j]);
					System.out.println(rx+" "+ry);
					return;
				}
				if ( downleftright(i,j) == 5) {
					System.out.println(mat[i][j]);
					System.out.println(lx+" "+ly);
					return;
				}
				
				
			/*	System.out.println(i+","+j);
				System.out.print(updown(i,j)+" ");
				System.out.print(rightleft(i,j)+" ");
				System.out.print(downleftright(i,j)+" ");
				System.out.print(upleftright(i,j)+" ");
				System.out.println("\n---------");*/
			}
		}
		System.out.println(0);
	}
	

	
	public static int updown(int x,int y) {
		int origin = mat[x][y];
		int originX =x;
		int cnt = 1;
		top = x;
		while ( true) {
			x = x-1;
			if ( x < 1) {
				break;
			}
			if ( origin != mat[x][y]) {
				break;
			}
			if ( x < top) {
				top = x;
			}
			cnt++;
		}
		x = originX;
		while ( true) {
			x = x+1;
			if ( x > 19) {
				break;
			}
			if ( origin != mat[x][y]) {
				break;
			}	
			cnt++;
		}
		return cnt;
	}
	
	public static int rightleft(int x,int y) {
		int origin = mat[x][y];
		int originY =y;
		int cnt = 1;
		left = y;
		while ( true) {
			y = y-1;
			if ( y < 1) {
				break;
			}
			if ( origin != mat[x][y]) {
				break;
			}	
			if ( y < left) {
				left = y;
			}
			cnt++;
		}
		y = originY;
		while ( true) {
			y = y+1;
			if ( y > 19) {
				break;
			}
			if ( origin != mat[x][y]) {
				break;
			}	
			cnt++;
		}
		return cnt;
	}
	
	public static int downleftright(int x,int y) {
		int origin = mat[x][y];
		int originY =y;
		int originX =x;
		int cnt = 1;
		lx = x;
		ly = y;
		while ( true) {
			y = y-1;
			x = x+1;
			if ( y < 1 || x > 19) {
				break;
			}
			if ( origin != mat[x][y]) {
				break;
			}	
			if ( x > lx) {
				lx = x;
				ly = y;
			}
			cnt++;
		}
		x = originX;
		y = originY;
		while ( true) {
			x = x-1;
			y = y+1;
			if ( x<1 || y > 19) {
				break;
			}
			if ( origin != mat[x][y]) {
				break;
			}
			cnt++;
		}
		return cnt;
	}
	
	
	public static int upleftright(int x,int y) {
		int origin = mat[x][y];
		int originY =y;
		int originX =x;
		int cnt = 1;
		rx = x;
		ry = y;
		while ( true) {
			y = y-1;
			x = x-1;
			if ( y < 1 || x < 1) {
				break;
			}
			if ( origin != mat[x][y]) {
				break;
			}	
			if ( x < lx) {
				lx = x;
				ly = y;
			}
			cnt++;
		}
		x = originX;
		y = originY;
		while ( true) {
			x = x+1;
			y = y+1;
			if ( x > 19 || y > 19) {
				break;
			}
			if ( origin != mat[x][y]) {
				break;
			}	
			cnt++;
		}
		return cnt;
	}
}
