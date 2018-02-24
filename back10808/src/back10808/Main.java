package back10808;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] input = in.nextLine().toCharArray();
		int arr[] = new int[26];
		for (int i = 0; i < input.length ; i++) {
			arr[input[i]-'a']++;
		}
		for (int i = 0; i < arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
