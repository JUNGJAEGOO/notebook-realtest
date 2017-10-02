package back1298;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static ArrayList<Integer> list[];
	static int A[];
	static int B[];
	static int N;
	static boolean visit[];
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		System.out.println(M);
		int result = 0;
		list = new ArrayList[M];
		visit = new boolean[N];
		A = new int[N];
		B = new int[N];
		
		
		for(int i=0;i<M;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<N;i++) {
			A[i] = -1;
			B[i] = -1;
		}
		
		int start;
		int end;
		StringTokenizer st;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			start = Integer.parseInt(st.nextToken()) - 1;
			end	= Integer.parseInt(st.nextToken()) - 1;
			list[start].add(end);
		}
		
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<N;j++) { visit[j] = false; }
			if(DFS(i)) { result++; }
		}
		
		System.out.println(result);
		
		
	}
	
	
	
	public static boolean DFS(int start) {
		
		if(visit[start]==true) { return false;}
		visit[start] = true;
		
		for(int i = 0 ; i < list[start].size() ; i++) {
		int tmp = list[start].get(i);
		
		if( B[tmp] == -1 || !visit[B[tmp]] && DFS(B[tmp]) ) {
			A[start] = tmp;
			B[tmp] = start;
			return true;
		}
		
		}
		
	return false;
		
	}
}
