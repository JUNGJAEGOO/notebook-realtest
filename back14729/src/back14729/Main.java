package back14729;
import java.io.*;
import java.util.Arrays;
public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		float arr[] = new float[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Float.parseFloat(br.readLine());
		}
		
		int count = 0;
		Arrays.sort(arr);
		for ( int i = 0 ; i < 7 ; i++) {
			System.out.format("%.3f\n", arr[i]);
		}
		
	}
}
