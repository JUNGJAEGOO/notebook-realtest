package back15566;

import java.util.*;

public class Main {
	static int music[];
	static int hobby[];
	static int family[];
	static int philo[];
	static int can[][];
	static ArrayList<node> adj[];
	static int use[];
	static int N;
	static boolean batch[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int M = in.nextInt();
		music = new int[N+1];
		hobby = new int[N+1];
		family = new int[N+1];
		philo = new int[N+1];
		for ( int i = 1 ; i <= N ; i++) {
			music[i] = in.nextInt();
			hobby[i] = in.nextInt();
			family[i] = in.nextInt();
			philo[i] = in.nextInt();
		}
		
		can = new int[N+1][2];
		for ( int i = 1 ; i <= N ; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			can[i][0] = a;
			can[i][1] = b;
		}
		
		adj = new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int topic = in.nextInt();
			adj[from].add(new node(to,topic));
			adj[to].add(new node(from,topic));
		}
		
		batch = new boolean[N+1];
		use = new int[N+1];
		
		func(1,0);
		
		System.out.println("NO");
	}
	
	static void func(int i,int visit) {
		
		if( visit == N) {
			
			boolean pass = true;
			lop:
			for ( int s = 1 ; s <= N ;s++) {
				
				for ( int j = 0 ; j < adj[s].size() ; j++) {
					int topic = adj[s].get(j).topic;
					int from = s;
					int to = adj[s].get(j).idx;
					int nowfromidx = use[from];
					int nowtoidx = use[to];
					
					if ( topic == 1) {
						if ( music[nowfromidx] != music[nowtoidx]) {
							pass = false;
							break lop;
						}
					}else if ( topic == 2) {
						if ( hobby[nowfromidx] != hobby[nowtoidx]) {
							pass = false;
							break lop;
						}
					}else if ( topic == 3) {
						if ( family[nowfromidx] != family[nowtoidx]) {
							pass = false;
							break lop;
						}
					}else {
						if ( philo[nowfromidx] != philo[nowtoidx]) {
							pass = false;
							break lop;
						}
					}
				}
				
				
			}
			
			if ( pass ) {
				System.out.println("YES");
				for ( int s = 1 ; s <= N ; s++) {
					System.out.print(use[s]+" ");
				}System.out.println();
				System.exit(0);
				
			}
			return;
			
		}
		
		int a = can[i][0];
		int b = can[i][1];
		
		if ( batch[a] == false  ) {
			batch[a] = true;
			use[a] = i;
			func(i+1,visit+1);
			batch[a] = false;
		}
		
		if ( a != b ) {
			if ( batch[b] == false  ) {
				batch[b] = true;
				use[b] = i;
				func(i+1,visit+1);
				batch[b] = false;
			}
		}
		
		
		
	}
	
	static class node{
		int idx;
		int topic;
		node ( int idx, int topic){
			this.idx = idx;
			this.topic = topic;
		}
	}
}
