package back4921;

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		int cnt = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while ( true) {
			
			
			String input = br.readLine();
			if ( input.equals("0") ) {
				break;
			}
			
			if ( pandan(input) ) {
				System.out.println(cnt+". VALID");
			}else {
				System.out.println(cnt+". NOT");
			}
			cnt++;
		}
	}
	
	public static boolean pandan(String input) {
		char N[] = input.toCharArray();
		int len = N.length;
		//System.out.println(N[0]);
		if ( N[0] != '1' ) {
			//System.out.println("hihi");
			return false;
		}
		if (  N[len-1] != '2') {
			//System.out.println("hi");
			return false;
		}
		
		if (len ==1 ||  len == 2) {
			return false;
		}
		
		for (int i = 1 ; i < len-1 ; i++) {
			if ( N[i] == '1' || N[i] =='2') {
				return false;
			}
			if ( N[i-1] == '1') {
				if ( N[i] == '4' || N[i] == '5') {
					
				}else {
					return false;
				}
			}else if ( N[i-1] == '3') {
				if ( N[i] == '4' || N[i] == '5') {
					
				}else {
					return false;
				}
			}else if ( N[i-1] == '4') {
				if ( N[i] == '3' || N[i] == '2') {
					
				}else {
					return false;
				}
				
			}else if ( N[i-1] == '5') {
				if ( N[i] == '8' ) {
					
				}else { 
					return false;
				}
				
			}else if ( N[i-1] == '6') {
				if ( N[i] == '3' || N[i] == '2') {
					
				}else {
					return false;
				}
			}else if ( N[i-1] == '7') {
				if ( N[i] == '8') {
					
				}else {
					return false;
				}
			}else if ( N[i-1] == '8') {
				if ( N[i] == '6' || N[i] == '7') {
					
				}else {
					return false;
				}
			}
			
			if ( i == len-2) {
				//System.out.println("hi");
				if ( N[i] == '6' || N[i] == '4' ) {
					
				}else {
					return false;
				}
			}
		}
		
		
		return true;
	}
}
