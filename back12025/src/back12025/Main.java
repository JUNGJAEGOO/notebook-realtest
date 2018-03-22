package back12025;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] origin = in.nextLine().toCharArray();
		
		long s = 0;
		ArrayList<Integer> indexing = new ArrayList<>();
		for ( int i = 0 ; i < origin.length ; i++) {
			if ( origin[i] == '1' || origin[i] == '2' || origin[i] == '6' || origin[i] == '7' ) {
				indexing.add(i);
				s++;
			}
		}
		
		s = (long) Math.pow(2, s);
		long k = Long.parseLong(in.nextLine());
		
		if ( k > s) {
			System.out.println(-1);
			return;
		}
		
		int cnt = 0;
		s = s/2;
		while ( cnt < indexing.size() ) {
			
			if ( k <= s) {
				
				if ( origin[indexing.get(cnt)] == '1' || origin[indexing.get(cnt)] == '6'  ) {
					origin[indexing.get(cnt)] = '1';
					s /= 2;
					cnt++;
				}else if ( origin[indexing.get(cnt)] == '2' || origin[indexing.get(cnt)] == '7' ) {
					origin[indexing.get(cnt)] = '2';
					cnt++;
					s /= 2;
				}
				
			}else {
				
				if ( origin[indexing.get(cnt)] == '1' || origin[indexing.get(cnt)] == '6'  ) {
					origin[indexing.get(cnt)] = '6';
					k -= s;
					s /= 2;
					cnt++;
				}else if ( origin[indexing.get(cnt)] == '2' || origin[indexing.get(cnt)] == '7' ) {
					origin[indexing.get(cnt)] = '7';
					k -= s;
					cnt++;
					s /= 2;
				}
				
			}
			
			
		}
		
		for (int i = 0 ; i < origin.length ; i++ ) {
			System.out.print(origin[i]);
		}
		
	}
	
	
}
