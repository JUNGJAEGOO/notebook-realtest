package back1550;
import java.io.*;
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char input[] = br.readLine().toCharArray();
		
		int len = input.length-1;
		int max = len;
		long result = 0;
		while ( len >= 0) {
			long x;
			
			if ( input[len] == 'A') {
				x = 10;
			}else if ( input[len] == 'B') {
				x = 11;
			}else if ( input[len] == 'C') {
				x = 12;
			}else if ( input[len] == 'D') {
				x = 13;
			}else if ( input[len] == 'E') {
				x = 14;
			}else if ( input[len] == 'F') {
				x = 15;
			}else {
				x = Integer.parseInt(String.valueOf(input[len]));
			}
			System.out.println(x+" "+(max-len));
			result = (int) (result + ( x * Math.pow(16, max-len) ) );
			len--;
		}
		
		System.out.println(result);
	}
}
