package back14002;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		int res[] = new int[N];
		res[0] = arr[0];
		int len = 0;
		for ( int i = 0 ; i < N ; i++) {
			
			if ( arr[i] > res[len]) {
				len++;
				res[len] = arr[i];
				
			}else {
				int key = arr[i];
				int idx = Arrays.binarySearch(res, 0, len , key);
				if ( idx < 0 ) {
					idx = -idx - 1;
				}
				//System.out.println(len+" "+key+" "+idx);
				res[idx] = key;
		
			}
		}
		
		System.out.println(len+1);
		for ( int i = 0 ; i <= len ; i++) {
			System.out.print(res[i]+" ");
		}
		
	}
}
