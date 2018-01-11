package back9935;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		//Scanner in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char input[] = in.readLine().toCharArray();
		String pattern = in.readLine();
		Stack<Character> st = new Stack<Character>();
		Stack<Character> tmp = new Stack<Character>();
		int Plength = pattern.length();
		int Inlength = input.length;
		
		for ( int i = Inlength - 1 ; i >= 0 ; i--) {
		
			st.push(input[i]);
			String temp ="";
			
			if ( st.size() >= Plength ) {
				
				for ( int j = 0 ; j < Plength ; j++) {
					//System.out.println(st.get(st.size()-j-1));
					temp += st.get(st.size()-j-1);
				}

				if ( temp.equals(pattern) ) {
					for ( int j = 0 ; j < Plength ; j++) {
						//st.add(temp.charAt(j));
						st.pop();
						//st.remove(n-j-1);
					}
				}
			}
		
		}
		
		int size = st.size();
		if ( size == 0) {
			System.out.println("FRULA");
		}
		StringBuilder sb= new StringBuilder();
		for ( int i = 0 ; i < size ; i++) {
			sb.append(st.get(size-i-1));
		}
		System.out.println(sb);
		
		
	}
}
