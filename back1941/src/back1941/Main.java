package back1941;

import java.util.*;

public class Main {
	static char mat[][];
	static int ans = 0;
	static ArrayList<Integer> place;
	static boolean visit[][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		mat = new char[5][5];
		place = new ArrayList<>();
		for (int i = 0 ; i < 5 ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			for (int j = 0 ; j< 5 ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		
		back(0,0,0);
		System.out.println(ans);
		
	}
	
	public static void back(int len,int sum,int n) {
		
		if ( len == 7) {
			if ( sum >= 4) {
				//System.out.println(place);
				int tmp[] = new int[7];
				for (int i = 0 ; i < 7 ; i++) {
					tmp[i] = place.get(i);
				}
				BFS(tmp);
			}
			return;
		}
		
		for ( int i = n ; i<= 24 ; i++) {
			if ( !place.contains(i)) {
				place.add(i);
				if ( mat[i/5][i%5] == 'S'){
					back(len+1,sum+1,i);
				}else {
					back(len+1,sum,i);
				}
				place.remove(len);
				
			}
			
		}
		
		
	}
	
	public static void BFS(int[] input) {
		
		visit = new boolean[5][5];

		ArrayList<Integer> list = new ArrayList<>();
		for ( int i = 0 ; i < 7 ; i++) {
			list.add(input[i]);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(list.get(0));
		visit[list.get(0)/5][list.get(0)%5] = true;
		int sum = 0;
		
		while ( !q.isEmpty() ) {
			int now = q.poll();
			int x = now/5;
			int y = now%5;
			sum++;
			
			if ( now%5 < 4 && list.contains(now+1) ) {
				if ( visit[(now+1)/5][(now+1)%5] == false) {
					q.add(now+1);
					visit[(now+1)/5][(now+1)%5] = true;
				}
			}
			if ( now%5 > 0 && list.contains(now-1) ){
				if ( visit[(now-1)/5][(now-1)%5] == false) {
					q.add(now-1);
					visit[(now-1)/5][(now-1)%5] = true;
				}
			}
			if ( list.contains(now+5)) {
				if ( visit[(now+5)/5][(now+5)%5] == false) {
					q.add(now+5);
					visit[(now+5)/5][(now+5)%5] = true;
				}
			}
			if ( list.contains(now-5)) {
				if ( visit[(now-5)/5][(now-5)%5] == false) {
					q.add(now-5);
					visit[(now-5)/5][(now-5)%5] = true;
				}
			}
		}
		
		if ( sum == 7) {
			/*System.out.println("--------------");
			for (int i = 0 ; i< 5 ; i++) {
				for (int j = 0 ; j < 5 ; j++) {
					if ( visit[i][j] == true) {
						System.out.print(1+" ");
					}else {
						System.out.print(0+" ");
					}
				}System.out.println();
			}*/
			ans++;
		}
		
	}

	
}
