package back1500;

import java.util.Scanner;

public class Main {
	static int K,S;
	static String result="";
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		S = in.nextInt();
		K = in.nextInt();
		//result = new String[K];
		DFS(0,0,0);
	}
	
	public static void DFS(int x,int len,int sum) {
		result = result.substring(0, len);
		result+=String.valueOf(x);
		if ( len == K) {
			if ( sum == S) {
			System.out.println(result+" "+sum);
			}
		}else {
			for ( int i = 1 ; i <= S ; i++) {
				if ( i+sum <= S) {
					DFS(i,len+1,sum+i);
				}
			}
		}
	}
}
