package back14670;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		HashMap<Integer,Integer> hm = new HashMap<>();
		for ( int i = 0 ; i < N ; i++) {
			int key = in.nextInt();
			int value = in.nextInt();
			hm.put(key, value);
		}
		
		
		int M = in.nextInt();
		ArrayList<Integer> res[] = new ArrayList[M+1];
		for ( int i = 0 ; i < M+1 ; i++) {
			res[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < M ; i++) {
			
			int n = in.nextInt();
			boolean pass = true;
			for ( int j = 0 ; j < n ; j++) {
				
				int find = in.nextInt();
				//System.out.println(find+" "+hm.get(find));
				if ( hm.get(find) != null ) {
					res[i].add(hm.get(find));
				}else {
					pass = false;
				}
				
			}
			
			if ( pass == false) {
				res[i] = new ArrayList<>();
			}
			
		}
		
		for ( int i = 0 ; i < M ; i++) {
			if ( res[i].size() == 0) {
				System.out.println("YOU DIED");
			}else {
				for ( int j = 0 ; j < res[i].size() ; j++) {
					System.out.print(res[i].get(j)+" ");
				}System.out.println();
			}
		}
	}
}
