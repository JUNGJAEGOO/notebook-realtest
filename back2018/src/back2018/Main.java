package back2018;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int left = 1;
		int right = 1;
		int sum = 1;
		int res = 0;
		while ( true ) {
			
			if ( sum < N) {
				right++;
				sum+= right;
			}else if ( sum > N) {
				sum -= left;
				left++;
			}else if ( sum == N) {
				//System.out.println(left+" "+right);
				res++;
				sum -= left;
				left++;
			}
			
			if ( left > N ) {
				break;
			}
			
		}
		System.out.println(res);
		
	}
}
