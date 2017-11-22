package back1325;
import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<Integer>[] adj;
	static boolean visit[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N];
		visit = new boolean[N];
		for ( int i = 0 ; i < N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		
		for ( int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			adj[b].add(a);
		}
		
/*		for ( int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < adj[i].size() ; j++) {
				System.out.print(adj[i].get(j));
			}
			System.out.println();
		}*/
		
		int soo[] = new int[N];
		
		for ( int i = 0 ; i < N ; i++) {
			
				Arrays.fill(visit, false);
				soo[i] = DFS(i);
				//System.out.println("-------");
			
		}
		
	/*	for ( int i = 0 ; i < N ; i++) {
			System.out.print(soo[i]+" ");
		}System.out.println();
		*/
		
		int max = soo[0];
		
		for ( int i = 1 ; i < N ; i++) {
			if ( max < soo[i]) {
				max = soo[i];
			}
		}
		
		for ( int i = 0 ; i < N ; i++) {
			if ( soo[i] == max ) {
				System.out.print(i+1+" ");
			}
		}
	}
	
	public static int DFS(int x) {
		int max = 0;
		Queue<depth> st = new LinkedList<>();
		st.add(new depth(x,0));
		visit[x] = true;
		int count = 0;
		while ( !st.isEmpty() ) {
			depth tmp = st.poll();
			int dept = tmp.dep;
			//System.out.println(tmp.data+" "+dept);
			
			for ( int i = 0 ; i < adj[tmp.data].size() ;i++) {
				if ( visit[adj[tmp.data].get(i)] == false) {
				st.add(new depth(adj[tmp.data].get(i),dept+1));
				visit[adj[tmp.data].get(i)] = true;
				count++;
				}
			}
		}
		
		//System.out.println(count);
		
		return count;
	}
	
	public static class depth{
		int dep;
		int data;
		depth(int data,int dep){
			this.data = data;
			this.dep = dep;
		}
	}
}
