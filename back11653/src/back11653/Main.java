package back11653;

import java.util.*;

public class Main {
	static boolean prime[];
	static ArrayList<Integer> list = new ArrayList<>();
	static ArrayList<Integer> ps = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		prime = new boolean[10000001];
		eratos();
		
		int cnt = 0;
		while ( true) {
			
			if ( N % ps.get(cnt) == 0) {
				N /= ps.get(cnt);
				list.add(ps.get(cnt));
			}else {
				cnt++;
			}
			
			if ( N == 1) {
				break;
			}
		}
		
		for (int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	public static void eratos() {
		prime[1] = true;
		for (int i = 2 ; i <= 10000000 ; i++) {
			if ( prime[i] == false ) {
				ps.add(i);
				for (int j = i + i ; j <= 10000000 ; j = j + i) {
					if ( j > 10000000 ) {
						break;
					}
					prime[j] = true;
				}
			}
		}
	}
}
