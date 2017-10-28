package back1003;

import java.util.Scanner;
import java.io.*;
public class Main {
	static int zero, one ;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while ( T > 0) {
			
			int x  = Integer.parseInt(br.readLine());
			one = 0 ; 
			zero = 0;
			pibo(x);
			T--;
			System.out.println(zero+" "+one);
		}
	}
	
	public static void pibo(int x) {
		if ( x == 0) {
			zero++;
			return;
		}
		else if ( x == 1) {
			one++;
			return;
		}else {
			pibo(x-1);
			pibo(x-2);
			return;
		}
	}
}
