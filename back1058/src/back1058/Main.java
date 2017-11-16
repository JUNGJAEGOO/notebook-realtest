package back1058;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws Exception, IOException {
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());
		int mat[][] = new int[N][N];
		ArrayList<Integer> adj[]  = new ArrayList[N];
		for (int i = 0 ; i < N ; i++ ) {
			adj[i] = new ArrayList<Integer>();
		}
		
		
		for ( int i = 0 ; i < N ; i++) {
			String input = br.readLine();
			char tmp[] = input.toCharArray();
			for ( int j = 0 ; j < N ; j++) {
				if ( tmp[j] == 'Y') {
					mat[i][j] = 1;
					adj[i].add(j);
				}else {
					mat[i][j] = 0;
				}
			}
		}
		
		int result = 0;
		int count;
		for ( int i = 0 ; i < N ; i++) {
			count = 0 ;
			for ( int j = 0 ; j < N ; j++) {
				if ( mat[i][j] == 1 ) {
					count++;
				}else {
					if ( i == j ) { continue; }
					origin:
					for ( int k = 0 ; k < adj[i].size() ; k++) {
						int tmp1 = adj[i].get(k);
						for ( int s = 0 ; s < adj[j].size() ; s++) {
							int tmp2 = adj[j].get(s);
							if ( tmp1 == tmp2 ) {
								//System.out.println(i+","+j+"일때 "+tmp1+" "+tmp2);
								count++;
								break origin;
							}
						}
					}
				}
				
			}
			result = Math.max(result, count);
		}
		
		System.out.println(result);
		
		
	}
}
