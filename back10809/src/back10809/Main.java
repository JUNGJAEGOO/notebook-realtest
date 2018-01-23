package back10809;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int alpha[] = new int[26];
		char[] str = in.nextLine().toCharArray();
		Arrays.fill(alpha, -1);
		for (int i = 0 ; i < str.length ; i++) {
			if ( alpha[str[i]-'a'] == -1 ) {
				alpha[str[i]-'a'] = i;
			}
		}
		
		for (int i = 0 ; i < 26 ; i++) {
			System.out.print(alpha[i]+" ");
		}
	}
}
