package back11575;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while ( T > 0) {
			
			String tmp[] = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			
			char input[] = br.readLine().toCharArray();
			
			for (int i = 0 ; i < input.length ; i++) {
				
				int X = input[i] - 'A';
				//System.out.println(X);
				int E = (a*X + b) % 26;
				//System.out.println(E);
				input[i] = (char)(E+'A');
				sb.append(input[i]);
			}
			sb.append("\n");
			
			T--;
		}
		System.out.println(sb);
	}
}
