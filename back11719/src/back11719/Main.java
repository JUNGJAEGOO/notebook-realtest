package back11719;

import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while ( true ) {

			String input = br.readLine();
			if ( input == null) {
				break;
			}
			
			sb.append(input+"\n");
		}
		System.out.print(sb);
	}
}
