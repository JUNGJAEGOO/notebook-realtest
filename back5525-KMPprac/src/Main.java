import java.io.*;

public class Main {
	static int length;
	static int res = 0;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String input = br.readLine();
		String pattern = "IOI";
		
		length = input.length();
		int[] fail =  makefail("ababaca");

		for (int i = 0 ; i < fail.length ; i++) {
			System.out.println(fail[i]+" ");
		}
		
		KMP(input,pattern);
		
		System.out.println(res);
	}
	
	public static void KMP(String input,String pattern) {
		int[] fail =  makefail("BAABABAA");
		char[] in = input.toCharArray();
		char[] pat = pattern.toCharArray();
		int i = 0,j = 0;
		while ( i < in.length ) {
			if ( in[i] == pat[j]) {
				if ( j == pat.length-1 ) {
					
					res++;
					//System.out.println(i+"에서 1 증가");
					//i++;
					j = fail[j];
				}else {
					i++;
					j++;
				}
			}else if ( j > 0){
				j = fail[j-1];
			}else {
				i++;
			}
		}
	}
	
	public static int[] makefail(String pattern) {
		int end = pattern.length();
		int start = 0;
		char[] p;
		int[] fail = new int[end];
		p = pattern.toCharArray();

		
		for ( int i = 1 ; i < p.length; i++) {
			while ( start > 0 && p[i] != p[start]) {
				start = fail[start-1];
			}
			if ( p[i] == p[start]) {
				fail[i] = ++start;
			}
		}
		
		return fail;
	}
}
