package back8958;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		while ( N > 0) {
			
			char[] input = in.nextLine().toCharArray();
			
			int sum = 0;
			int counter = 0;
			
			for (int i = 0 ; i < input.length ; i++) {
				
				if ( input[i] == 'O') {
					counter++;
					sum += counter;
				}else {
					counter = 0;
				}
				
			}
			
			System.out.println(sum);
			N--;
		}
	}
}
