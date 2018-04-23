package back15688;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[];
		StringBuilder sb = new StringBuilder();
		try {
			
			int N = Integer.parseInt(br.readLine());
			arr = new int[2000001];
		
			int min = 1000000000;
			int max = -100000000;
			for ( int i = 0 ; i < N ; i++) {
				int X = Integer.parseInt(br.readLine());
				X += 1000000;
				min = Math.min(min, X);
				max = Math.max(max, X);
				arr[X]++;
			}
			
			lop:
			for ( int i = min ; i <= max ; i++) {
				
				for (int j = 0 ; j < arr[i] ; j++) {
					sb.append(i-1000000+"\n");
					N--;
					if ( N == 0) {
						break lop;
					}
				}
			}
			
			
			
		}catch ( IOException e) {
			
		}
		
		System.out.print(sb);
		
	}
}
