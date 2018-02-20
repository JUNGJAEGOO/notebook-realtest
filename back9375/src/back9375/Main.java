package back9375;

import java.util.*;

public class Main {
	static HashMap<String,Integer> list;
	static int cnt,n;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while ( T > 0) {
			
			list = new HashMap<>();
			n = Integer.parseInt(in.nextLine());
			for (int i = 0 ; i < n ; i++) {
				String tmp[] = in.nextLine().split(" ");
				if ( list.containsKey(tmp[1]) ) {
					list.replace(tmp[1], list.get(tmp[1])+1 );
				}else {
					list.put(tmp[1],1);
				}
			}
			
			int sum = 1;
			Iterator itr = list.keySet().iterator();
			while ( itr.hasNext() ) {
				String key = (String)itr.next();
				sum *= (list.get(key)+1);
			}
			System.out.println(sum-1);
			T--;
		}
	}
	
	
	public static class node{
		String sort;
		String cloth;
		node(String sort,String cloth){
			this.sort =sort;
			this.cloth = cloth;
		}
	}
}
