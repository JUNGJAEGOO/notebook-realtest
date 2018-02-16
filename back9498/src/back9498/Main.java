package back9498;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String ans = "";
		if ( N >= 90 && N <= 100) {
			ans = "A";
		}else if ( N >= 80 && N <= 89) {
			ans = "B";
		}else if ( N >= 70 && N <= 79) {
			ans = "C";
		}else if ( N >= 60 && N <= 69) {
			ans = "D";
		}else {
			ans = "F";
		}
		System.out.print(ans);
	}
}
