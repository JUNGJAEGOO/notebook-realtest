package back11725;

import java.util.*;

public class Main {
	static int N;
	static ArrayList<node> tree[];
	static ArrayList<Integer> adj[];
	static boolean visit[];
	static int parent[];
	
	public static void main(String args[]) {
		Scanner in= new Scanner(System.in);
		N = in.nextInt();
		visit = new boolean[N+1];
		tree= new ArrayList[N+1];
		adj = new ArrayList[N+1];
		parent = new int[N+1];
		for ( int i = 1 ; i<= N ; i++) {
			tree[i] = new ArrayList<node>();
			adj[i] = new ArrayList<Integer>();
		}
		for ( int i = 0 ; i < N-1 ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			adj[from].add(to);
			adj[to].add(from);
		}
		
		make();
		
		for (int i = 2 ; i<= N ; i++) {
			System.out.println(parent[i]);
		}
		
	}
	
	public static void make() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while ( !q.isEmpty() ) {
			int now = q.poll();
			
			for ( int i = 0 ; i < adj[now].size() ; i++ ) {
				int next = adj[now].get(i);
				if (visit[next] == false) {
					tree[now].add(new node(now,next));
					parent[next] = now;
					visit[now] = true;
					q.add(next);
				}
			}
		}
	}
	
	public static class node{
		int parent;
		int iam;
		node (int parent, int iam){
			this.iam = iam;
			this.parent = parent;
		}
	}
}
