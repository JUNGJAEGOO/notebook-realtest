package back11576;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		int m = in.nextInt();
		int arr[] = new int[m];
		for (int i = 0 ; i < m ; i++) {
			arr[i] = in.nextInt();
		}
		long sum = 0;
		int cnt = 0;
		for (int i = m-1 ; i >= 0 ; i--) {
			
			sum = (long) (sum + arr[i]*Math.pow(A, cnt));
			cnt++;
		}
		
		ArrayList<Long> res = new ArrayList<>();
		
		while ( sum > 0) {
			
			res.add(sum%B);
			sum /= B;
			
		}
		
		for (int i = res.size()-1 ; i >= 0 ; i--) {
			System.out.print(res.get(i)+" ");
		}
		
	}
}
