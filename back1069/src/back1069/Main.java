package back1069;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		while ( in.hasNext() ) {
		double X = in.nextDouble();
		double Y = in.nextDouble();
		double D = in.nextDouble();
		double T = in.nextDouble();
		
		double rt = dist(X,Y);
		int c = (int)( rt / D );
		
		double res = rt;
		res = Math.min(res,rt - c*D + c*T);
		if ( c > 0) {
			res = Math.min(res, (double)c*T + T );
		}else {
			res = Math.min(res, Math.min(T*2.0,T + D - rt));
		}
			System.out.println(res);
		}
	}
	
	public static double dist(double X,double Y) {
		double D = Math.sqrt(X*X+Y*Y);
		return D;
	}
}
