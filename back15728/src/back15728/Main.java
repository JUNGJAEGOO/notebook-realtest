package back15728;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int arr[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		Arrays.sort(arr);
		
		int uem = arr[0];
		int yang = arr[N-1];
		
		int go[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			go[i] = in.nextInt();
		}
		Arrays.sort(go);
		
		int left = 0;
		int right= N-1;
		
		for ( int i = 0 ; i < K ; i++) {
			
			if ( uem*go[left] > yang*go[right]) {
				left++;
			}else if ( uem*go[left] == yang*go[right]) {
				if ( uem*go[left-1] > yang*go[right-1]) {
					left++;
				}else {
					right--;
				}
			}
			else {
				right--;
			}
			
		}
		
		if ( uem*go[left] > yang*go[right] ) {
			System.out.println(uem*go[left]);
		}else {
			System.out.println(yang*go[right]);
		}
		
	}
}
