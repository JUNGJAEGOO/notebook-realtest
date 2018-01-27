package back4195;

import java.util.*;

public class Maijn {
	static int p[];
	static long count[];
	static HashMap<String,Integer> hm ;
	static StringBuilder sb;
	
	public static void main(String args[]) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		sb = new StringBuilder();
		while ( T > 0) {
			
			hm = new HashMap<>();
			int N = Integer.parseInt(in.nextLine());
			p = new int[N*2+1];
			count = new long[N*2+1];
			for (int i = 1 ; i <= N*2 ; i++) {
				p[i] = i;
				count[i] = 1;
			}
			int cnt = 1;
			
			for (int i = 0 ; i < N ; i++) {
				String tmp[] = in.nextLine().split(" ");
				String from = tmp[0];
				String to = tmp[1];
				int A = -1 ,B = -1;
				if ( !hm.containsKey(from) ) {
					hm.put(from, cnt);
					cnt++;
				}
				if ( !hm.containsKey(to) ) {
					hm.put(to, cnt);
					cnt++;
				}
				
				A = hm.get(from);
				B = hm.get(to);
								
				union(A,B);

			}
			T--;
		}
		
		System.out.print(sb);
	}
	
	public static int find(int x) {
		if ( p[x] == x) {
			return  x;
		}else {
			return p[x] = find(p[x]);
		}
	}
	
	public static void union(int x,int y) {
		int X = find(x);
		int Y = find(y);
		//System.out.println(X+" "+Y);
		if ( X == Y) {
			//System.out.println(count[X]);
			sb.append(count[X]+"\n");
			return;
		}
		p[Y] = X;
		count[X] += count[Y];
		//count[Y] = 1;
		//System.out.println(count[X]);
		sb.append(count[X]+"\n");
		//System.out.println(p[Y]+" "+X);
	}
}
