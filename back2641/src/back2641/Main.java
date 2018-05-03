package back2641;

import java.util.*;

public class Main {
	static int X[] = {0,-1,0,1};
	static int Y[] = {1,0,-1,0};
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int[][] origin = new int[201][201];
		int sX = 100;
		int sY = 100;
		int sum = 0;
		origin[sX][sY] = 1;
		ArrayList<node> list = new ArrayList<>();
		list.add(new node(sX,sY));
		for ( int i = 0 ; i < N ; i++) {
			int go = in.nextInt()-1;
			sX = sX + X[go];
			sY = sY + Y[go];
			origin[sX][sY] = 1;
			list.add(new node(sX,sY));
			sum++;
		}
		
		/*for ( int i = 96 ; i < 106 ; i++) {
			for ( int j = 95; j < 110 ; j++) {
				System.out.print(origin[i][j]);
			}System.out.println();
		}System.out.println();
		*/
		int M = in.nextInt();
		ArrayList<ArrayList<Integer>> OK = new ArrayList<>();
		
		for ( int i = 0 ; i < M ; i++) {
			
			ArrayList<Integer> command = new ArrayList<>();
			for (int j = 0 ; j < N ; j++) {
				command.add(in.nextInt()-1);
			}
			
			
			lop:
			for ( int j = 0 ; j < list.size() ; j++) {
				
				int mat[][] = new int[201][201];
				int sx = list.get(j).x;
				int sy = list.get(j).y;
				//System.out.println(sx+" "+sy);
				mat[sx][sy] = 1;
				for (int k = 0 ; k < command.size() ; k++) {
					
					int GO = command.get(k);
					sx = sx + X[GO];
					sy = sy + Y[GO];
					mat[sx][sy] = 1;
					
				}
				
				/*for ( int ii = 96 ; ii < 106 ; ii++) {
					for ( int jj = 95; jj < 110 ; jj++) {
						System.out.print(mat[ii][jj]);
					}System.out.println();
				}System.out.println();
				*/
				int tmpsum = 0;
				for ( int k = 0 ;  k < 201 ; k++) {
					for ( int s = 0 ; s < 201 ; s++) {
						if ( mat[k][s] == 1 && origin[k][s] == mat[k][s]) {
							tmpsum++;
						}
					}
				}
				//System.out.println(tmpsum+" "+sum);
				if ( tmpsum == sum) {
					OK.add(command);
					break lop;
				}
				
			}
			
			
		}
		
		System.out.println(OK.size());
		for ( int i = 0 ; i < OK.size() ; i++) {
			for ( int j = 0 ; j < OK.get(i).size() ; j++) {
				System.out.print(OK.get(i).get(j)+1+" ");
			}System.out.println();
		}
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x =x;
			this.y =y;
		}
	}
}
