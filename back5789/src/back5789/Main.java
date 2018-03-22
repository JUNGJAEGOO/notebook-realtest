package back5789;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while (T > 0) {
			
			char[] input = in.nextLine().toCharArray();
			int left = input.length/2;
			int right = input.length/2-1;
			
			if ( input[left] == input[right]) {
				System.out.println("Do-it");
			}else {
				System.out.println("Do-it-Not");
			}
			
			
			T--;
		}
	}
}
