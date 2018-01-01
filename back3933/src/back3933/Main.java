package back3933;

import java.util.Scanner;

public class Main {
	static int pow[];
	static int ret;
	static int index;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		

		while( true ) {
			int N = in.nextInt();
			if ( N == 0) {
				break;
			}
			pow = new int[N+1];
			index=1;
			for ( int i = 1 ; i*i <= N ; i++) {
				pow[index++] = i*i;
			}
			
			ret = 0;
			func(N,0,1);
			System.out.println(ret);
			
		}
	}
	
	public static void func(int sum,int visit,int idx) {
		//System.out.println(sum+","+visit+","+idx);
		if ( sum < 0 || visit > 4) {
			return;
		}
		
		if ( sum == 0) {

			ret++;
			return;
			
		}

		for ( int i = idx ; i < index ; i++ ) {
				func(sum-pow[i],visit+1,i);
			
		}
		
		//System.out.println("ret is "+ret);
		
	}
}
