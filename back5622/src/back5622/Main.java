package back5622;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] now = in.nextLine().toCharArray();
		
		int sum = 0;
		
		HashMap<Character,Integer> hm = new HashMap<>();
		hm.put('A', 3);
		hm.put('B', 3);
		hm.put('C', 3);
		
		hm.put('D', 4);
		hm.put('E', 4);
		hm.put('F', 4);
		
		hm.put('G', 5);
		hm.put('H', 5);
		hm.put('I', 5);
		
		hm.put('J', 6);
		hm.put('K', 6);
		hm.put('L', 6);
		
		hm.put('M', 7);
		hm.put('N', 7);
		hm.put('O', 7);
		
		hm.put('P', 8);
		hm.put('Q', 8);
		hm.put('R', 8);
		hm.put('S', 8);
		
		hm.put('T', 9);
		hm.put('U', 9);
		hm.put('V', 9);
		
		hm.put('W', 10);
		hm.put('X', 10);
		hm.put('Y', 10);
		hm.put('Z', 10);
		
		
		for ( int i = 0 ; i < now.length ; i++) {
			sum += hm.get(now[i]);
		}
		
		System.out.println(sum);
	}
}
