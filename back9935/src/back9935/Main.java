package back9935;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		//Scanner in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char input[] = in.readLine().toCharArray();
		char matcher[] = in.readLine().toCharArray();
		
		//System.out.println(String.valueOf(matcher));
		
		int N = input.length;
		
		ArrayList<Character> res = new ArrayList<>();
		
		int j = 0;
		int i = 0;
		
		//System.out.println(matcher[matcher.length-1]);
		while( true ) {
			
			//System.out.println(res);
			
			if ( input[i] != matcher[matcher.length-1]) {
				res.add(input[i]);
				i++;

			}else {
				
				res.add(input[i]);
				int start = res.size()-1;
				boolean pass = true;
	
				for ( int s = matcher.length-1 ; s >= 0 ; s--) {
					if ( start < 0) {
						pass = false;
						break;
					}
					else if ( matcher[s] == res.get(start) ) {
						
						start--;
					}else {
						pass =false;
						break;
					}
				}
				
				if ( pass ) {
					for ( int s = 0 ; s < matcher.length ; s++) {
						res.remove(res.size()-1);
					}
				}
				
				i++;

			}
			
			if ( i == N) {
				break;
			}
		}
		
		if( res.size() == 0) {
			System.out.println("FRULA");
		}else {
			for ( int s = 0 ; s < res.size() ; s++) {
				System.out.print(res.get(s));
			}
		}
		
		
	}
}
