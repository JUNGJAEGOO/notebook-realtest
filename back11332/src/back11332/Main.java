package back11332;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		
		while ( T > 0) {
			
			String input[] = in.nextLine().split(" ");
			
			if ( input[0].equals("O(N)")) {
				int N = Integer.parseInt(input[1]);
				int TT = Integer.parseInt(input[2]);
				int L = Integer.parseInt(input[3]);
				
				BigInteger a = BigInteger.valueOf(N).multiply(BigInteger.valueOf(TT));
				int limit = L*100000000;
				
				if ( a.compareTo(BigInteger.valueOf(limit)) <= 0) {
					System.out.println("May Pass.");
				}else {
					System.out.println("TLE!");
				}
				
			}
			else if ( input[0].equals("O(2^N)")) {
				int N = Integer.parseInt(input[1]);
				int TT = Integer.parseInt(input[2]);
				int L = Integer.parseInt(input[3]);
				
				long a = 2;
				boolean fuck = false;
				int limit = L*100000000;
				for (int i = 1 ; i < N ; i++) {
					a = a * 2;
					if ( a > limit) {
						fuck = true;
						break;
					}
				}
				//System.out.println(a);
				if ( !fuck ) {
					System.out.println("May Pass.");
				}else {
					System.out.println("TLE!");
				}
			}
			else if ( input[0].equals("O(N!)")) {
				int N = Integer.parseInt(input[1]);
				int TT = Integer.parseInt(input[2]);
				int L = Integer.parseInt(input[3]);
				
				int cnt = 1;
				BigInteger a = BigInteger.valueOf(1);
				int limit = L*100000000;
				boolean fuck = false;
				while ( cnt <= N) {
					if ( cnt > N) {
						break;
					}
					a = a.multiply(BigInteger.valueOf(cnt));
					//System.out.println(a);
					if ( a.compareTo(BigInteger.valueOf(limit)) > 0) {
						fuck = true;
						break;
					}
					cnt++;
				}
				
				//System.out.println(a);
				if ( !fuck) {
					System.out.println("May Pass.");
				}else {
					System.out.println("TLE!");
				}
				
			}
			else if ( input[0].equals("O(N^2)")) {
				int N = Integer.parseInt(input[1]);
				int TT = Integer.parseInt(input[2]);
				int L = Integer.parseInt(input[3]);
				
				BigInteger a = BigInteger.valueOf(N).multiply(BigInteger.valueOf(N)).multiply(BigInteger.valueOf(TT));
				int limit = L*100000000;
				
				if ( a.compareTo(BigInteger.valueOf(limit)) <= 0) {
					System.out.println("May Pass.");
				}else {
					System.out.println("TLE!");
				}
			}
			else if ( input[0].equals("O(N^3)")) {
				int N = Integer.parseInt(input[1]);
				int TT = Integer.parseInt(input[2]);
				int L = Integer.parseInt(input[3]);
				
				BigInteger a = BigInteger.valueOf(N).multiply(BigInteger.valueOf(N)).multiply(BigInteger.valueOf(N)).multiply(BigInteger.valueOf(TT));
				int limit = L*100000000;
				//System.out.println(a);
				if ( a.compareTo(BigInteger.valueOf(limit)) <= 0) {
					System.out.println("May Pass.");
				}else {
					System.out.println("TLE!");
				}
			}
			
			
			
			
			
			T--;
		}
		
	}

}
