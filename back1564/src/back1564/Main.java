package back1564;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new  Scanner(System.in);
		long N = in.nextLong();
		long ans = 1;
		BigInteger a = new BigInteger("1");
		for ( long i = 1 ; i<= N ; ++i) {
			//ans *= i;
			a = a.multiply(BigInteger.valueOf(i));
			while ( ans%10 == 0 ) {
				//ans /= 10;
			}
			while ( a.mod(new BigInteger("10")).compareTo(BigInteger.valueOf(0)) == 0  ) {
				a = a.divide(BigInteger.valueOf(10));
			}
			//ans%=1000000000;
			a = a.mod(new BigInteger("100000000000000"));
		}
		
		char tmp[] = String.valueOf(a.mod(BigInteger.valueOf(100000))).toCharArray();
		char res[] = new char[5];
		Arrays.fill(res, '0');
		
		int cnt = 5-tmp.length;
		for ( int i = 0 ; i < tmp.length ; i++) {
			res[cnt] = tmp[i];
			cnt++;
		}
		for ( int i = 0 ; i < 5 ; i++) {
			System.out.print(res[i]);
		}
	}

}
