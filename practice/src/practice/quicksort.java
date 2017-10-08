package practice;


import java.util.*;
public class quicksort {

	static int arr[];
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("qqq");
		N = in.nextInt();
		arr = new int[N];
		for ( int i = 0 ; i<N ; i++) {
			arr[i] = in.nextInt();
		}
		
		for ( int i = 0 ; i<N ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		sort(0,6);
		
		
		for ( int i = 0 ; i<N ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		in.close();
	}
	
	public static void sort(int start,int end) {
	
		
		if ( start < end)
		{		
			int key = arr[start];
			int left = start + 1;
			int right = end;
			
			
			while ( left < right){

			
			while ( arr[left] <= key && left < end) {
				left++;
			}
			while ( arr[right] >= key && right > start)  {
				right--;
			}
			
			
			if( left < right ) {
			int tmp;
			tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
			}
			
			}
			
				if ( arr[right]< key) {
				int tmp = arr[start];
				arr[start] = arr[right];
				arr[right] = tmp;
				}
				
				for ( int i = 0 ; i<N ; i++) {
					System.out.print(arr[i]+" ");
				}
				System.out.println();
				
				sort(start,right-1);
				sort(right+1,end);
			
		
		}
			
	}
	
	
}
