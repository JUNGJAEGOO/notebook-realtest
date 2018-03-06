package back10173;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while ( true) {
			String str = in.nextLine();
			if ( str.equals("EOI")) {
				break;
			}
			str = str.toUpperCase();
			char[] input = str.toCharArray();
			
			if (str.contains("NEMO") ) {
				System.out.println("Found");
			}else {
				System.out.println("Missing");
			}
				
			
		}
	}
}
