package back12869;

import java.util.*;

import javax.xml.soap.Node;

public class Main {
	static int arr[];
	static int ans = Integer.MAX_VALUE;
	static int N;
	static int cost[][][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		
		arr = new int[N];
		for ( int i = 0 ; i < N ;i++) {
			arr[i] = in.nextInt();
		}
		
		if ( N == 3) {
			
			int x = arr[0];
			int y = arr[1];
			int z = arr[2];
			cost = new int[x+21][y+21][z+21];
			for ( int i = 0 ; i <= x+20 ; i++) {
				for ( int j = 0 ; j <= y+20 ; j++) {
					for ( int k = 0 ; k <= z+20 ; k++) {
						cost[i][j][k] = -1;
					}
				}
			}
		}
		
		if ( N == 1 || N == 2) {
			DFS(0);
		}else if ( N == 3) {
			ans = DFS2(0,arr[0]+20,arr[1]+20,arr[2]+20);
		}
		
		System.out.println(ans);
	}
	
	public static int DFS2(int len,int a,int b,int c) {
		
		if ( a <= 20 && b <= 20 && c <= 20) {
			return 0;
		}
		
		int ret = cost[a][b][c];
		if ( ret != - 1) {
			return ret;
		}
		ret = 100000000;
		
		if ( a-9 >= 0 && b-3 >= 0 && c - 1 >=0) {
		ret = Math.min(ret,1+DFS2(len+1,a-9,b-3,c-1) );
		}
		if ( a-9 >= 0 && b-1 >= 0 && c - 3 >=0) {
		ret = Math.min(ret,1+DFS2(len+1,a-9,b-1,c-3) );
		}
		if ( a-3 >= 0 && b-9 >= 0 && c - 1 >=0) {
		ret = Math.min(ret,1+DFS2(len+1,a-3,b-9,c-1) );
		}
		if ( a-1 >= 0 && b-9 >= 0 && c - 3 >=0) {
		ret = Math.min(ret,1+DFS2(len+1,a-1,b-9,c-3) );
		}
		if ( a-1 >= 0 && b-3 >= 0 && c - 9 >=0) {
		ret = Math.min(ret,1+DFS2(len+1,a-1,b-3,c-9) );
		}
		if ( a-3 >= 0 && b-1 >= 0 && c - 9 >=0) {
		ret = Math.min(ret,1+DFS2(len+1,a-3,b-1,c-9) );
		}
		
		return cost[a][b][c] = ret;
	}
	
	public static void DFS(int len) {
		
		/*for ( int i = 0 ; i < N ; i++ ) {
			System.out.print(arr[i]+" ");
		}System.out.println();*/
		
		boolean  check = true;
		for ( int i = 0 ; i <N ; i++) {
			if ( arr[i] > 0) {
				check = false;
				break;
			}
		}
		
		if ( check == true) {
			ans = Math.min(ans, len);
			return;
		}
		
		if (N == 2) {
			arr[0]-=9;
			arr[1]-=3;
			DFS(len+1);
			arr[0]+=9;
			arr[1]+=3;
			
			arr[1]-=9;
			arr[0]-=3;
			DFS(len+1);
			arr[1]+=9;
			arr[0]+=3;
			
			
		}else if ( N == 1 ) {
			arr[0]-=9;
			DFS(len+1);
		}
		
		
	
	}
	

}
