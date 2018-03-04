package back2477;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int K = in.nextInt();
		ArrayList<node> list = new ArrayList<>();
		
		int arr1[] = {2,3,1,3,1,4}; // ㄱ
		int arr2[] = {2,3,1,4,1,4}; // ㄱ 반대
		int arr3[] = {2,4,2,3,1,4}; // L
		int arr4[] = {2,3,2,3,1,4}; // L 반대
		int direct[] = new int[6];
		
		for (int i = 0 ; i < 6 ; i++) {
			int dir = in.nextInt();
			direct[i] = dir;
			int size = in.nextInt();
			list.add(new node(dir,size));
		}
		
		int ans = 0;
		
		int tmpdir[] = direct.clone();
		
		for ( int i = 0 ; i < 6 ; i++) {
			tmpdir = shift(tmpdir);
	
			boolean pass1 = true;
			boolean pass2 = true;
			boolean pass3 = true;
			boolean pass4 = true;
			
			for (int j = 0 ; j < 6 ; j++) {
				
				if ( tmpdir[j] != arr1[j]) {
					pass1 = false;
					break;
				}
			}
			if ( pass1 ) {
				ans = 1;
				break;
			}
			
			for (int j = 0 ; j < 6 ; j++) {
				
				if ( tmpdir[j] != arr2[j]) {
					pass2 = false;
					break;
				}
			}
			if ( pass2 ) {
				ans = 2;
				break;
			}
			
			for (int j = 0 ; j < 6 ; j++) {
				
				if ( tmpdir[j] != arr3[j]) {
					pass3 = false;
					break;
				}
			}
			if ( pass3 ) {
				ans = 3;
				break;
			}
			
			for (int j = 0 ; j < 6 ; j++) {
				
				if ( tmpdir[j] != arr4[j]) {
					pass4 = false;
					break;
				}
			}
			if ( pass4 ) {
				ans = 4;
				break;
			}
			
		}
		
		long res = 0;
		if ( ans == 1) {
			int longH = 0;
			int shortH = 0;
			int longW = 0;
			int shortW = 0;
			
			for (int i = 0 ; i < 6 ; i++) {
				int d = list.get(i).dir;
				int size = list.get(i).size;
				
				if ( d == 4) {
					longH = size;
				}
				if ( d == 2) {
					longW = size;
				}
				
				if ( d == 3) {
					if ( list.get((i+1)%6).dir == 1 && list.get((i+2)%6).dir == 4) {
						shortH = size;
					}
				}
				
				if ( d == 1) {
					if ( list.get((i+1)%6).dir == 3 && list.get((i+2)%6).dir == 1) {
						shortW = size;
					}
				}
				
			}
			
			res = longH * longW - shortW * shortH;
		}else if ( ans == 2) {
			int longH = 0;
			int shortH = 0;
			int longW = 0;
			int shortW = 0;
			
			for (int i = 0 ; i < 6 ; i++) {
				int d = list.get(i).dir;
				int size = list.get(i).size;
				
				if ( d == 3) {
					longH = size;
				}
				if ( d == 2) {
					longW = size;
				}
				
				if ( d == 4) {
					if ( list.get((i+1)%6).dir == 1 && list.get((i+2)%6).dir == 4) {
						shortH = size;
					}
				}
				
				if ( d == 1) {
					if ( list.get((i+1)%6).dir == 4 && list.get((i+2)%6).dir == 2) {
						shortW = size;
					}
				}
				
			}
			
			res = longH * longW - shortW * shortH;
		}else if ( ans == 3) {
			int longH = 0;
			int shortH = 0;
			int longW = 0;
			int shortW = 0;
			
			for (int i = 0 ; i < 6 ; i++) {
				int d = list.get(i).dir;
				int size = list.get(i).size;
				
				if ( d == 1) {
					longH = size;
				}
				if ( d == 3) {
					longW = size;
				}
				
				if ( d == 2) {
					if ( list.get((i+1)%6).dir == 4 && list.get((i+2)%6).dir == 2) {
						shortW = size;
					}
				}
				
				if ( d == 4) {
					if ( list.get((i+1)%6).dir == 2 && list.get((i+2)%6).dir == 3) {
						shortH = size;
					}
				}
				
			}
			
			res = longH * longW - shortW * shortH;
		}else {
			int longH = 0;
			int shortH = 0;
			int longW = 0;
			int shortW = 0;
			
			for (int i = 0 ; i < 6 ; i++) {
				int d = list.get(i).dir;
				int size = list.get(i).size;
				
				if ( d == 4) {
					longH = size;
				}
				if ( d == 1) {
					longW = size;
				}
				
				if ( d == 3) {
					if ( list.get((i+1)%6).dir == 2 && list.get((i+2)%6).dir == 3) {
						shortH = size;
					}
				}
				
				if ( d == 2) {
					if ( list.get((i+1)%6).dir == 3 && list.get((i+2)%6).dir == 1) {
						shortW = size;
					}
				}
				
			}
			
			res = longH * longW - shortW * shortH;
		}
		
		System.out.println(res*K);
		
	}
	
	public static int[] shift(int[] arr) {
		int tmp[] = new int[6];
		
		int tmpnum = arr[5];
		for (int i = 5 ; i >= 1 ; i--) {
			tmp[i] = arr[i-1];
		}
		tmp[0] = tmpnum;
		
		return tmp;
	}
	
	public static class node{
		int dir;
		int size;
		node (int dir,int size){
			this.dir = dir;
			this.size = size;
		}
	}
}
