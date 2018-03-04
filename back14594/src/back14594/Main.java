package back14594;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int wall[] = new int[N];
		Arrays.fill(wall, 1);
		int n = in.nextInt();
		for (int i = 0 ; i < n ; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			for (int j = start ; j < end ; j++) {
				wall[j] = 0;
			}
		}
		
		int sum = 0;
		for (int i = 1 ; i <  N ; i++) {
			if (wall[i] == 1) {
				sum++;
			}else {
				
			}
			
		}
		
		System.out.println(sum+1);
	}
}
