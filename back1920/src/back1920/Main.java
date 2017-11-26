package back1920;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		int want[] = new int[M];
		for ( int i = 0 ; i < M ; i++ ) {
			want[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		for ( int i = 0 ; i < M ; i++) {
			
			int start = 0;
			int end = N-1;
			int target = want[i];
			boolean pass =false;
			while ( true) {
				int mid = (start+end)/2;
				//System.out.println(mid);
				if ( target > arr[mid]) {
					start = mid+1;
				}else if ( target < arr[mid]) {
					end = mid-1;
				}else if ( target == arr[mid]) {
					pass =true;
					break;
				}
				
				if( start > end) {
					if ( arr[mid] == target) {
						pass = true;
					}
					break;
				}
			}
			//System.out.println("-----------");
			if( pass) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			
		}
		
		
	}
}
