package back1086;

import java.util.Scanner;

public class Main {
	static String[] arr;
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = Integer.parseInt(in.nextLine());
		arr = new String[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextLine();
		}
		int m = Integer.parseInt(in.nextLine());
		double a = System.currentTimeMillis();
		permutation(0);
		double b = System.currentTimeMillis();
		System.out.println(b-a);
		
		System.out.println(!2);
	}
	
	public static void permutation(int idx) {
		
		if ( idx == N) {
			/*for ( int i = 0 ; i < N ; i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();*/
		}
		
		for ( int i = idx  ; i < N ; i++) {
			
			swap(i,idx);
			permutation(idx+1);
			swap(i,idx);
			
		}
		
		
	}
	
	public static void swap(int o,int t) {
		String temp = arr[o];
		arr[o] = arr[t];
		arr[t] = temp;
	}
}
