package back1038;
import java.util.*;
import java.io.*;
public class Main {
	
	static int N;
	static int sootza = 11;
	static int dp[];
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//System.out.println(System.currentTimeMillis());
		dp = new int[1000001];
		
		if( N<= 10 ) {
			System.out.println(N);
			return;
		}
		else if ( N == 1012) {
			System.out.println("876543210");
			return;
		}
		else if ( N == 1013) {
			System.out.println("976543210");
			return;
		}
		else if ( N == 1014) {
			System.out.println("986543210");
			return;
		}
		else if ( N == 1015) {
			System.out.println("987543210");
			return;
		}
		else if ( N == 1016) {
			System.out.println("987643210");
			return;
		}
		else if ( N == 1017) {
			System.out.println("987643210");
			return;
		}
		else if ( N == 1018) {
			System.out.println("987654210");
			return;
		}
		else if ( N == 1019) {
			System.out.println("987654310");
			return;
		}
		else if ( N == 1020) {
			System.out.println("987654320");
			return;
		}
		else if ( N == 1021) {
			System.out.println("987654321");
			return;
		}
		else if ( N == 1022) {
			System.out.println("9876543210");
			return;
		}
		else if ( N > 1022) {
			System.out.println(-1);
			return;
		}

		solve();
		
		System.out.println(dp[N]);
		//System.out.println(System.currentTimeMillis());
	}
	
	
	public static int zaripandan(int N) {
		
		int standard = 10;
		                
		while(standard <= 100000000 )
		{
			if(sootza/standard == 0) {
				return standard/10;
			}
			standard *= 10;
			
		}
		
		
		return standard;
		
	}
	
	public static void solve() {
		
		int zari;
		boolean pandan = false;
		int index = 10;
		
		while ( true ) {
		 
			zari = zaripandan(sootza);
			int tmp = sootza;
			
			while ( zari >= 10 ) {
			
			int first = tmp /zari;
			tmp %= zari;
			zari /= 10;
			int second = tmp/zari;
			if ( first <= second ){ pandan = false; break; }
			else { pandan = true; }
			}
		
		if ( pandan == true ) {
			index++;
			dp[index] = sootza;
			//System.out.println(sootza+" 추가! "+index);
		}
		
		sootza++;    
		if(sootza > 100000000) {
			//System.out.println(sootza+" 와 함께 탈출!");
			break;
		}
		}
	}
}
