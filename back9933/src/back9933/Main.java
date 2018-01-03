package back9933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		for ( int i = 0 ; i < N ; i++) {
			list.add(br.readLine());
		}
		

		
		for ( int i = 0 ; i < N ; i++) {
			char rev[] = reverse(list.get(i));
			if( String.valueOf(rev).equals(list.get(i)) ) {
				System.out.println(rev.length+" "+rev[(rev.length)/2]);
			}
			
			for ( int j = 0 ; j < N ; j++) {
				if ( i == j ) { continue; }
				if ( String.valueOf(rev).equals(list.get(j)) ) {
					System.out.println(rev.length+" "+rev[(rev.length)/2]);
					return;
				}
			}
		}
		
		
	}
	
	public static char[] reverse(String input) {
		char tmp[] = input.toCharArray();
		char reverse[] = new char[tmp.length];
		int len = tmp.length;
		for ( int i = 0 ; i < tmp.length ; i++) {
			char t = tmp[i];
			reverse[len-i-1] = t;
		}
		return reverse;
	}
}
