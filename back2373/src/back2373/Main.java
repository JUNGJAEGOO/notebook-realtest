package back2373;

import java.util.Scanner;

public class Main {
	static int N;
	static int ans = 100000000;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		func('B',N,0,0,0,0);
		System.out.println(ans);
	}
	
	public static void func(char before,int sum,int beforeA,int beforeB,int A,int first) {
		
		System.out.println(before+" "+sum);
		
		if ( A > ans) {
			return;
		}
		
		if ( sum < 0 ) {
			return;
		}
		
		if ( sum == 0 && before == 'A' ) {
			System.out.println("A의 수: "+A+" 처음 "+first);
			if ( first < ans) {
				ans = first;
			}
			return;
		}
		
		if ( sum == 0 && before == 'B') {
			return;
		}
		
		if ( before == 'B') {
			if ( beforeB == 0) {
				for (int i = 1 ; i < sum  ; i++) {
					func('A',sum-i,i,beforeB,A+i,i);
				}
			}else {
				for (int i = 1 ; i <= 2*beforeB  ; i++) {
					func('A',sum-i,i,beforeB,A+i,first);
				}
			}
			
		}else {
			for (int i = 1 ; i <= 2*beforeA  ; i++) {
				func('B',sum-i,beforeA,i,A,first);
			}
			
		}
		
	}
}
