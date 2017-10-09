package back11053;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		String array = br.readLine();
		
		int arr[] = new int[N];
		int dp[] = new int[N];
		int count[] = new int[N];
		
		int coun=0;
		st = new StringTokenizer(array," ");
		while ( st.hasMoreTokens()) {
			
			arr[coun] = Integer.parseInt(st.nextToken());
			coun++;
		}
		

		for ( int i = 0 ; i < N ; i++) {
			dp[i] = arr[i];
			count[i] += 1;
		}
		
		for( int j = 0 ; j < N ; j++) {
			for ( int i = 0 ; i < j ; i++) {
				if ( arr[j]>arr[i]) {
					if ( count[i]+1>count[j]) {
						count[j] = count[i]+1; 
					}
				}
			}
		}
		
		for ( int i = 0 ; i < N ; i++) {
			System.out.println(dp[i]+" "+count[i]);
		}
		
		int max=-1;
		for ( int i = 0 ; i < N ; i++) {
			if ( count[i]>max) {
				max = count[i];
			}
		}
		
		System.out.println(max);
	}
}
