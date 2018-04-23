package back15701;

import java.util.*;

public class Main {
	static int N;
	static ArrayList<Integer> primes = new ArrayList<>();
	static boolean isPrime[] = new boolean[31624];
	static int p[] = new int[31624];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N =in.nextInt();
		if ( N == 1) {
			System.out.println(1);
			return;
		}
		int cnt = 0;
		eratos();
		
		if ( isP(N) ) {
			System.out.println(2);
			return;
		}
		
		while ( true ) {
			
			if ( cnt >= primes.size() ) {
				break;
			}
			
			if ( N % primes.get(cnt) == 0 ) {
				N /= primes.get(cnt);
				p[primes.get(cnt)]++;
			}else {
				cnt++;
			}
			
		}
		
		
		int sum = 0;
	
		
		for ( int i = 0 ; i < 31624 ; i++) {
			if ( sum == 0 && p[i] > 0) {
				System.out.println(i+" "+p[i]);
				sum = (p[i]+1);
			}
			else if ( sum != 0 && p[i] > 0) {
				System.out.println(i+" "+p[i]);
				sum *= (p[i]+1);
			}
		}
		
		
		System.out.println(sum);
		
	}
	
	public static boolean isP(int x) {
		int n = x;
		int cnt = 2;
		while ( cnt <= x / 2) {
			if ( n % cnt == 0) {
				return false;
			}else {
				cnt++;
			}
		}
		
		return true;
		
	}
	
	public static void eratos() {
		isPrime[0] = true;
		isPrime[1] = true;
		for ( int i = 2; i < 31624 ; i++) {
			if ( isPrime[i] == false) {
				primes.add(i);
				for ( int j = i + i ; j < 31624 ; j = j + i) {
					if ( j >= 31624 ) {
						break;
					}
					isPrime[j] = true;
				}
			}
		}
	}
}
