package back2331;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		long N = in.nextLong();
		int P = in.nextInt();
		
		ArrayList<Long> hs = new ArrayList<>();
		hs.add(N);
		
		int ans = 0;
		while( true) {
			
			String tmp[] = String.valueOf(hs.get(hs.size()-1)).split("");
			long sum = 0;
			for (int i = 0 ; i < tmp.length ; i++) {
				sum += Math.pow(Integer.parseInt(tmp[i]),P);
			}
			if ( hs.contains(sum) ) {
				for (int i= 0 ; i < hs.size() ; i++) {
					if ( sum == hs.get(i) ) {
						ans = i;
					}
				}
				break;
			}else {
				hs.add(sum);
			}
		}
		//System.out.println(hs.get(ans));
		System.out.println(ans);
		
	}
}
