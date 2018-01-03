package back9322;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while ( T > 0 ) {
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String[] first = new String[num];
			String[] second = new String[num];
			int cnt = 0;
			while ( st.hasMoreTokens() ) {
				first[cnt] = st.nextToken();
				cnt++;
			}
			cnt = 0;
			st = new StringTokenizer(br.readLine()," ");
			while ( st.hasMoreTokens() ) {
				second[cnt] = st.nextToken();
				cnt++;
			}
			
			int[] rules = new int[num];
			for ( int i = 0 ; i < num ; i++) {
				for ( int j = 0 ; j < num ; j++) {
					if ( second[i].equals(first[j])) {
						rules[i] = j;
					}
				}
			}
			
			cnt = 0;
			String cypher[] = new String[num];
			st = new StringTokenizer(br.readLine()," ");
			while ( st.hasMoreTokens() ) {
				cypher[cnt] = st.nextToken();
				cnt++;
			}
			
			String ans[] = new String[num];
			for ( int i = 0; i < num ; i++) {
				ans[rules[i]] = cypher[i];
			}
			
			StringBuilder sb = new StringBuilder();
			for ( int i = 0 ; i < num ; i++) {
				sb.append(ans[i]+" ");
			}
			
			System.out.println(sb);
			T--;
		}
	}
}
