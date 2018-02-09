package back14939;

import java.util.*;

public class Main {
	static char[][] mat;
	static char[][] tmpchar;
	static int ans = 1000000000;
	static int gg = 0;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		mat = new char[10][10];
		for (int i = 0 ; i < 10 ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			for (int j = 0 ; j < 10 ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		
		
		
		ArrayList<Integer> list = new ArrayList<>();
		DFS(-1,list);
		
		System.out.println(gg);
		System.out.println(ans);
		
	}
	
	public static void DFS(int len,ArrayList<Integer> list) {
		
		if ( len == 9) {
			gg++;
			tmpchar = new char[10][10]; 
			for (int i = 0 ; i < 10 ; i++) {
				for (int j = 0 ; j < 10 ; j++) {
					tmpchar[i][j] = mat[i][j];
				}
			}
			
			int res = 0;
			
			for (int i = 0 ; i < list.size() ; i++) {
				
				int now = list.get(i);
				
				swap(0,now);
				swap(0+1,now);
				swap(0,now-1);
				swap(0,now+1);
				res++;
					
			}
			
			for (int i = 0 ; i < 10 ; i++) {
				for (int j = 0 ; j < 10 ; j++) {
					System.out.print(tmpchar[i][j]);
				}System.out.println();
			}
			System.out.println(list);
			res = light(tmpchar);
			
			
			
			if ( res != -1) {
				
				System.out.println(res);
				
				ans = Math.min(ans, res);
			}
			//System.out.println();
			return;
		}
		list.add(len+1);
		DFS(len+1,list);
		list.remove(list.size()-1);
		DFS(len+1,list);
		
	}
	
	public static int light(char map[][]) {
		int cnt =0;
		for (int i = 0 ; i < 9 ; i++) {
			for (int j = 0 ; j < 10 ; j++) {
				if ( map[i][j] == 'O' ) {
					map[i][j] = '#';
					swap(i+1,j);
					swap(i+1,j-1);
					swap(i+1,j+1);
					swap(i+2,j);
					cnt++;
				}
			}
		}
		
		for (int i = 0 ; i < 10 ; i++) {
			if ( map[9][i] == 'O') {
				//System.out.println(-1);
				return -1;
			}
		}
		
		return cnt;
	}
	
	public static void swap(int x,int y) {
		if ( x < 0 || x > 9 || y < 0 || y > 9 ) {
			return;
		}
		if (tmpchar[x][y] == 'O') {
			tmpchar[x][y] = '#';
		}else {
			tmpchar[x][y] = 'O';
		}
	}
}
