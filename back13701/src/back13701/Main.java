package back13701;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		BitSet bs = new BitSet(33554433);
		StringBuilder sb =new StringBuilder();
		
		while ( st.hasMoreTokens()) {
			
			
			int key = Integer.parseInt(st.nextToken());
			
			if ( bs.get(key)  ) {
				continue;
			}else {
				bs.set(key);
				sb.append(key+" ");
			}
			
			
		}
		
		
		System.out.println(sb);
	}

}
