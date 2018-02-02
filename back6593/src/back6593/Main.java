package back6593;
import java.io.*;
import java.util.*;
public class Main {
	static int L,R,C;
	static char mat[][][];
	static int cost[][][];
	static int X[] = {-1,0,1,0};
	static int Y[] = {0,-1,0,1};
	static int inf = 1000000000;
	public static void main(String args[])throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while ( true ) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if ( L == 0 && R == 0 && C == 0) {
				break;
			}
			int startL = -1;
			int startR = -1;
			int startC = -1;
			int endL = - 1,endR = -1,endC = -1;
			//System.out.println(L+" "+R+" "+C);
			mat = new char[L][R][C];
			cost = new int[L][R][C];
			for (int i = 0 ; i < L ; i++) {
				for (int j = 0 ; j < R ; j++) {
					char[] tmp = br.readLine().toCharArray();
					for(int k = 0 ; k < C ; k++) {
						//System.out.println(i+" "+j+" "+k+" "+tmp.length);
						mat[i][j][k] = tmp[k];
						if ( mat[i][j][k] == 'S') {
							startL = i; startR = j; startC = k;
						}else if ( mat[i][j][k] == 'E') {
							endL = i; endR = j; endC = k;
						}
					}
				}
				br.readLine();
			}
			
			for (int i = 0 ; i < L ; i++) {
				for (int j = 0 ; j < R ; j++) {
					for (int k = 0 ; k < C ; k++) {
						cost[i][j][k] = inf;
					}
				}
			}
			
			
			/*for (int i = 0 ; i < L ; i++) {
				for (int j = 0 ; j < R ; j++) {
					for (int k = 0 ; k < C ; k++) {
						
							System.out.print(mat[i][j][k]+" ");
						
					}System.out.println();
				}System.out.println();
			}*/
			
			BFS(startL,startR,startC,endL,endR,endC);
			
			/*for (int i = 0 ; i < L ; i++) {
				for (int j = 0 ; j < R ; j++) {
					for (int k = 0 ; k < C ; k++) {
						if ( cost[i][j][k] == inf) {
							System.out.print("x ");
						}else {
							System.out.print(cost[i][j][k]+" ");
						}
					}System.out.println();
				}System.out.println();
			}*/
			
			if( cost[endL][endR][endC] != inf) {
				System.out.println("Escaped in "+cost[endL][endR][endC]+" minute(s).");
			}else {
				System.out.println("Trapped!");
			}
		}
	}
	
	public static void BFS(int startL,int startR,int startC,int endL,int endR,int endC) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(startL,startR,startC,0));
		cost[startL][startR][startC] = 0;
		while ( !q.isEmpty() ) {
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			int floor = now.floor;
			int c = now.cost;
			
			for (int i = 0 ; i < 4 ; i++) {
					if ( x+X[i] >= 0 && x+X[i]< R && y+Y[i] < C && y+Y[i] >=0) {
						if ( mat[floor][x+X[i]][y+Y[i]] != '#') {
							if ( cost[floor][x+X[i]][y+Y[i]] > c + 1) {
								 cost[floor][x+X[i]][y+Y[i]] = c + 1;
								 q.add(new node(floor,x+X[i],y+Y[i],c+1));
							}
						}
					}
			}
			
			
			
			if ( floor+1 < L) {
				if ( mat[floor+1][x][y] != '#') {
					if ( cost[floor+1][x][y] > c+1) {
						cost[floor+1][x][y] = c+1;
						q.add(new node(floor+1,x,y,c+1));
					}
				}
			}
			if ( floor-1 >= 0) {
				if ( mat[floor-1][x][y] != '#' ) {
					if ( cost[floor-1][x][y] > c+1) {
						cost[floor-1][x][y] = c+1;
						q.add(new node(floor-1,x,y,c+1));
					}
				}
			}
			
			
		}
		
	}

	public static class node{
		int floor;
		int x,y;
		int cost;
		node (int floor,int x,int y ,int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.floor = floor;
		}
	}
}
