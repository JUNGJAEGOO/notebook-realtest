package back13717;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		HashMap<String,Integer> hm  = new HashMap<>();
		int ans = 0;
		int max = 0;
		int maxidx = 0;
		String maxpoke = "";
		for (int i = 0 ; i < N ; i++) {
			
			String poke = in.nextLine();
			String tmp[] = in.nextLine().split(" ");
			int info1 = Integer.parseInt(tmp[0]);
			int info2 = Integer.parseInt(tmp[1]);
			int cnt = 0;
			while ( info1 <= info2) {
				info2 -= info1;
				info2 += 2;
				cnt++;
			}
			ans += cnt;
			if ( i == 0) {
				maxidx = 0;
				max = cnt;
				maxpoke = poke;
			}else {
				if ( cnt > max ) {
					
					max = cnt;
					maxidx = i;
					maxpoke = poke;
				
				}
			}
			
		}
		
		System.out.println(ans);
		System.out.println(maxpoke);
	}
}
