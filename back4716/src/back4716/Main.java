package back4716;
import java.util.*;
public class Main {
	static int A,B,N;
	static int arrA[];
	static int arrB[];
	static int K[];
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		N = in.nextInt();
		A = in.nextInt();
		B = in.nextInt();
		arrA = new int[N];
		arrB = new int[N];
		K = new int[N];
		int min = -1;
		
		for ( int i= 0 ; i < N ; i++) {
			K[i] = in.nextInt();
			arrA[i] = in.nextInt();
			arrB[i] = in.nextInt();

		}
		

	}
	
	public static void findSuperMin() {
		char choice;
		int min = -1;
		int minindex = -1;
		for ( int i = 0 ; i < N ; i++) {
			if ( K[i]!=0 ) {
			int tmp = -1;
			if ( arrA[i] >= arrB[i] ) {
				choice = 'b';
				tmp = arrB[i];
				minindex = i;
			}
			else if ( arrB[i] > arrA[i] ){
				choice = 'a';
				tmp = arrA[i];
				minindex = i;
			}
		
			if ( tmp <= min) {
				min = tmp;
			}
			
			}
		
		}
		
	}
}
