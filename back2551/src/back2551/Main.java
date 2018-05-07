package back2551;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		long arr[] = new long[10001];
		long data[] = new long[N];
		long sum = 0;
		
		for ( int i = 0 ; i < N ; i++) {
			long x = Long.parseLong(st.nextToken());
			data[i] = x;
			sum += x;
			arr[(int)x]++;

		}
		
		long tmp = 0;
		for (int i = 1 ; i < 10001 ; i++) {
			
			tmp += arr[i];	
			
			if ( tmp*2 >= N) {
				break;
			}
			
		}

		long mid = sum/N;
		long sum1 = 0;
		long sum2 = 0;
		
		for ( int i = 0 ; i < N ; i++) {
			
			sum1 += Math.abs(data[i]-mid)*Math.abs(data[i]-mid);
			sum2 += Math.abs(data[i]-(mid+1))*Math.abs(data[i]-(mid+1));
			
		}
		
		if ( sum1 <= sum2) {
			
		}else {
			mid++;
		}
		Arrays.sort(data);
		System.out.println(data[(N-1)/2]+" "+mid);
	}
}
