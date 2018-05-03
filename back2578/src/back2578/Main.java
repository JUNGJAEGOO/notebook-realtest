package back2578;

import java.util.*;

public class Main {
	static boolean visit[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int mat[][] = new int[5][5];
		visit = new boolean[5][5];
		HashMap<Integer,node> hm = new HashMap<>();
		
		for ( int i = 0 ; i < 5 ; i++) {
			for (int j = 0 ; j < 5 ; j++) {
				mat[i][j] = in.nextInt();
				hm.put(mat[i][j],new node(i,j));
			}
		}
		
		int cnt = 1;
		for ( int i = 0 ; i < 5 ; i++) {
			for ( int j = 0 ; i < 5 ; j++) {
				int com = in.nextInt();
				int x = hm.get(com).x;
				int y = hm.get(com).y;
				visit[x][y] = true;
				int sum = 0;
				sum += GAROsearch();
				sum += SEROsearch();
				sum += DAEGAKsearch();
				
				if ( sum >= 3) {
					System.out.println(cnt);
					return;
				}else {
					cnt++;
				}
			}
		}
	}
	
	public static int GAROsearch() {
		
		int ans = 0;
		
		for ( int i = 0 ; i < 5 ; i++) {
			
			int sum = 0;
			
			for ( int j = 0 ; j < 5 ; j++) {
				if ( visit[i][j] == true) {
					sum++;
				}
			}
			
			if ( sum == 5) {
				ans++;
			}
			
		}
		
		return ans;
		
	}
	
	public static int SEROsearch() {
		
		int ans = 0;
		
		for ( int i = 0 ; i < 5 ; i++) {
			
			int sum = 0;
			
			for ( int j = 0 ; j < 5 ; j++) {
				if ( visit[j][i] == true) {
					sum++;
				}
			}
			
			if ( sum == 5) {
				ans++;
			}
			
		}
		
		return ans;
	}
	
	public static int DAEGAKsearch() {
		
		int ans = 0;
		
		if ( visit[0][0] && visit[1][1] && visit[2][2] && visit[3][3] && visit[4][4]) {
			ans++;
		}
		
		if ( visit[0][4] && visit[1][3] && visit[2][2] && visit[3][1] && visit[4][0]) {
			ans++;
		}
		
		return ans;
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x = x;
			this.y= y;
		}
	}
}
