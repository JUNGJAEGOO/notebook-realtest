package back2481;

import java.io.*;
import java.util.*;

public class Main {
	static String arr[];
	static int want[];
	static int N,K;
	static boolean visit[];
	static String res;
	static int min = 10000000;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//Scanner in = new Scanner(System.in);
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new String[N+1];
		for (int i = 1 ; i <= N ; i++) {
			arr[i] = br.readLine();
		}
		int M = Integer.parseInt(br.readLine());
		want = new int[M];
		for( int i = 0 ; i < M ; i++) {
			want[i] = Integer.parseInt(br.readLine());
		}
		

		for (int i = 0 ; i < M ; i++) {
			visit= new boolean[N+1];
			visit[1] = true;
			min = 100000000;
			DFS(0,1,"1",i);
		}
	}
	
	public static void DFS(int len,int before,String now,int target) {
		
		//System.out.println(now);
		//System.out.println(before+" "+want[target]);
		
		if ( before == want[target]) {
			if ( len < min) {
				min = len;
				res = now;
			}
			System.out.println(res);
			return;
		}
		
		int tmp[] = new int[K];
		for ( int i = 0 ; i < K ; i++) {
			tmp[i] = Integer.parseInt(String.valueOf(arr[before].charAt(i)));
		}
		
		for (int i = 1 ; i <= N ; i++) {
			
			if ( len+1 < min && visit[i] == false) {
				int tmp2[] = new int[K];
				for ( int j = 0 ; j < K ; j++) {
					tmp2[j] = Integer.parseInt(String.valueOf(arr[i].charAt(j)));
				}
				
				int sum = 0;
				for ( int j = 0 ; j < K ; j++) {
					sum += Math.abs(tmp[j]-tmp2[j]);
				}
				//System.out.println((A-a)+" "+(B-b)+" "+(C-c));
				if ( sum == 1) {
					visit[i] = true;
					DFS(len+1,i,now+" "+String.valueOf(i),target);
					visit[i] = false;
				}
			}
		}
		
		
	}
	
}
