package back2033;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		long N = in.nextLong();
		long arr[] = new long[9];
		int len = String.valueOf(N).length();
		int cnt = len-1;
		int stan = (int) Math.pow(10, len-1);
		//System.out.println(stan);
		while ( true ) {
			arr[cnt] = N/stan;
			N %= stan;
			stan /= 10;
			cnt--;
			if( cnt == -1 ) {
				break;
			}
		}
		
		int i = 0;
		int start = 10;
		while ( true) {
			boolean pass = false;
			String tmp = "";
			for ( int j = arr.length-1 ; j >= 0 ; j--) {
				tmp += arr[j];
			}
			if ( Integer.parseInt(tmp) > start) {
				pass = true;
				if ( arr[i] >= 5) {
					arr[i+1] += 1;
					arr[i] = 0;
					i++;
				}else {
					arr[i] = 0;
					i++;
				}
			}
			start *= 10;
			if ( pass == false) {
				System.out.println(Integer.parseInt(tmp));
				break;
			}
		}
		
		
	}
}
