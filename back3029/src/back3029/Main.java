package back3029;

import java.util.*;

public class Main {
	public static void main(String ars[]) {
		Scanner in = new Scanner(System.in);
		String first[] = in.nextLine().split(":");
		String two[] = in.nextLine().split(":");
		
		int H = Integer.parseInt(first[0]);
		int M = Integer.parseInt(first[1]);
		int S = Integer.parseInt(first[2]);
		
		int h = Integer.parseInt(two[0]);
		int m = Integer.parseInt(two[1]);
		int s = Integer.parseInt(two[2]);
		
		int X = H*3600 + M*60 + S;
		int Y = h*3600 + m*60 + s + 3600*24;
		
		int ans = (Y-X)%(3600*24);
		int ansH = ans/3600;
		ans -= 3600*ansH;
		int ansM = ans/60;
		ans -= 60*ansM;
		
		if ( ans == ansH && ansH == ansM && ansM == 0) {
			ansH = 24;
			ans = 0;
			ansM = 0;
		}
		
		System.out.format("%02d:%02d:%02d", ansH,ansM,ans);
		
	}
}
