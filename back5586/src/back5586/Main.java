package back5586;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String pattern1 = "JOI";
		String pattern2 = "IOI";
		
		int res1 = 0;
		int res2 = 0;
		
		int[] failIOI = make(pattern2);
		int[] failJOI = make(pattern1);
		
		res1 = KMP(input,pattern2,failIOI);
		res2 = KMP(input,pattern1,failJOI);
		
		System.out.println(res2+"\n"+res1);
		
	}
	
	public static int KMP(String input,String pattern,int[] fail) {
		
		char p[] = pattern.toCharArray();
		char str[] = input.toCharArray();
		int ans = 0;
		int j = 0;
		for ( int i = 0 ; i < str.length ; i++ ) {
			while ( j > 0  && str[i] != p[j]) {
				j = fail[j-1];
			}
			if ( str[i] == p[j]) {
				if ( j == p.length - 1) {
					j = fail[j];
					ans++;
				}else {
					j++;
				}
			}
		}
		
		return ans;
		
	}
	
	public static int[] make(String pattern) {
		char[] p = pattern.toCharArray();
		int[] fail = new int[pattern.length()];
		
		int j = 0;
		for ( int i = 1 ; i < p.length ; i++) {
			while ( j > 0 && p[i] != p[j]) {
				j = fail[j-1];
			}
			if ( p[i] == p[j]) {
				fail[i] = ++j;
			}
		}
		
		
		return fail;
	}
}
