package back10984;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			int N = in.nextInt();
			double boonmo = 0;
			double boonza = 0;
			for (int i = 0 ; i <  N ; i++) {
				double tmp = in.nextDouble();
				boonmo += tmp;
				double tmptmp = in.nextDouble();
				tmptmp *= tmp;
				boonza += tmptmp;
			}
			
			System.out.print((int)boonmo+" ");
			System.out.format("%.1f\n",boonza/boonmo);
			
			
			
			
			
			T--;
		}
	}
}
