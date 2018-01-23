package back1914;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static int N;
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		BigInteger sum = BigInteger.ONE;
		if ( N <= 20) {
			hanoi(true,N,1,2,3);
			System.out.println(cnt);
			System.out.print(sb);
		}else {
			
			for (int i = 0  ; i < N ; i++) {
				sum = sum.multiply(BigInteger.valueOf(2));
			}
			System.out.println(sum.subtract(BigInteger.ONE));
		}
		
		//System.out.print(sb);
	}
	
	public static void hanoi(boolean pass,int n,int from,int by,int to) {
		if ( n == 1 ) {
			//System.out.println(from+" "+to);
			cnt++;
			if ( pass) {
				sb.append(from+" "+to+"\n");
			}
			return;
		}
		cnt++;
		hanoi(pass,n-1,from,to,by);
		if ( pass) {
			sb.append(from+" "+to+"\n");
		}
		hanoi(pass,n-1,by,from,to);
	}
	
}
