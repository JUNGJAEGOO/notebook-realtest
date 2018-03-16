package back11070;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			int N = in.nextInt();
			int M = in.nextInt();
			
			double get[] = new double[N+1];
			double lose[] = new double[N+1];
			int total[] = new int[N+1];
			double W[] = new double[N+1];
			
			
			for  (int i = 0 ; i < M ; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				long ap = in.nextLong();
				long bp = in.nextLong();
				get[a]+=ap;
				lose[a]+=bp;
				get[b]+=bp;
				lose[b]+=ap;
				
			
				total[a]++;
				total[b]++;
			}
			
			double min = Long.MAX_VALUE;
			double max = Long.MIN_VALUE;
			for ( int i = 1 ; i<=  N ; i++) {
				
				W[i] = (get[i]*get[i] / ( get[i]*get[i] + lose[i]*lose[i] ));
				W[i] *= 1000;
				
				if ( get[i] == 0 && lose[i] == 0) {
					W[i] = 0;
				}
				
				if ( W[i] > max) {
					max = W[i];
				}
				if ( W[i] < min) {
					min = W[i];
				}
			}
			
			Arrays.sort(W);
			
			System.out.println((long)W[N]+"\n"+(long)W[1]);
			
			
			T--;
		}
	}
	
	
}
