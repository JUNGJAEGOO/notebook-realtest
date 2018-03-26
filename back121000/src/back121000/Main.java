package back121000;

import java.util.*;

public class Main {
	static int mat[][];
	static int N;
	static int max = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		mat = new int[N][N];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		/*int map[][] = right(mat);
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}*/
		
		BFS();
		System.out.println(max);
	}
	
	public static void BFS() {
		Queue<node> q= new LinkedList<>();
		int tmp[][] = new int[N][N];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				tmp[i][j] = mat[i][j];
			}
		}
		q.add(new node(tmp,0));
		
		while (!q.isEmpty() ) {
			
			node now = q.poll();
			int map[][] = now.map;
			int cnt = now.cnt;
			if ( cnt == 5) {
				
				for ( int i = 0 ; i < N ; i++) {
					for ( int j = 0 ; j < N ; j++) {
						max = Math.max(max, map[i][j]);
					}
				}
				//System.out.println(max);
				continue;
			}
			
			tmp = new int[N][N];
			for ( int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			int resup[][] = up(tmp);
			q.add(new node(resup,cnt+1));
			
			tmp = new int[N][N];
			for ( int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			int resdown[][] = down(tmp);
			q.add(new node(resdown,cnt+1));
			
			tmp = new int[N][N];
			for ( int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			int resleft[][] = left(tmp);
			q.add(new node(resleft,cnt+1));
			
			tmp = new int[N][N];
			for ( int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			int resright[][] = right(tmp);
			q.add(new node(resright,cnt+1));
			
		}
	}
	
	public static int[][] up(int map[][]){
		
		for ( int i = 0 ; i < N ; i++) {
			
			int cnt = 0;
			int save = -1;
			ArrayList<Integer> list = new ArrayList<>();
			while ( true ) {
				//System.out.println(cnt+" "+save);
				if ( save == -1 && map[cnt][i] != 0 ) {
					save = map[cnt][i];
				}
				else if ( save != -1 && map[cnt][i] != 0) {
					if ( save == map[cnt][i]) {
						list.add(save+map[cnt][i]);
						save = -1;
					}else {
						list.add(save);
						save = -1;
						cnt--;
					}
				}
				
				cnt++;
				if ( cnt >= N) {
					if ( save != -1) {
						list.add(save);
					}
					break;
				}	
			}
			
			//System.out.println(list);
			for ( int j = 0 ; j < N ; j++) {
				map[j][i] = 0;
			}
			cnt = 0;
			for ( int j = 0 ; j < list.size() ; j++) {
				map[cnt][i] = list.get(j);
				cnt++;
			}
			
		}
		
		return map;
	}
	
	public static int[][] down(int map[][]){
		
		for ( int i = 0 ; i < N ; i++) {
			
			int cnt = N-1;
			int save = -1;
			ArrayList<Integer> list = new ArrayList<>();
			while ( true ) {
				if ( save == -1 && map[cnt][i] != 0 ) {
					save = map[cnt][i];
				}
				else if ( save != -1 && map[cnt][i] != 0) {
					if ( save == map[cnt][i]) {
						list.add(save+map[cnt][i]);
						save = -1;
					}else {
						list.add(save);
						save = -1;
						cnt++;
					}
				}
				
				cnt--;
				if ( cnt < 0) {
					if ( save != -1) {
						list.add(save);
					}
					break;
				}	
			}

			for ( int j = 0 ; j < N ; j++) {
				map[j][i] = 0;
			}
			cnt = N-1;
			for ( int j = 0 ; j < list.size() ; j++) {
				map[cnt][i] = list.get(j);
				cnt--;
			}
			
		}
		
		return map;
	}
	
	public static int[][] left(int map[][]){
		
		for ( int i = 0 ; i < N ; i++) {
			
			int cnt = 0;
			int save = -1;
			ArrayList<Integer> list = new ArrayList<>();
			while ( true ) {
				if ( save == -1 && map[i][cnt] != 0 ) {
					save = map[i][cnt];
				}
				else if ( save != -1 && map[i][cnt] != 0) {
					if ( save == map[i][cnt]) {
						list.add(save+map[i][cnt]);
						save = -1;
					}else {
						list.add(save);
						save = -1;
						cnt--;
					}
				}
				
				cnt++;
				if ( cnt >= N) {
					if ( save != -1) {
						list.add(save);
					}
					break;
				}	
			}

			for ( int j = 0 ; j < N ; j++) {
				map[i][j] = 0;
			}
			cnt = 0;
			for ( int j = 0 ; j < list.size() ; j++) {
				map[i][cnt] = list.get(j);
				cnt++;
			}
			
		}
		
		return map;
	}
	
	public static int[][] right(int map[][]){
		
		for ( int i = 0 ; i < N ; i++) {
			
			int cnt = N-1;
			int save = -1;
			ArrayList<Integer> list = new ArrayList<>();
			while ( true ) {
				if ( save == -1 && map[i][cnt] != 0 ) {
					save = map[i][cnt];
				}
				else if ( save != -1 && map[i][cnt] != 0) {
					if ( save == map[i][cnt]) {
						list.add(save+map[i][cnt]);
						save = -1;
					}else {
						list.add(save);
						save = -1;
						cnt++;
					}
				}
				
				cnt--;
				if ( cnt < 0) {
					if ( save != -1) {
						list.add(save);
					}
					break;
				}	
			}

			for ( int j = 0 ; j < N ; j++) {
				map[i][j] = 0;
			}
			cnt = N-1;
			for ( int j = 0 ; j < list.size() ; j++) {
				map[i][cnt] = list.get(j);
				cnt--;
			}
			
		}
		
		return map;
	}
	
	public static class node{
		int map[][];
		int cnt;
		
		node (int map[][],int cnt){
			this.map = map;
			this.cnt = cnt;
		}
	}
}
