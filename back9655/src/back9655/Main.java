package back9655;

import java.util.Scanner;

public class Main {
	static boolean sk = false;
	static boolean visit[] = new boolean[1001];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		if ( N == 1) {
			System.out.println("SK");
			return;
		}
		if ( N == 2) {
			System.out.println("CY");
			return;
		}
		
		func(N,0);
		
		if ( sk ) {
			System.out.println("CY");
		}else {
			System.out.println("SK");
		}
	}
	
	public static void func(int now,int flag) {
		
		//System.out.println(now);
		
		if ( now == 2 && flag == 1) {
			sk = true;
			return;
		}
		
		if ( now < 1) {
			return;
		}
		
		if ( now-1 > 0 && visit[now-1] == false) {
			
			visit[now-1] = true;
			
			func(now-1,1-flag);
		}
		
		if ( now-3 > 0 && visit[now-3] == false) {
			visit[now-3] = true;
			func(now-3,1-flag);
		}
		
	}
}
