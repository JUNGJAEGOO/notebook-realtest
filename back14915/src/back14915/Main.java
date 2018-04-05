package back14915;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		String res = "";
		while ( true ) {
			
			int nam = m%n;
			m = m/n;
			char plus = String.valueOf(nam).charAt(0);
			
			if ( nam == 15) {
				plus = 'F';
			}else if (nam == 14) {
				plus = 'E';
			}else if( nam == 13) {
				plus = 'D';
			}else if ( nam == 12) {
				plus = 'C';
			}else if ( nam== 11) {
				plus = 'B';
			}else if ( nam == 10) {
				plus = 'A';
			}
			
			
			res += plus;
			if ( m == 0) {
				break;
			}
			
		}
		
		for ( int i = res.length()-1 ; i >= 0 ; i--) {
			System.out.print(res.charAt(i));
			
		}
		
	}
}
