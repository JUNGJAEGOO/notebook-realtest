package back2263;

import java.util.*;

public class Main {
	static int inn[];
	static int pre[];
	static int post[];
	static int root;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		inn  = new int[N+1];
		post = new int[N];	
		for ( int i = 0 ; i <  N; i++) {
			int x = in.nextInt();
			inn[x] = i;
		}
		
		for ( int i = 0 ; i < N ; i++) {
			post[i] = in.nextInt();
			
		}
		
		divide(0,N-1,0,N-1);
	
	}
	
	public static void divide(int al,int ar,int bl,int br) {
		
		if (br < bl) {
			return;
		}
		System.out.print(post[br]+" ");
		
		divide(al,inn[post[br]]-1,bl,inn[post[br]] -1 - al + bl);
		divide(inn[post[br]]+1,ar,br-ar+inn[post[br]],br-1);
		
	}
}
