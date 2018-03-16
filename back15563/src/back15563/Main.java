package back15563;

import java.util.*;

public class Main {
	static ArrayList<Integer> list;
	static int p[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Q = in.nextInt();
		p = new int[N];
		for (int i = 0 ; i < N-1 ; i++) {
			int x = in.nextInt();
			p[i] = x;
		}
		
		list = new ArrayList<>();
		
		for ( int i = 0 ; i < Q ; i++) {
			int c = in.nextInt();
			if ( c == 1) {
				int x = in.nextInt();
				if ( list.size() == 0) {
					list.add(x);
					continue;
				}
				int left = 0;
				int right = list.size()-1;
				int ans = 0;
				while ( left <= right) {
					int mid = (left + right) / 2 ;
					
					if ( list.get(mid) <= x ) {
						left = mid + 1;
						ans = mid;
					}else {
						right = mid - 1;
					}
					
				}
				//System.out.println((ans+1)+" 에 "+ x +"추가");
				list.add(ans+1, x);
				//System.out.println(list);
				
			}else {
				int x = in.nextInt();
				if (list.size() == 0) {
					System.out.println(-1);
					continue;
				}
				if ( list.size() == 1) {
					System.out.println(Math.abs(x-list.get(0)));
					continue;
				}
				int left = 0;
				int right = list.size()-1;
				int ans = 0;
				while ( left <= right) {
					int mid = (left + right) / 2 ;
					
					if ( list.get(mid) <= x ) {
						left = mid + 1;
						ans = mid;
					}else {
						right = mid - 1;
					}
				
				}
				//System.out.println("ans: "+ans);
		
				//System.out.println(x+"는 "+list.get(ans)+"("+ans+") 보다 작음");
				if ( ans == list.size()-1) {
					System.out.println(Math.abs(list.get(list.size()-1) - x));
					continue;
				}
				int candi1 = list.get(ans);
				int candi2 = list.get(ans+1);
				if ( Math.abs(x - candi1) <= Math.abs(x - candi2) ) {
					System.out.println(Math.abs(x - candi1));
				}else {
					System.out.println(Math.abs(x - candi2));
				}
			}
		}

	}
}
