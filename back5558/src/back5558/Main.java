package back5558;

import java.io.*;
import java.util.*;

public class Main {
	static int R,C,H;
	static char mat[][];
	static int cost[][][];
	static int inf = 1000000000;
	static int sX,sY;
	static int eX,eY;
	static int X[] = {0,1,0,-1};
	static int Y[] = {1,0,-1,0};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		mat = new char[R][C];
		cost = new int[H+1][R][C];
		for (int i = 0 ; i < R; i++) {
			char[]tmp = br.readLine().toCharArray();
			for (int j = 0 ; j < C ; j++) {
				mat[i][j] = tmp[j];
				if ( mat[i][j] == 'S') {
					sX = i;
					sY = j;
				}
				if ( mat[i][j] == String.valueOf(H).charAt(0)) {
					eX = i;
					eY = j;
				}
			}
		}
		
		for (int i = 0 ; i <= H ; i++) {
			for (int j = 0 ; j < R ; j++) {
				for (int k = 0 ; k < C ; k++) {
					cost[i][j][k] = inf;
				}
			}
		}
		
		BFS();
		
		/*for (int i = 0 ; i <= H ; i++) {
			for (int j = 0 ; j < R ; j++) {
				for (int k = 0 ; k < C ; k++) {
					if ( cost[i][j][k] == inf) {
						System.out.print("XX"+"  ");
					}else {
						System.out.print(cost[i][j][k]+"  ");
					}
				}System.out.println();
			}System.out.println("============");
		}System.out.println();*/
		System.out.println(cost[H][eX][eY]);
		
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		q.add(new node(sX,sY,0,0));
		cost[0][sX][sY] = 0;
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			int c = now.cost;
			int high = now.high;
			
			for (int i = 0 ; i < 4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				if ( nx >= 0 && nx < R && ny >=0 && ny < C) {
					if ( mat[nx][ny] != 'X') {
							if ( high+1 < 10 && mat[nx][ny] == String.valueOf(high+1).charAt(0) ) {
								if ( cost[high+1][nx][ny] > c + 1) {
									cost[high+1][nx][ny] = c + 1;
									q.add(new node(nx,ny,c+1,high+1));
								}
							}
							else {
								if ( cost[high][nx][ny] > c + 1) {	
									cost[high][nx][ny] = c + 1;
									q.add(new node(nx,ny,c+1,high));
								}
							}
					}
				}
			}
		}
			
	}
	
	
	public static class node{
		int x,y;
		int cost;
		int high;
		node (int x,int y, int cost,int high){
			this.x =x;
			this.y = y;
			this.cost = cost;
			this.high = high;
		}
	}
}
