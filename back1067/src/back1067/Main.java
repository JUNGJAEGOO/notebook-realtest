package back1067;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int arr1[] = new int[N];
		int arr2[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0 ; i < N ; i++) {
			arr2[i] =Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		long sum = 0;
		for ( int i = 0 ; i < N ; i++) {
			sum += arr1[i]*arr2[i];
		}
		
		System.out.println(sum);
	}
}
