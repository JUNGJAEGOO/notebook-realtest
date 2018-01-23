package back1725;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.*;

public class Main {

	static int arr[];
	
	public static void main(String args[]) {
	
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		Stack<Integer> st = new Stack<>();
		
		arr= new int[N+2];
		for (int i = 1 ; i<= N ; i++) {
			arr[i] = in.nextInt();	
		}
	
		long sum = 0;
		st.add(arr[0]);
		for (int i = 1 ; i <= N+1 ; i++) {
			
			while ( !st.isEmpty() && arr[i] < arr[st.peek()]) {
					int h = arr[st.peek()];
					st.pop();
					long tmp = ( h ) * (i-st.peek()-1);
					sum = Math.max(tmp, sum);
				
			}
			st.add(i);
		}
	
		System.out.println(sum);
	}
	
}
