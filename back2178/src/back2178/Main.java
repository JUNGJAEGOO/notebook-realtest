package back2178;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static boolean visit[][];
	static int mat[][];
	static int cost[][];
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		mat = new int[N+2][M+2];
		cost = new int[N+2][M+2];
		visit = new boolean[N+2][M+2];
		
		cost[1][1] = 1;
		

		for ( int i = 1; i <= N ; i++) {
			String tmp = br.readLine();
			char[] a = tmp.toCharArray();
			for ( int  j = 1 ; j <= M  ; j++) {
				mat[i][j] = Integer.parseInt(String.valueOf(a[j-1]));
			}
		}
		
		
		BFS();
		
/*		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <=M ; j++) {
				System.out.print(cost[i][j]+" ");
			}
			System.out.println();
		}*/
		
/*		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= M ; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}*/

// 1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
		
		System.out.println(cost[N][M]);
	}
	
	
	public static void BFS() {
		Queue<data> q = new LinkedList<data>();
		q.add(new data(1,1,1));
		visit[1][1] = true;
		while ( !q.isEmpty() ) {
			data tmp = q.remove();
			cost[tmp.x][tmp.y] = tmp.cost;
			if( mat[tmp.x+1][tmp.y] == 1 && visit[tmp.x+1][tmp.y] != true) {
				
					
					visit[tmp.x+1][tmp.y] = true;
					q.add(new data(tmp.x+1,tmp.y,tmp.cost+1));
				
			}
			if( mat[tmp.x-1][tmp.y] == 1 && visit[tmp.x-1][tmp.y] != true) {

					visit[tmp.x-1][tmp.y] = true;
					q.add(new data(tmp.x-1,tmp.y,tmp.cost+1));
				
			}
			if( mat[tmp.x][tmp.y+1] == 1 && visit[tmp.x][tmp.y+1] != true) {

					visit[tmp.x][tmp.y+1] = true;
					q.add(new data(tmp.x,tmp.y+1,tmp.cost+1));
				
			}
			if( mat[tmp.x][tmp.y-1] == 1 && visit[tmp.x][tmp.y-1] != true) {

					visit[tmp.x][tmp.y-1] = true;
					q.add(new data(tmp.x,tmp.y-1,tmp.cost+1));
				
			}
			
		}
	}
	
	public static class data{
		int x, y;
		int cost;
		data(int x,int y,int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
