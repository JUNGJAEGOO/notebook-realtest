package back14726;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while( T > 0) {
			
			char[] input = in.nextLine().toCharArray();
			for (int i = input.length-1 ; i >= 0 ; i--) {
				
				if ( (i+1)%2 == 0) {
					continue;
				}else {
					int tmp = Integer.parseInt(String.valueOf(input[i]));
					tmp *= 2;
					if ( tmp >= 10) {
						tmp = tmp%10 + tmp/10;
					}
					input[i] = String.valueOf(tmp).charAt(0);
				}
				
			}
			
			int sum = 0;
			for (int i = 0 ; i < input.length ; i++) {
				sum += Integer.parseInt(String.valueOf(input[i]));
			}
			
			if (sum%10 == 0) {
				System.out.println("T");
			}else {
				System.out.println("F");
			}
			
			T--;
		}
	}
}
