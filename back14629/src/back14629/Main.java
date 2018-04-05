package back14629;

import java.math.BigInteger;
import java.util.*;

public class Main {
	static boolean visit[];
	static long mindiff = Long.MAX_VALUE;
	static int length;
	static long N;
	static long ans;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextLong();
		BigInteger comp = new BigInteger("9876543210");
		if ( BigInteger.valueOf(N).compareTo(comp) >= 0 ) {
			System.out.println("9876543210");
			return;
		}
		
		long now = N;
		visit = new boolean[10];
		length = String.valueOf(now).length();
		func("",0);
		System.out.println(ans);
	}
	
	public static void func(String str,int len) {
		
		//System.out.println(str);
		
		if ( len == length) {
			
			long diff = Math.abs(N - Long.parseLong(String.valueOf(str)));
	
			if ( diff < mindiff) {
				mindiff = diff;
				ans = Long.parseLong(String.valueOf(str));
			}
			
			return;
		}
		
		
		
		
		for ( int i = 0 ; i <= 9 ; i++) {
			if ( visit[i] == false) {
				visit[i] = true;
				func(str+String.valueOf(i),len+1);
				visit[i] = false;
			}
		}
	}
}
