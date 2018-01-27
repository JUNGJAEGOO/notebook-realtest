package back1671;
import java.io.*;
import java.util.*;

public class Main {

	static boolean visit[];
	static int A[],B[];
	static ArrayList<Integer> adj[];
	static int check[][];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		node list[] = new node[N];
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int idx = i;
			int size = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int wise = Integer.parseInt(st.nextToken());
			list[i] = new node(idx,size,speed,wise);
		}
		
		check = new int[N][N];
		adj = new ArrayList[N];
		A = new int[N];
		B = new int[N];
		for (int i = 0 ; i < N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < N ; i++) {
			int nowsize = list[i].size;
			int nowspeed = list[i].speed;
			int nowwise = list[i].wise;
			for (int j = 0 ; j < N ; j++) {
				if ( i == j ) {
					continue;
				}else {
					int nextsize = list[j].size;
					int nextspeed = list[j].speed;
					int nextwise = list[j].wise;
					
					if ( nowsize == nextsize && nowspeed == nextspeed && nowwise == nextwise && i > j) {
						continue;  // 핵심!!! 중복 제거를 위해서!!
					}
					if ( nowsize >= nextsize && nowspeed >= nextspeed && nowwise >= nextwise ) {
						adj[j].add(i);
					}
				}
			}
		}
		
		int ans = 0;
		visit = new boolean[N];
		Arrays.fill(A,-1);
		Arrays.fill(B,-1);
		for (int i = 0 ; i < N ; i++) {
			Arrays.fill(visit,false);
			if ( DFS(i)) {
				ans++;
			}
		}
		
		for (int i = 0 ; i < N ; i++) {
			System.out.print(A[i]+" ");
		}System.out.println();
		for (int i = 0 ; i < N ; i++) {
			System.out.print(B[i]+" ");
		}System.out.println();
		
		
		//Arrays.fill(A,-1);
		//Arrays.fill(B,-1);
		for (int i = 0 ; i < N ; i++) {
			Arrays.fill(visit,false);
			if ( DFS(i)) {
				ans++;
			}
		}
		
		for (int i = 0 ; i < N ; i++) {
			System.out.print(A[i]+" ");
		}System.out.println();
		for (int i = 0 ; i < N ; i++) {
			System.out.print(B[i]+" ");
		}System.out.println();
		
		System.out.println(ans);
		/*for ( int i = 0 ; i < N ; i++) {
			System.out.println(adj[i]);
		}*/
	}
	
	public static boolean DFS(int start) {
		if ( visit[start] == true) {
			return false;
		}
		visit[start] = true;
		
		for (int i = 0 ; i < adj[start].size() ; i++) {
			int next = adj[start].get(i);
			if ( B[next] == -1 || DFS(B[next])) {
				A[start] = next;
				B[next] = start;
				return true;
			}
		}
		
		return false;
	}
	
	public static class node{
		int idx;
		int size;
		int speed;
		int wise;
		node ( int idx, int size,int speed,int wise){
			this.idx = idx;
			this.size = size;
			this.speed = speed;
			this.wise = wise;
		}
	}
	
}
