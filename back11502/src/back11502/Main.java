package back11502;

import java.util.*;

public class Main {
	static boolean prime[];
	
	public static void main (String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		prime = new boolean[1001];
		eratos();
		ArrayList<Integer> p = new ArrayList<>();
		for (int i = 2 ; i< 1001 ; i++) {
			if ( prime[i] == false) {
				p.add(i);
			}
		}
		while ( T > 0) {
			
			int n = in.nextInt();
			boolean go = true;
			lop:
			for (int i = 0 ; i < p.size() ; i++) {
				for (int j = 0 ; j < p.size() ; j++) {
					for (int k = 0 ; k < p.size() ; k++) {
						int sum = p.get(i) + p.get(j) + p.get(k);
						if ( sum == n) {
							int arr[] = new int[3];
							arr[0] = p.get(i);
							arr[1] = p.get(j);
							arr[2] = p.get(k);
							Arrays.sort(arr);
							System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
							go = false;
							break lop;
						}
					}
				}
			}
			
			if ( go ) {
				System.out.println(0);
			}
			
			T--;
		}
	}
	
	public static void eratos() {
		prime[1] = true;
		for (int i = 2 ; i < 1001 ; i++) {
			if ( prime[i] == false) {
				for (int j = i + i ; j < 1001 ; j = j + i) {
					if ( j > 1000) {
						break;
					}
					prime[j] = true;
				}
			}
		}
	}
}
