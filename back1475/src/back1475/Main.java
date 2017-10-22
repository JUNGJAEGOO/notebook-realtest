package back1475;
import java.util.*;
public class Main {
	
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		String input = in.nextLine();
		char str[] = input.toCharArray();
		int result=0;
		int sootza[] = new int[10];
	
		
		for ( int i = 0 ; i < str.length ; i ++) {
			
			sootza[Integer.parseInt(String.valueOf(str[i]))] += 1;
		}
		
/*		for( int i = 0 ; i<10 ;i++) {
		System.out.print(sootza[i]+" ");
		}System.out.println();*/
		
		int max = -1;
		for ( int i = 0 ; i < 10 ; i++) {
			if ( i == 6 | i ==9) {
			continue;
			}
			max = Math.max(max, sootza[i]);
		}
		
/*		System.out.println(max);*/
		result += max;
		
		if( sootza[6]>max || sootza[9]>max) {
			if ( sootza[6]>sootza[9]) {
				while ( sootza[9]< sootza[6] ) {
					sootza[9]++;
					sootza[6]--;
				}
			}
			else if ( sootza[9]>sootza[6]) {
				while ( sootza[6]< sootza[9] ) {
					sootza[6]++;
					sootza[9]--;
				}
			}
		}
		
		for( int i = 0 ; i<10 ;i++) {
			if ( sootza[i]!=0) {
			sootza[i] -= max;
			}
			//System.out.print(sootza[i]+" ");
		}//System.out.println();
		int count = 0;
		if ( sootza[6] >0 || sootza[9]>0) {
			while ( sootza[6]>0 || sootza[9] >0) {
				sootza[6]--;
				sootza[9]--;
				count++;
			}
		}
		
		result+=count;
		
		System.out.println(result);
	}
}
