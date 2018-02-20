package back11578;

import java.util.*;

public class Main {
	static ArrayList<Integer> list[];
	static boolean visit[];
	static boolean people[];
	static int N,M;
	static int inf  = 1000000000;
	static int min = inf;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		list = new ArrayList[M];
		for (int i = 0 ; i < M ; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0 ; i < M ; i++) {
			int num = in.nextInt();
			for (int j = 0 ; j < num ; j++) {
				list[i].add(in.nextInt());
			}
		}
		
		visit = new boolean[N+1];
		people = new boolean[M];
		
		func(0);
		if ( min == inf ) {
			System.out.println(-1);
		}else{
			System.out.println(min);
		}
	}
	
	public static void func(int len) {
		
		int sum = 0;
		for (int i = 1 ; i<= N ; i++) {
			if ( visit[i] ) {
				sum++;
			}
		}
		//System.out.println(sum+" "+len);
		
		if ( sum == N) {
			if ( len < min ) {
				min = len;
			}
			return;
		}
		
		for ( int i = 0 ; i < M ; i++) {
			if ( people[i] == false) {
				people[i] = true;
				for (int j = 0 ; j < list[i].size() ; j++) {
					visit[list[i].get(j)] = true;
				}
				func(len+1);
				for (int j = 0 ; j < list[i].size() ; j++) {
					visit[list[i].get(j)] = false;
				}
				people[i] = false;
			}
		}
		
	}
}
