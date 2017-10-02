package back1671;
import java.io.*;
import java.util.*;

public class Main {

	static boolean visit[];
	static data shark[];
	static data sharkA[];
	static int A[];
	static int B[];
	static LinkedList<Integer> list[];
	
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		list = new LinkedList[N];
		visit = new boolean[N];
		B = new int[N];
		A = new int[N];
		
		for ( int i = 0 ; i < N ; i ++ ) {
			;
			list[i] = new LinkedList<Integer>();
		}
		for ( int i = 0 ; i < N ; i ++ ) {
			A[i] = -1;
			B[i] = -1;
			
		}
		
		sharkA = new data[N];
		shark = new data[N];
		
		StringTokenizer st;
		for ( int i = 0 ; i < N ; i++) {
			shark[i] = new data();
			String info = br.readLine();
			st = new StringTokenizer(info);
			
			shark[i].size = Integer.parseInt(st.nextToken());
			shark[i].speed = Integer.parseInt(st.nextToken());
			shark[i].wise = Integer.parseInt(st.nextToken());
			shark[i].index = i;
		}
		
		for ( int i = 0 ; i < N ; i++) {
			sharkA[i] = new data();
			sharkA[i].size = shark[i].size;
			sharkA[i].speed = shark[i].speed;
			sharkA[i].wise = shark[i].wise;
			sharkA[i].index = i;

			
		}
		
		for(int i = 0 ; i < N;i++) {
			for(int j = 0 ; j < N;j++) {
			if ( (int)i == j) {
				continue;
			}
			else {
				if ( sharkA[i].size>=shark[j].size && sharkA[i].speed>=shark[j].speed && sharkA[i].wise>=shark[j].wise ) {
			    list[i].add(j);}
			}
			}
		}
		
	/*			for ( int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < list[i].size() ; j++) {
				System.out.print(list[i].get(j));
			}
			System.out.println();
		}*/
		
	for(int k = 0 ; k < 2 ; k ++) {
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0; j < N ; j++ ) {
				visit[i] = false;
			}
			
			for ( int j = 0 ; j < N ; j++) {
				if ( dfs(j,N) ) { result++; }
			}
		}
	}
		System.out.println(N-result);
	}
	
	public static class data{
		int index;
		int size;
		int speed;
		int wise;
		
	}
	
	public static boolean dfs(int start,int N) {
		
		if ( visit[start] ) { return false; }
		visit[start] = true;
		
		for ( int i = 0 ; i < list[start].size() ; i ++) {
			
			int tmp = list[start].get(i);	
			
				if ( B[tmp] == -1 || dfs(B[tmp],N)) {

					
					B[tmp] = start;

					return true;

				}
			}
		
		
		return false;
	}
	
}
