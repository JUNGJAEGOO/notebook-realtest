package back6603;

import java.util.Scanner;

public class Main {

	static int tmparr[] = new int[6];
	static int arr[];
	
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		while ( true ) {
		int N = in.nextInt();
		if ( N == 0) {
			break;
		}
		arr = new int[N];
		
		for(int i = 0 ; i < N  ; i++) {
			arr[i] = in.nextInt();
		}
		
		for(int i= 0 ; i < arr.length-5 ;i++) {
		tmparr[0] = arr[i];
		back(tmparr,1,1);
		}
		System.out.println();
		}
	}
	
	public static void back(int[] tmparr,int start,int count) {
		
		if ( count == 6 ) {
			for(int i = 0 ; i < 6 ; i++) {
			System.out.print(tmparr[i]+" ");
			}
			System.out.println();
			return;
		}
		else if (count<6){
			for(int i = start ; i < arr.length ; i ++){
				if ( arr[i] > tmparr[count-1]) {
				tmparr[count] = arr[i]; 
				back(tmparr,i+1,count+1);
				}
			}
		}
		
		return;
	}
}
