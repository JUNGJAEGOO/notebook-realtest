package backB;

import java.util.*;

public class MainE {
	static boolean isPrime[];
	static ArrayList<Integer> prime = new ArrayList<>();
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		isPrime = new boolean[2000001];
		eratos();
		//System.out.println(prime.size());
		
		while ( T > 0) {
			
			
			long x = in.nextLong();
			long y = in.nextLong();
			boolean pass = false;
			
			if ( x + y >= 2 && (x+y)%2 == 0) {
				pass = true;
			}
			
			
			for( int i = 0 ; i < prime.size() ; i++) {
				
				int now = prime.get(i);
				long other = x+y-now;
				if ( isP(other) ) {
					pass =true;
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
	
	public static boolean isP(long x) {
		int cnt = 2;
		while ( true ) {
			if ( x % cnt == 0) {
				return false;
			}
			cnt++;
			if ( cnt > x/2) {
				break;
			}
			
		}
		
		return true;
	}
	
	public static void eratos() {
		
		isPrime[0] = true;
		isPrime[1] = true;
		for ( int i = 2 ; i < 2000001 ; i++) {
			if ( isPrime[i] == false ) {
				prime.add(i);
				for( int j = i + i ; i < 2000001 ; j = j + i) {
					if ( j > 2000000 ) {
						break;
					}
					isPrime[j] = true;
				}
			}
		}
		
	}
}
