import java.util.*;

public class Main {
	static int p[];
	static int cnt[];
	static int isp[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		p = new int[N+1];
		cnt = new int[N+1];
		isp = new int[N+1];
		for (int i = 0 ; i <= N ; i++) {
			p[i] = i;
			isp[i] = 1;
			cnt[i] = 1;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < N-1 ; i++) {
			
			int x = in.nextInt();
			merge(x,x+1);
			//System.out.println(cnt[x]);
			
			long sum = 0;
			long rotate = 0;

			for (int j = 1 ; j <= N ; j++) {
				if ( isp[j] == 1) {
					int tmp = cnt[j]-1;
					rotate += tmp * ( tmp + 1) / 2;
					sum += ( tmp * ( (tmp*tmp) + (3*tmp) + (4) ) )/ 6;
				}
			}
			sb.append(rotate+" "+sum+"\n");
		}
		Syst
		
		
	}
	
	public static int find(int x) {
		if ( p[x] == x) {
			return x;
		}else {
			return p[x] = find(p[x]);
		}
		
	}
	
	public static void merge(int a,int b) {
		int x = find(a);
		int y = find(b);
		if ( x == y) {
			return;
		}else {
			p[y]= x;
			isp[x] = 1;
			isp[y] = 0;
			cnt[x] += cnt[y];
			cnt[y] = 0;
			
		}
	}
}
