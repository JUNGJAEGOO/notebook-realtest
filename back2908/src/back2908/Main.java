package back2908;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().split(" ");
		char one[] = input[0].toCharArray();
		char two[] = input[1].toCharArray();
		char revOne[] = new char[one.length];
		char revTwo[] = new char[two.length];
		for (int i = 0 ; i < one.length ; i++) {
			revOne[i] = one[one.length-i-1];
		}
		for (int i = 0 ; i < two.length ; i++) {
			revTwo[i] = two[two.length-i-1];
		}
		
		int a = Integer.parseInt(String.valueOf(revOne));
		int b = Integer.parseInt(String.valueOf(revTwo));
		System.out.println(a>b?a:b);
	}
}
