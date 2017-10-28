package back1546;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		int N  = in.nextInt();
		double max = -1;
		double result = 0;
		double arr[] = new double[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextFloat();
			max = Math.max(max, arr[i]);
		}
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = (arr[i] / max) * 100;

		}
		
		for ( int i = 0 ; i < N ; i++) {
			result += arr[i];
		}

		result /= N;

		
		int tmp = (int)result;
		double tmp2 = result - tmp;
		tmp2 = Math.round(tmp2*100);
		tmp2 = tmp2/100;
		result = tmp+tmp2;
		
		System.out.format("%.2f", result);
	}
}
