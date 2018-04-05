package back10469;

import java.util.*;

public class Main {
	static char mat[][];
	static int cnt[][];
	static int X[] = {1,1,1,0,0,-1,-1,-1};
	static int Y[] = {1,0,-1,1,-1,-1,0,1};
	
	static ArrayList<node> list = new ArrayList<>();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		mat = new char[8][8];
		for ( int i = 0 ; i < 8 ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			for ( int j = 0 ; j < 8 ; j++) {
				mat[i][j] = tmp[j];
				if ( mat[i][j] == '*') {
					list.add(new node(i,j));
				}
			}
		}
		
		if ( list.size() != 8) {  // 여왕이 8개 아니면 틀린거임 ㅡ.ㅡ 함정.
			System.out.println("invalid");
			return;
		}
		for ( int i = 0 ; i < list.size() ; i++) {
			int X = list.get(i).x;
			int Y = list.get(i).y;
			if ( make(X,Y) == false) {
				System.out.println("invalid");
				return;
			}
		}
		
		System.out.println("valid");
		
		
	}
	
	public static boolean make(int x,int y) {

		for ( int i = 0 ; i < 8 ; i++) {
			
			int nowX = x;
			int nowY = y;
			while ( true ) {
				
				nowX += X[i];
				nowY += Y[i];
				
				if ( nowX > 7 || nowX < 0 || nowY > 7 || nowY < 0) {
					break;
				}
				
				if ( mat[nowX][nowY] == '*' ) {
					return false;
				}
				
			}
			
		}
		
		return true;
		
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
