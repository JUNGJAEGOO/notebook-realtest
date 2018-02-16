package back1644;

import java.util.*;

public class Main {
	static ArrayList<Integer> prime = new ArrayList<>();
	static boolean isPrime[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		isPrime = new boolean[4000001];
		eratos();
		
		long sum = 2;
		int left = 0;
		int right = 0;
		int ans = 0;
		while ( true) {
			
			
			if ( sum >= N) {
				if ( sum == N) {
					//System.out.println(left+" "+right);
					ans++;
				}
				sum -= prime.get(left);
				left++;
				
			}else {
				right++;
				if ( right > prime.size()-1) {
					break;
				}
				sum += prime.get(right);
			}
			if ( left > prime.size()-1) {
				break;
			}
			
			//System.out.println(sum+" "+left+","+right);
			
		}
		System.out.println(ans);
	}
	
	public static void eratos() {
		isPrime[1] = true;
		for (int i = 2 ; i < 4000001 ; i++) {
			if ( isPrime[i] == false) {
				prime.add(i);
				for (int j = i + i ; j < 4000001 ; j = j + i) {
					isPrime[j] = true;
					if ( j > 4000000) {
						break;
					}
				}
			}
		}
	}
}
