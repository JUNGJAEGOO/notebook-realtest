package back11724;
import java.util.*;
public class Main {
	static int mat[][];
	static boolean visit[];
	static int N;
	static int M;
	public static void main(String args[]) {
		
		Scanner in =new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		mat = new int[N+1][N+1];
		visit = new boolean[N+1];
		for ( int i = 0;i< M;i++) {

				int x = in.nextInt();
				int y = in.nextInt();
				mat[x][y] = 1;
				mat[y][x] = 1;
			
		}
		
		for ( int i = 1 ; i <= N ; i++) {
			visit[i] = false;
			/*for ( int j = 1 ; j <= N ; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();*/
		}
		

		int count = 0;
		for(int i = 1 ; i <= N ; i++) {
			if (BFS(i)) { count++; }
		}
		System.out.println(count);
		
	}
	
	public  static boolean BFS(int start) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		if( visit[start]==true) { return false; }
		q.add(start);
		visit[start] = true;
		while ( !q.isEmpty() ) {
			
			int tmp = q.remove();
			/*System.out.print(tmp+" ");*/
			
			for (int i = 1 ; i <= N ; i ++){
				if ( mat[tmp][i] == 1 && visit[i] == false) {
					visit[i] = true;
					q.add(i);
				}
			}
			
		}
		//System.out.println();
		return true;
		
		
		
	}
	
/*	public static class data{
		int x,y;
		data(int x,int y){
			this.x = x;
			this.y = y;
		}
	}*/
	
}
