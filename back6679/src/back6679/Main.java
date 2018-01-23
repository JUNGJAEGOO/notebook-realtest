package back6679;

import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		for (int i = 1000 ; i<= 9999 ; i++) {
			//System.out.println(ten(i)+" "+twelve(i)+" "+sixteen(i));
			if ( ten(i) == twelve(i) && twelve(i) == sixteen(i) ) {
				System.out.println(i);
			}
		}
	}
	public static int ten(int x) {
		char[] now = String.valueOf(x).toCharArray();
		int sum = 0;
		for (int i = 0 ; i < now.length ; i++) {
			sum += Integer.parseInt(String.valueOf(now[i]));
		}
		return sum;
	}
	public static int twelve(int x) {
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while ( true) {
			if ( x/12 != 0) {
				list.add(x%12);
				x /= 12;
			}else {
				list.add(x%12);
				break;
			}
		}
		for  (int i = 0 ; i < list.size() ; i++) {
			sum += list.get(i);
		}
		return sum;
	}
	public static int sixteen(int x) {
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while ( true) {
			if ( x/16 != 0) {
				list.add(x%16);
				x /= 16;
			}else {
				list.add(x%16);
				break;
			}
		}
		for  (int i = 0 ; i < list.size() ; i++) {
			sum += list.get(i);
		}
		return sum;
	}
}
