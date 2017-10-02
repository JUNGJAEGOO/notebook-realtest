package back6086;
import java.util.*;
import java.io.*;
public class Main {

	static int inf = 1900000000;
	static int now[][];
	static int capa[][];
	static int prev[];
	static ArrayList<Integer> adj[];
	static int result = 0;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		now = new int[52][52];
		capa = new int[52][52];
		adj = new ArrayList[52];
		prev = new int[52];
		
		StringTokenizer st = null;
		for ( int i = 0 ; i < 52 ; i++ ) {
			for ( int j = 0 ; j < 52 ; j++) {
				capa[i][j] = inf;
			}
			adj[i] = new ArrayList<Integer>();
		}
		
		for ( int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine()," ");
			
			char charstart = st.nextToken().charAt(0);
			char charend = st.nextToken().charAt(0);
			String tmpcost = st.nextToken();
			int cost = Integer.parseInt(tmpcost);
			int start = translate(charstart);
			int end = translate(charend);
			if ( capa[start][end] != inf ) {
				capa[start][end] = capa[start][end] + cost;
			}
			else {
				capa[start][end] = cost;
			}
			
			adj[start].add(end);
			adj[end].add(start);
			
			
		}

/*		for(int i=0;i<51;i++) {
			for(int j=0;j<adj[i].size();j++) {
				System.out.print(adj[i].get(j)+" ");
			}
			System.out.println("");
		}*/
		
		int test = 0;
		for ( int i = 0 ; i < 52 ; i++) {
			if(capa[0][i] != inf || capa[51][i] != inf) { test++;} 	
		}
		if(test==0) { return; }

		BFS(0,25);
		System.out.println(result);
	}
	
	public static void BFS(int start,int end) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		while ( true ) {
			
			for(int i=0;i<52;i++) {
			prev[i] = -1;
			}
			
			q.add(start);
			
			while ( !q.isEmpty() ) {
				
				int tmp = q.remove();
				
				for ( int i = 0 ; i<adj[tmp].size();i++) {
					
					int next = adj[tmp].get(i);
					
					if ( prev[next] != -1 ) {
						continue;
					}
					
					if ( capa[tmp][next] - now[tmp][next] > 0) {
						prev[next] = tmp;
						
						q.add(next);
		
						
						if ( next == end ) {
							break;
						}
					}
					
				}
			}
			
			if ( prev[end] == -1 ) {
				break;
			}
			
/*			for(int i = 0 ; i < 52 ; i ++ ) {
				if(prev[i]!=-1) {
				System.out.print(prev[i]+" ");
				}
			}
			System.out.println();
			*/
			int flow = inf;
			for ( int i = end ; i != start ; i = prev[i]) {
				flow = Math.min(flow, capa[prev[i]][i]-now[prev[i]][i]);
			}
			for ( int i = end ; i != start ; i = prev[i]) {
				now[prev[i]][i] += flow;
				now[i][prev[i]] -= flow;
			}
			result += flow;
		}
		
		
	}
	
	
	
	public static int translate(char x) {
		
		if( x <= 'Z' ) { return x-'A';}
		return x - 'a' + 26;
	}
}
