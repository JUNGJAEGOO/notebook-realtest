package back1292;
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		int mat[]= new int[1001];
		int count = 0;
		int tmpcount = 0;
		int mokpyo = 1 ;
		
		while ( true ) {
			
			mat[count] = mokpyo;
			count++;
			tmpcount++;
			if ( tmpcount == mokpyo) {
				mokpyo++;
				tmpcount = 0;
			}
			
			if ( count == 1001 ) {
				break;
			}
			
		}
		
		/*for ( int i = 0 ; i < 100 ; i++) {
			System.out.print(mat[i]+" ");
		}
		System.out.println();
		*/
		int sum = 0;
		for ( int i = A-1 ; i <= B-1 ; i++) {
			sum+=mat[i];
		}
		System.out.println(sum);
	}
}
