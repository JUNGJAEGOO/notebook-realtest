package back1222;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int dp[];
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int arr[] = new int[2000001];
		for ( int i = 0 ; i < N ; i++) {
			arr[Integer.parseInt(st.nextToken())]++;
			
		}
		
		int MAX = 20;
		int ans = N;
		for ( int i = 0 ; i <= MAX ; i++) {
			int cnt = 0;
			
			for ( int j = i ; j <= MAX ; j+=i) {
				cnt += arr[j]; 
				System.out.println(1);
			}
			
			if ( cnt < 2) continue;
			ans = Math.max(ans, cnt*i);
		}
		
		System.out.println(ans);
	}
	

}
