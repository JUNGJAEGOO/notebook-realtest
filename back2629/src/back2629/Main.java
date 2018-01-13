package back2629;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M;
	static char res[];
	static int choo[];
	static int dp[][];
	static int x;
	static boolean checksum[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		choo = new int[N];
		
		for ( int i = 0 ; i  < N ; i++) {
			choo[i] = in.nextInt();
		}
		M = in.nextInt();
		int ball[] = new int[M];
		for ( int i = 0 ; i  < M ; i++) {
			ball[i] = in.nextInt();
		}
		
		res = new char[M];
		Arrays.fill(res, 'N');
		
		dp = new int[31][30*500+1];  
		for ( int t = 0 ; t <= 30 ; t++) {
			for ( int z = 0 ; z <= 30*500 ; z++) {
				dp[t][z] = -1;
			}
		}
		
		for ( int i = 0 ; i < 1 ; i++) {
			
			x = 0;
			checksum = new boolean[55000*2+1];
			
			func(55000+ball[i],new ArrayList<Integer>());

			if ( x == 1) {
				res[i] = 'Y';
			}
			
		}
		
		for ( int i = 0 ; i < 1 ; i++) {
			System.out.print(res[i]+" ");
		}
		
	}
	
	public static void func(int sum,ArrayList<Integer> checkidx) {
		if ( checkidx.size() == N) {
			System.out.println(sum+" "+checkidx);
		}
		if ( checksum[sum] == false) {
			checksum[sum] = true;
		}else {
			return;
		}
		
		if ( sum == 55000) {
			x = 1;
			return;
		}
		
		for ( int i = 0 ; i < N ; i++) {
			if ( !checkidx.contains(i) ) {
				checkidx.add(i);
					func(sum+choo[i],checkidx);  // 우
					func(sum-choo[i],checkidx);  // 좌
				checkidx.remove(checkidx.size()-1);
			}
		}
		
	
	}
}
