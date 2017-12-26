package back1305;

import java.io.*;
import java.util.*;

public class Main {
	static char patterns[][];
	static char origins[][];
	static ArrayList<Integer> list;
	public static void main (String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int hp = Integer.parseInt(st.nextToken());
		int wp = Integer.parseInt(st.nextToken());
		int hm = Integer.parseInt(st.nextToken());
		int wm = Integer.parseInt(st.nextToken());
		int stan = hp * wp;
		int res = 0;
		patterns = new char[hp][wp];
		origins = new char[hm][wm];
		for ( int i = 0 ; i < hp ; i++) {
			char tmp[] = br.readLine().toCharArray();
			for ( int j = 0 ; j < wp ; j++) {
				patterns[i][j] = tmp[j]; 
			}
		}
		
		for ( int i = 0 ; i < hm ; i++) {
			char tmp[] = br.readLine().toCharArray();
			for ( int j = 0 ; j < wm ; j++) {
				origins[i][j] = tmp[j]; 
			}
		}
		
		String first = "";
		for (int i = 0 ; i < patterns[0].length ; i++) {
			first += patterns[0][i];
		}
		
		int fail[] = make(first);
		
		for ( int i = 0 ; i < hm ; i++) {
			list = new ArrayList<Integer>();
			String now = "";
			for (int j = 0 ; j < origins[i].length ; j++) {
				now += origins[i][j];
			}
			KMP(fail,now,first);

			
			for ( int s = 0 ; s < list.size() ; s++) {
				int col = list.get(s);
				//System.out.println(i+"행 "+col);
				int sum = 0;
				lop:
				for ( int k = i+1 ; k < i+hp ; k++) {
					for ( int t = col ; t < col+wp ; t++) {
						//System.out.println(k+","+t);
						if ( k >= hm || t >= wm ) {
							break lop;
						}
						if ( patterns[k-i][t-col] != origins[k][t]) {
							break lop;
						}
						sum++;
					}
				}
				
				if ( sum == (hp-1)*wp) {
					res++;
				}
				
			}
		}
		
		System.out.println(res);
		
		
	}
	
	public static void KMP(int fail[],String str,String pattern) {
		char[] st = str.toCharArray();
		char[] pat = pattern.toCharArray();
		int j = 0 ; 
		for ( int i = 0 ; i < st.length ; i++ ) {
			while ( j > 0  && pat[j] != st[i]) {
				j = fail[j-1];
			}
			if ( pat[j] == st[i]) {
				if ( j == pat.length-1) {
					list.add(i-j);
					j = fail[j];
				}else {
					j++;
				}
			}
		}
	}
	
	
	public static int[] make(String pattern) {
		char p[] = pattern.toCharArray();
		int fail[] = new int[p.length];
		int j = 0;
		for ( int i = 1 ; i < p.length; i++) {
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
