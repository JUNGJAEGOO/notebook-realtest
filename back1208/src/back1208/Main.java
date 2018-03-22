package back1208;

import java.util.*;

public class Main {
	static ArrayList<Long> sumA = new ArrayList<>();
	static ArrayList<Long> sumB = new ArrayList<>();
	static int A[],B[];
	
	public static void main(String args[]) {
		Scanner in  =new Scanner(System.in);
		int N = in.nextInt();
		int S = in.nextInt();
		if ( N%2 == 0) {
			A = new int[N/2];
			B = new int[N/2];
			for ( int i = 0 ; i < A.length ; i++) {
				A[i] = in.nextInt();
			}
			for ( int i = 0 ; i < B.length ; i++) {
				B[i] = in.nextInt();
			}
			
		}else {
			A = new int[N/2];
			B = new int[N/2+1];
			for ( int i = 0 ; i < A.length ; i++) {
				A[i] = in.nextInt();
			}
			for ( int i = 0 ; i < B.length ; i++) {
				B[i] = in.nextInt();
			}
			
		}
		
		
		
		funcA(0,0);
		Collections.sort(sumA);
		System.out.println(sumA);
		funcB(0,0);
		Collections.sort(sumB);
		System.out.println(sumB);
		
		int ans = 0;
		for ( int i = 0 ; i < sumA.size() ; i++) {
			
			int left = 0;
			int right = sumB.size()-1;
			int a = 0;
			while ( left <= right) {
				int mid = (left+right)/2;
				
				if (  sumB.get(mid) < S - sumA.get(i) ) {
					
					left = mid +1;
					
				}else {
					if ( sumB.get(mid) == S - sumA.get(i)) {
						a = mid;
					}
					right= mid -1;

					
				}
			}
			
			left = 0;
			right = sumB.size()-1;
			int b = 0;
			while ( left <= right) {
				int mid = (left+right)/2;
				
				if (  sumB.get(mid) > S - sumA.get(i) ) {
					
					right= mid -1;
				}else {
					if ( sumB.get(mid) == S - sumA.get(i)) {
						b = mid;
					}
					left = mid +1;
				}
			}
			
			System.out.println(a+" "+b);
			ans += b-a;
			
		}
		
		if ( S == 0) {
			ans--;
		}
		System.out.println(ans);
		
	}
	
	public static void funcA(int idx,long now) {

		if ( idx == A.length) {
			sumA.add(now);
			return;
		}
		
		funcA(idx+1,now+A[idx]);
		funcA(idx+1,now);
		
	}
	

	public static void funcB(int idx,long now) {

		if ( idx == B.length) {
			sumB.add(now);
			return;
		}
		
		funcB(idx+1,now+B[idx]);
		funcB(idx+1,now);	
	}
}
