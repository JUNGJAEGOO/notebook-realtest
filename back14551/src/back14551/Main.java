package back14551;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 1;
		for (int i = 0 ; i < N ; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if ( tmp == 0 ) { tmp = 1; }
			ans = (tmp * ans) % M;
		}
		

		System.out.println(ans%M);
		
	}
}
