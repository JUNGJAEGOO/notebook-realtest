package back15668;

import java.util.*;

public class Main {
	static boolean visit[];
	static int zari;
	static ArrayList<String> list;
	static int N;
	static int cnt=0;
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		zari = String.valueOf(N).length();
		
		visit = new boolean[10];
		list = new ArrayList<>();
		func(0,"");
		
		System.out.println(-1);
	}
	
	public static boolean check(long a,long b) {
		
		int visit[] = new int[10];
		
		char A[] = String.valueOf(a).toCharArray();
		char B[] = String.valueOf(b).toCharArray();
		
		//System.out.println(String.valueOf(A)+" "+String.valueOf(B));
		
		for ( int i = 0 ; i < A.length ; i++) {
			visit[Integer.parseInt(String.valueOf(A[i]))]++;
		}
		
		for ( int i = 0 ; i < B.length ; i++) {
			visit[Integer.parseInt(String.valueOf(B[i]))]++;
		}
		
		
		for ( int i = 0 ; i < 10 ; i++) {
			if ( visit[i] >= 2) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void func(int len,String now) {
		
		if ( !now.equals("")) {
			
			long a = Long.parseLong(now);
			long b = N - a;
			if ( a > 0 && b > 0  && check(a,b) ) {
				System.out.println(a+" "+b);
				System.out.println(cnt);
				System.exit(0);
			}
		}
		
		cnt++;
		if ( len == zari) {
			

			return;
		}else {
			
			if ( len == 0) {
				for ( int i = 1 ; i <= 9 ; i++) {
					
					if ( visit[i] == false) {
						visit[i] = true;
						func(len+1,now.concat(String.valueOf(i)));
						visit[i] = false;
					}
				}
			}else {
				for ( int i = 0 ; i <= 9 ; i++) {
					
					if ( visit[i] == false) {
						visit[i] = true;
						func(len+1,now.concat(String.valueOf(i)));
						visit[i] = false;
					}
				}
			}
	
		}
		
	}
}
