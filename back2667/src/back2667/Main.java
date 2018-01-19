package back2667;

import java.io.*;
import java.util.*;

public class Main {
	static int mat[][];
	static boolean visit[][];
	static ArrayList<Integer> list = new ArrayList<>();
	static int X[] = {-1,0,1,0};
	static int Y[] = {0,1,0,-1};
	static int N;
	
	public static void main(String args[]) throws Exception {
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//System.out.println(N);
		mat = new int[N+2][N+2];
		visit = new boolean[N+2][N+2];
		for ( int i = 1 ; i<= N ; i++) {
			char[] tmp = br.readLine().toCharArray();
			for ( int j = 1 ; j<= N ; j++) {
				mat[i][j] = Integer.parseInt(String.valueOf(tmp[j-1]));
			}
		}

		for ( int i = 1 ; i<= N ; i++) {
			for ( int j = 1 ; j<= N ; j++) {
				if ( visit[i][j] == false && mat[i][j] == 1 ) {
					list.add(BFS(i,j));
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for ( int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	public static int BFS(int startX,int startY) {
		Queue<node> q = new LinkedList<>();
		int ans = 0;
		q.add(new node(startX,startY));
		visit[startX][startY] = true;
		
		while ( !q.isEmpty() ) {
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			ans++;
			
			for (int i = 0 ; i < 4; i++) {
				if ( visit[x+X[i]][y+Y[i]] == false) {
					if ( x+X[i] >= 1 && x+X[i] <= N) {
						if ( y+Y[i] >= 1 && y+Y[i] <= N) {
							if ( mat[x+X[i]][y+Y[i]] == 1) {
								visit[x+X[i]][y+Y[i]] = true;
								q.add(new node(x+X[i],y+Y[i]));
							}
						}
					}
					
				}
			}
			
		}
		
		return ans;
	}
	
	public static class node{
		int x,y;
		node(int x,int y){
			this.x =x;
			this.y =y;
		}
	}
}
