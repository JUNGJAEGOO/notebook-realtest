package back1718;

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] origin = br.readLine().toCharArray();
		char[] key = br.readLine().toCharArray();
		char cipher[] = new char[origin.length];
		int cnt = 0;
		for (int i = 0 ; i < origin.length ; i++) {
			cipher[i] = key[cnt];
			cnt++;
			if ( cnt >= key.length) {
				cnt = 0;
			}
		}
		
		char []ans = new char[origin.length];
		for (int i = 0 ; i < origin.length ; i++) {
			if ( origin[i] == ' ') {
				continue;
			}
			int num = cipher[i] - 'a'; 
			//System.out.println(num+1);
			int soo = origin[i] - (num + 1);
			if ( soo < 'a') {
				soo += 26;
			}
			ans[i] = (char)soo;
		}
		
		for (int i = 0 ; i < ans.length ; i++) {
			System.out.print(ans[i]);
		}
		
	}
}
