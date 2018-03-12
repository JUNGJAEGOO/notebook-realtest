package back15552;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while ( T > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sb.append(A+B+"\n");

			
			T--;
		}
		
		System.out.print(sb);
	}
}
