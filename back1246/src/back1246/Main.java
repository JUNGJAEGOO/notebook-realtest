package back1246;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int arr[] = new int[M];
		int dp[] = new int[M];
		for ( int i = 0 ; i < M ; i++) {
			arr[i] = in.nextInt();
		}
		
		int count = 0;
		while ( true ) {
			int y = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for ( int x = 0 ; x < M ; x++) {
				if ( arr[x] >= arr[count] ){
					list.add(arr[x]);					
				}
			}
	/*		for( int i = 0 ; i < list.size() ; i++) {
				System.out.print(list.get(i)+" ");
			}System.out.println();*/
			Collections.sort(list);

			for ( int i = list.size()-1 ; i>list.size()-1-N;i--) {
				if ( i < 0) {break; }
				dp[count] += arr[count];
			}

			
			count++;
			if ( count >= M) { break;}
		}
		
	/*	for ( int i = 0 ; i < M ; i++) {
			System.out.print(dp[i]+" ");
		}System.out.println();
		*/
		int maxindex = -1;
		int max = -1;
		
		for ( int i = 0 ; i < M ; i++) {
			if ( dp[i] > max) {
				max = dp[i];
				maxindex = i;
			}
		}
		
		System.out.println(arr[maxindex]+" "+dp[maxindex]);
	}
}
