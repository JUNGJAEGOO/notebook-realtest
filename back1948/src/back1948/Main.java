package back1948;

import java.util.*;

public class Main {
	static int N,M;
	static ArrayList<node> adj[];

	static int inn[];
	static int start,end;
	static int maxsum,maxlen;
	static ArrayList<Integer> maxvisit;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		adj = new ArrayList[N+1];
		for ( int i = 0 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			//System.out.println(from+" "+to);
		
			adj[from].add(new node(to,cost));
			//adj[to].add(new node(from,cost));
			
		}
		
		start = in.nextInt();
		end = in.nextInt();
		ArrayList<Integer> visit = new ArrayList<>();
		visit.add(start);
		DFS(start,0,0,visit);
		
		System.out.println(maxsum+"\n"+maxvisit.size());
		
	}
	
	public static void DFS(int now,int len,int sum,ArrayList<Integer> visit) {
		
	
		if ( now == end ) {
			System.out.println(visit+" "+sum);
			
			
			if ( sum > maxsum) {
				maxsum = sum;
				maxlen = len;
				maxvisit = new ArrayList<>();
				for ( int i = 0 ; i < visit.size() ; i++) {
					maxvisit.add(visit.get(i));
				}
			}else if ( sum == maxsum) {
				
				for ( int i = 0 ; i < visit.size() ; i++) {
					if ( !maxvisit.contains(visit.get(i))) {
						maxvisit.add(visit.get(i));
					}
				}
				
			}
			return;
		}
		
		for ( int i = 0 ; i < adj[now].size() ; i++) {
			int next = adj[now].get(i).idx;
			int nextcost = adj[now].get(i).cost;

			
			visit.add(next);
			DFS(next,len+1,sum+nextcost,visit);
			visit.remove(visit.size()-1);
		
			
			
		}
		
	}
	
	public static class node{
		int idx;
		int  cost;
		node ( int idx,int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}
}
