package back14389;

import java.util.*;

public class Main {
	
	static int N,M;
	static char arr[][];
	static int max = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(" ");
		N = Integer.parseInt(info[0]);
		M = Integer.parseInt(info[1]);
		
		arr = new char[N][M];
		for ( int i = 0 ; i < N ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			for ( int j = 0 ; j < M ; j++) {
				arr[i][j] = tmp[j];
			}
		}
		
		BFS();
		System.out.println(max);
	}
	
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		char ori[][] = new char[N][M];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < M ; j++) {
				ori[i][j] = arr[i][j];
			}
		}
		q.add(new node(ori));
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			char[][] map = now.mat;
			
			boolean pass = false;
			
			lop:
			for ( int i = 0 ; i < N-1 ; i++) {
				for ( int j = 0 ; j < M-1 ; j++) {
					if ( map[i][j] == '.' &&map[i+1][j] == '.' &&map[i+1][j+1] == '.' &&map[i][j+1] == '.' ) {
						pass = true;
						break lop;
					}
				}
			}
			
			if ( pass == false) {
				int sum  = 0;
				int cnt = 0;
				for ( int i = 0 ; i < N ; i++) {
					for ( int j = 0 ; j < M ; j++) {
						if ( map[i][j] == '4') {
							cnt++;
						}
					}
				}
				sum += cnt*4;
				sum += N*M - cnt;
				max = Math.max(max, sum);
				continue;
			}
			
			for ( int i = 0 ; i < N-1 ; i++) {
				for ( int j = 0 ; j < M-1 ; j++) {
					if ( map[i][j] == '.' &&map[i+1][j] == '.' &&map[i+1][j+1] == '.' &&map[i][j+1] == '.' ) {
						
						char ARR[][] = new char[N][M];
						for ( int s = 0 ;  s < N ; s++) {
							for ( int k = 0 ; k < M ; k++) {
								ARR[s][k] = map[s][k];
							}
						}
						
						ARR[i][j] = '4';
						ARR[i+1][j] = '4';
						ARR[i+1][j+1] = '4';
						ARR[i][j+1] = '4';
						
						q.add(new node(ARR));
					}
				}
			}
			
		}
	}
	
	public static class node{
		char mat[][];
		node (char mat[][]){
			this.mat = mat;
		}
	}
}
