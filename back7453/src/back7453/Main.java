package back7453;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long A[] = new long[N];
		long B[] = new long[N];
		long C[] = new long[N];
		long D[] = new long[N];
		
		ArrayList<Long> AB = new ArrayList<>();
		ArrayList<Long> CD = new ArrayList<>();
		
		
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			long d = Long.parseLong(st.nextToken());
			
			A[i] = a;
			B[i] = b;
			C[i] = c;
			D[i] = d;
		}
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				AB.add((A[i]+B[j]));
				CD.add((C[i]+D[j]));
			}
		}
		
		//Collections.sort(AB);
		Collections.sort(CD);

		long sum = 0;
		
		for ( int i = 0 ; i < AB.size() ; i++) {
			
			long now = AB.get(i);
			
			int left = 0;
			int right = AB.size()-1;
			int max = 0;
			
			while ( left < right) {
				int mid = (left+right)/2;
				
				if ( now + CD.get(mid) <= 0) {
					left = mid + 1;
				}else {
					right = mid;
				}
			}
			
			max = right;
			left = 0;
			right = AB.size()-1;
			int min = 0;
			
			while ( left < right) {
				int mid = (left+right)/2;
				
				if ( now + CD.get(mid) < 0) {
					left = mid + 1;
				}else {
					
					right = mid;
				}
			}
			min = right;
			sum += max - min;
			
		}
		
		System.out.println(sum);
	}
}
