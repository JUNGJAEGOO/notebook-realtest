package back2023;

import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		
		back(0,"",true);
	}
	
	public static void back(int len,String num,boolean first) {
		if ( len == N) {

			int div = 10;
			for ( int i = 1 ; i < len ; i++) {
				int tmp = Integer.parseInt(num);
				tmp /= div;
				boolean pass = isPrime(String.valueOf(tmp));
				if ( pass ) {
					
				}else {
					return;
				}
				div *= 10;
			}
			
			System.out.println(num);
			
			return;
		}
		
		if ( first == false) {
			for ( int i = 0 ; i <= 9 ; i++) {
			
				if ( isPrime(num+String.valueOf(i)) ) {
					back(len+1,num+String.valueOf(i),false);
				}
			
			}
		}else {
			for ( int i = 1 ; i <= 9 ; i++) {
				
				if ( isPrime(num+String.valueOf(i)) ) {
					back(len+1,num+String.valueOf(i),false);
				}
				
			}
		}
	}
	
	public static boolean isPrime(String num) {
		
		if ( num.equals("1")) {
			return false;
		}
		
		int stan = Integer.parseInt(num);
		int start = 1;
		while ( start < stan/2) {
			start++;
			if ( stan%start == 0 ) {
				return false;
			}
		}
		
		return true;
	}

}
