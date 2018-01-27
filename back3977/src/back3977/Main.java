package back3977;

import java.util.*;

public class Main {
	static int N,M;
	static Stack<Integer> st;
	static ArrayList<Integer> adj[];
	static ArrayList<Integer> revadj[];
	static boolean visit[];
	static ArrayList<Integer> res[];
	static int degree[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0 ) {
			
			N = in.nextInt();
			M = in.nextInt();
			adj = new ArrayList[N];
			revadj = new ArrayList[N];
			res = new ArrayList[N];
			st = new Stack<>();
			for(int i = 0 ; i < N ; i++) {
				adj[i] = new ArrayList<>();
				revadj[i] = new ArrayList<>();
				res[i] = new ArrayList<>();
			}
			
			for ( int i = 0 ; i < M ; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				adj[from].add(to);
				revadj[to].add(from);
			}
			
			visit = new boolean[N];
			for ( int i = 0 ; i < N ; i++) {
				if ( visit[i] == false) {
					visit[i] = true;
					DFS(i);
				}
			}
			
			degree = new int[N];
			//System.out.println(st);
			Arrays.fill(visit, false);
			
			while ( !st.isEmpty() ) {
				int next = st.pop();
				revDFS(next,next);
				
			}
			
			for ( int i = 0 ; i < N ; i++) {
				System.out.println(res[i]);
				System.out.println(degree[i]);
			}
			
			
			
			int no = 0;
			int idx = 0;
			for ( int i = 0 ; i < N ; i++) {
				if ( degree[i] == 0) {
					no++;
					if ( no == 2) {
						break;
					}
				}else {
					if ( degree[i] != 0) {
						idx = i;
					}
				}
			}
			
			for (int i = 0 ; i < N ; i++) {
				if ( res[i].contains(idx)) {
					idx = i;
					res[idx].remove(res[idx].size()-1);
					break;
				}
			}
			
			
			
			if ( no >= 2) {
				System.out.println("Confused");
			}else {
				Collections.sort(res[idx]);
				for (int i = 0 ; i < res[idx].size() ; i++) {
					System.out.println(res[idx].get(i));
				}
			}
			
			T--;
		}
	}
	
	public static void DFS(int start) {
		
		for ( int i = 0 ; i < adj[start].size() ; i++) {
			int next = adj[start].get(i);
			if ( visit[next] == false) {
				visit[next] = true;
				DFS(next);
			}
		}
		
		st.add(start);
	}
	
	public static void revDFS(int start,int real) {
		
		res[real].add(start);
		
		for ( int i = 0 ; i < revadj[start].size() ; i++) {
			int next = revadj[start].get(i);
			
			if ( visit[next] == false) {
				degree[next]++;
				visit[next] = true;
				revDFS(next,real);
				
			}
		}
		
		
		
	}
}
