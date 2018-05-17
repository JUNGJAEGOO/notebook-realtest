package back2437;

import java.util.*;

public class Main {
	static ArrayList<Integer> list;
	static boolean visit[];
	static int N;
	static int arr[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		Arrays.sort(arr);
		
		int before = 0;
		int sum = 0;
		for ( int i = 0 ; i < arr.length ; i++) {
			if ( sum+1 < arr[i]) {
				break;
			}else {
				sum = sum + arr[i];
			}
		}
		
		System.out.println(sum+1);
	}

}
