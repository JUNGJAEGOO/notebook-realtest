package back4485;
import java.util.*;
import java.io.*;
public class Main {
	
	static int mat[][];
	static int dist[][];
	static boolean visit[][];
	static ArrayList adj[];
	
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		mat = new int[N][N];
		dist = new int[N][N];
		visit = new boolean[N][N];
		
		for ( int i = 0 ; i < N ; i++) {
			String tmp = br.readLine();
			st = new StringTokenizer(tmp," ");
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				adj[i].get(j);
				adj[j].get(i);
			}
		}
		
		
		
		for(int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void daiikstra(int start) {
		
	}
	
	

}
