package back11655;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] input = in.nextLine().toCharArray();
		
		for ( int i = 0 ; i < input.length ; i++) {
			
			if ( input[i] >= 'a' && input[i] <= 'z') {
				
				char newchar = (char)((int)input[i] + 13);
				if ( newchar > 'z') {
					newchar = (char)((int)newchar - 'z' + 'a' -1);
				}
				input[i] = newchar;
				
			}else if ( input[i] >= 'A' && input[i] <= 'Z') {
				
				char newchar = (char)((int)input[i] + 13);
				if ( newchar > 'Z') {
					newchar = (char)((int)newchar - 'Z' + 'A' -1);
				}
				input[i] = newchar;
				
			}
			
		}
		
		for ( int i = 0 ; i < input.length ; i++) {
			System.out.print(input[i]);
		}
	}
}
