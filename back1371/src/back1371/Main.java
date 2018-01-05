package back1371;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		// a는 97 z 는 122
		
		int arr[] = new int[123];
		
		while ( in.hasNext() ) {
			char tmp[] = in.nextLine().toCharArray();
			
			if ( tmp[0] == 'A') {
				break;
			}
			
			for ( int i = 0 ; i < tmp.length ; i++) {
				arr[tmp[i]+0]++;
			}
			
			
			
		}
		
		int maxidx = 97;
		ArrayList<Character> list = new ArrayList<>();
		
		for ( int i = 97 ; i <= 122 ; i++) {
			//System.out.print(arr[i]+" ");
			if ( arr[i] > arr[maxidx]) {
				list = new ArrayList<>();
				maxidx = i;
				list.add((char)i);
			}else if ( arr[i] == arr[maxidx]) {
				list.add((char)i);
			}
		}
		
		Collections.sort(list);
		for ( int i = 0 ; i < list.size() ; i++) {
			System.out.print(list.get(i));
		}
		
	}
}
