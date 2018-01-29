package back10816;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		HashMap<Integer,Integer> hm  =new HashMap<>();
		for (int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			if ( hm.get(x) == null) {
				hm.put(x, 1);
			}else {
				int v = hm.get(x);
				hm.replace(x, v+1);
			}
		}
		int M = in.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int j= 0; j < M ; j++) {
			int want = in.nextInt();
			if ( hm.get(want) == null) {
				sb.append(0+" ");
			}else {
				sb.append(hm.get(want)+" ");
			}
			
		}
		System.out.println(sb);
	}
}
