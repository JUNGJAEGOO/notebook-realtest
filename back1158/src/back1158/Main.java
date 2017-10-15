package back1158;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int result[] = new int[N];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for ( int i = 1 ; i <= N ; i++) {
			list.add(i);
		}
		
	

		int index = -1;
		int cycle = 0;
		while ( cycle <= N-1) {
			
			int count = 0;
			while ( count < M) {
				index++;
				if( index > N-1 ) { index%=N;}
				if ( list.get(index) != -1) {
					count++;
				}
				
			}
			
			result[cycle] = list.get(index);
			list.set(index, -1);
			cycle++;
			
		}


		System.out.print("<");
		for(int i = 0 ; i < N ; i++) {
			if ( i == N-1 ) {
				System.out.print(result[i]);	
			}else {
			System.out.print(result[i]+", ");
			}
		}
		System.out.println(">");
	}
}
