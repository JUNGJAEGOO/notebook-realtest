package back10610;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] input = in.nextLine().toCharArray();
		long sum = 0;
		int zero = 0;
		int num[] = new int[10];
		for ( int i = 0 ; i < input.length ; i++) {
			
			if ( input[i] == '0') {
				zero++;
			}
			num[Integer.parseInt(String.valueOf(input[i]))]++;
			sum += Integer.parseInt(String.valueOf(input[i]));
			
		}
		
		
		if ( sum % 3 == 0 && zero >= 1) {
			for ( int i = 9 ; i >= 0 ; i--) {
				for ( int j = 0 ; j < num[i] ; j++) {
					System.out.print(i);
				}
			}
			System.out.println();
		}else {
			System.out.println(-1);
		}
	}
}
