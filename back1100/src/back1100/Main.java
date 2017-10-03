package back1100;
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String args[]) throws IOException {
		
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char chess[][] = new char[8][8];
		
		StringTokenizer st;
		
		for ( int count = 0 ; count < 8 ; count++) {
			String tmp = br.readLine();
			st = new StringTokenizer(tmp," ");
			for ( int i = 0 ; i < 8 ; i++) {
				chess[count][i] = st.nextToken().charAt(0);
			}
			

			
		}
		
		int result = 0;
		for ( int i = 0 ; i < 8 ; i+=2) {
			for ( int j = 0 ; j < 8 ; j+=2) {
				if ( chess[i][j] == 'F') {
					result++;
				}
			}
		}
		
		for ( int i = 1 ; i < 8 ; i+=2) {
			for ( int j = 1 ; j < 8 ; j+=2) {
				if ( chess[i][j] == 'F') {
					result++;
				}
			}
		}
		System.out.println(result);
		
		
	}
}
