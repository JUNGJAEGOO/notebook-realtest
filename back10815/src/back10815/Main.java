package back10815;

import java.util.Arrays;
import java.util.*;
import java.io.*;

public class Main {
	static int arr[];
	static int que[];
	static int N;
	public static void main(String args[]) throws Exception{
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String ars = br.readLine();
		StringTokenizer st = new StringTokenizer(ars," ");
		
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		que = new int[M+1];
		String qus = br.readLine();
		st = new StringTokenizer(qus," ");
		for ( int i = 1 ; i <= M ; i++) {
			que[i] = Integer.parseInt(st.nextToken());
		}

		for ( int i = 1 ; i <= M ; i++) {
			search(que[i]);
		}
		
	
	}
	//0 ~ N-1
	public static void search(int x) {
		int mid;
		int start = 0;
		int end = N-1;
				while ( true ) {
			mid = (start+end)/2;
			
			//System.out.print("미드:"+arr[mid]);
			if (x == arr[mid] || arr[start] == x || arr[end] == x) {
				System.out.print(1+" ");
				return;
			}
			else if ( x > arr[mid]) {
				start = mid+1;
			}else if ( x < arr[mid]){
				end = mid-1;
			} 
				
			if ( end <= start) {
				System.out.print(0+" ");
				return;
			}
		
		}
	}
}
