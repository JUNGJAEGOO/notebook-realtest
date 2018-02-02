package back1514;

import java.util.Scanner;

public class Main {
	static int arr[];
	static int target[];
	
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		String origin = in.nextLine();
		arr = new int[N];
		target = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(String.valueOf(origin.charAt(i)));
		}
		String T = in.nextLine();
		for (int i = 0 ; i < N ; i++) {
			target[i] = Integer.parseInt(String.valueOf(T.charAt(i)));
		}
		
	}
	
	public static int func() {
		
		
	}
}
