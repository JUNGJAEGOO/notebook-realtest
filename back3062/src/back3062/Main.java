package back3062;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while ( T > 0 ) {
			
			
			String A = in.nextLine();
			String N[] = A.split("");
			String B = "";
			for ( int i = N.length-1 ; i >= 0  ; i--) {
				B += N[i];
			}
			
			int C = Integer.parseInt(A) + Integer.parseInt(B);
			
			char tmp[] = String.valueOf(C).toCharArray();
			
			boolean pass = true;
			int left = 0;
			int right = tmp.length-1;
			while ( true ) {
				if ( left > right) {
					break;
				}
				
				if ( tmp[left] == tmp[right] ) {
					left++;
					right--;
				}else {
					pass = false;
					break;
				}
			}
			
			if ( pass) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
			T--;
		}
	}
}
