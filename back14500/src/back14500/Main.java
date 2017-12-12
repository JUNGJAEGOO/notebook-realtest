package back14500;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int mat[][];
	static int N,M;
	static int res = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		mat = new int[N+2][M+2];
		for ( int i = 0 ; i <= N+1 ; i++) {
			for (int j = 0 ; j<=M+1 ; j++) {
				mat[i][j] = -100;
			}
		}
		
		for ( int i = 1 ; i <= N ; i++) {
			for (int j = 1 ; j<=M ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		//double before = System.currentTimeMillis();
		int max = BFS();
		
		int t1[][] = {{0,0},{0,1},{0,-1},{1,0}};
		int t2[][] = {{0,0},{0,1},{0,-1},{-1,0}};
		int t3[][] = {{0,0},{-1,0},{1,0},{0,1}};
		int t4[][] = {{0,0},{-1,0},{1,0},{0,-1}};
		
		for ( int i = 1 ; i<= N ; i++) {
			for ( int j = 1 ; j<= M ; j++) {
				int sum = 0;
				for ( int k = 0 ; k<=3 ; k++) {
					sum += mat[i+t1[k][0]][j+t1[k][1]];
				}
				if ( sum > res) {
					res = sum;
				}
				sum = 0;		
				for ( int k = 0 ; k<=3 ; k++) {
					sum += mat[i+t2[k][0]][j+t2[k][1]];
				}
				if ( sum > res) {
					res = sum;
				}
				sum = 0;
				for ( int k = 0 ; k<=3 ; k++) {
					sum += mat[i+t3[k][0]][j+t3[k][1]];
				}
				if ( sum > res) {
					res = sum;
				}
				sum = 0;
				for ( int k = 0 ; k<=3 ; k++) {
					sum += mat[i+t4[k][0]][j+t4[k][1]];
				}
				if ( sum > res) {
					res = sum;
				}
			}
		}
		//System.out.println(res);
		res = Math.max(res, max);
		System.out.println(res);
		//double after = System.currentTimeMillis();
		//System.out.println(after-before);
	}
	
	public static int BFS() {
		Stack<data> st = new Stack<>();
		int max = 0;
		for ( int i = 1 ; i<= N ; i++) {
			for ( int j = 1 ; j <= M ; j++) {
				st.add(new data(i,j,1,mat[i][j],-1,-1));
			}
		}
		while ( !st.isEmpty() ) {
			data tmp = st.pop();
			int x = tmp.x;
			int y = tmp.y;
			int cost = tmp.cost;
			int sum = tmp.sum;
			int bx = tmp.bx;
			int by = tmp.by;
			if ( sum > max) {
				max = sum;
			}
			//System.out.println(x+","+y);
			if ( cost < 4 ) {
				if ( mat[x+1][y] != -100) {
					if ( bx != x+1 || by != y) {
						st.add(new data(x+1,y,cost+1,sum+mat[x+1][y],x,y));
					}
				}
				if ( mat[x-1][y] != -100) {
					if ( bx != x-1 || by != y) {
						st.add(new data(x-1,y,cost+1,sum+mat[x-1][y],x,y));
					}
				}
				if ( mat[x][y+1] != -100) {
					if ( bx != x || by != y+1) {
						st.add(new data(x,y+1,cost+1,sum+mat[x][y+1],x,y));
					}
				}
				if ( mat[x][y-1] != -100) {
					if ( bx != x || by != y-1) {
						st.add(new data(x,y-1,cost+1,sum+mat[x][y-1],x,y));
					}
				}
			}
			
		}
		
		//System.out.println(max);
		return max;
	}
	
	public static class data{
		int x,y;
		int cost;
		int sum;
		int bx,by;
		data(int x,int y,int cost,int sum,int bx,int by){
			this.x = x; this.y = y;
			this.cost = cost;
			this.sum = sum;
			this.bx =bx; this.by =by;
		}
	}

}
