package back5211;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split("\\|");
		int A = 0;
		int D = 0;
		int E = 0;
		int C = 0;
		int F = 0;
		int G = 0;
		
		for ( int i = 0 ; i < info.length ; i++) {
			
			//System.out.println(info[i].charAt(0));
			
			if ( info[i].charAt(0) == 'A') {
				A++;
			}else if ( info[i].charAt(0) == 'D') {
				D++;
			}else if ( info[i].charAt(0) == 'E') {
				E++;
			}else if ( info[i].charAt(0) == 'C') {
				C++;
			}else if ( info[i].charAt(0) == 'F') {
				F++;
			}else if ( info[i].charAt(0) == 'G') {
				G++;
			}
		}
		
		if ( A+D+E > C+F+G) {
			System.out.println("A-minor");
			
		}else if ( A+D+E == C+F+G ){
			if ( String.valueOf(info[info.length-1].charAt(info[info.length-1].length()-1)).matches("[A|D|E]") ) {
				System.out.println("A-minor");
			}else {
				System.out.println("C-major");
			}
		}
		else {
			System.out.println("C-major");
		}
		
	}
}
