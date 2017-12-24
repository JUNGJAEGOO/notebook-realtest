package back2204;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		while ( true ) {
		int N = Integer.parseInt(br.readLine());
		if ( N == 0 ) {
			break;
		}
		
		String res = "";
		for ( int i = 0 ; i < N ; i++) {
			if ( i == 0) {
				res = br.readLine();
				continue;
			}
			
			String tmp = br.readLine();
			String tmp1 = res.toUpperCase();
			String tmp2 = tmp.toUpperCase();
			if ( tmp1.compareTo(tmp2) > 0 ) {
				res = tmp;
			}

		}
		
		
		System.out.println(res);
		}
	}
}
