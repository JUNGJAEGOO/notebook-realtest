package back2857;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		String sb = "";
		for ( int i = 0 ; i <5 ; i++) {
			
			String tmp = in.nextLine();
			
			int idx = tmp.indexOf("FBI");
			if ( idx != -1 ) {
				sb+= (i+1+" ");
			}
			
		}
		
		if ( sb.equals("") ) {
			System.out.println("HE GOT AWAY!");
		}else {
			System.out.println(sb);
		}
	}
}
