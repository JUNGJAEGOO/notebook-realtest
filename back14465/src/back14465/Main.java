package back14465;

import java.util.*;

public class Main {
	static int N,K,B;
	static ArrayList<Integer> list;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		B = in.nextInt();
		
		list = new ArrayList<>();
		for ( int i = 0 ; i < B ; i++) {
			list.add(in.nextInt());
		}
		Collections.sort(list);
		
		//System.out.println(list);
		if ( list.get(0) - 1 >= K ) {
			System.out.println(0);
			return;
		}
		for ( int i = 0 ; i < list.size()-1 ; i++) {
			if ( list.get(i+1)-list.get(i) >= K ) {
				System.out.println(0);
				return;
			}
		}
		if ( N - list.get(list.size()-1) >= K ) {
			System.out.println(0);
			return;
		}
		
		node info[] = new node[N+1];
		for ( int i = 1 ; i<= N ; i++) {
			info[i] = new node();
			int up = upperbound(i);
			int low = lowerbound(i);
			info[i].upper = up;
			info[i].lower = low;
			
		}
		
		/*for ( int i = 1 ; i<= N ; i++) {
			System.out.println(i+" 의 정보 어퍼: "+info[i].upper+" 로워: "+info[i].lower);
		}*/
		
		int min = Integer.MAX_VALUE;
		for ( int i = 1 ; i<= N ; i++) {
			
			
			if ( i == 1) {
				
				int cnt = 0;
				int right = info[1].upper;
				if ( info[1].upper >= 1) {
				while ( true ) {
					int len = list.get(right) - 1;
					if ( len >= K) {
						break;
					}else {
						right++;
						cnt++;
					}
				}
				}
				min = Math.min(min, cnt);
				
			}else if ( i == N) {
				
				int cnt = 0;
				int left = info[N].lower;
				if ( info[N].lower != 0 ) {
				while ( true ) {
					int len = list.get(left) - 1;
					if ( len >= K) {
						break;
					}else {
						left--;
						cnt++;
					}
				}
				}
				min = Math.min(min, cnt);
				
				
			}else {
				
				int left = info[i].lower;
				int right = info[i].upper;
				int cnt = 0;
				
				while ( true ) {
					
					int len = list.get(right)-1 - list.get(left)+1;
					
					if ( len >= K) {
						break;
					}
					else {
						if ( left - 1 < 0 && right + 1 < list.size() ) {
							right++;
							cnt++;
							continue;
						}else if ( left -1 >= 0 && right + 1 >= list.size() ) {
							left--;
							cnt++;
							continue;
						}
						
						//System.out.println(left+" "+right);
						if ( list.get(left) - list.get(left-1) <= list.get(right+1) - list.get(right)) {
							right++;
						}else {
							left--;
						}
						cnt++;
					}
					
				}
				//System.out.println(i +". "+cnt);
				min = Math.min(min,cnt);
			}
			
		}
		
		
		System.out.println(min+1);
	}
	
	public static int lowerbound(int x) {
		int left = 0;
		int right= list.size()-1;
		int ans = 0;
		while ( left <= right) {
			int mid = (left+right)/2;
			
			if ( list.get(mid) < x) {
				left = mid + 1;
				ans = mid;
			}else {
				right = mid - 1;
			}
		}
		
		return ans;
	}
	
	public static int upperbound(int x) {
		int left = 0;
		int right= list.size()-1;
		int ans = 0;

		
		while ( left <= right) {
			
			//System.out.println(x+" "+left+" "+right);
			int mid = (left+right)/2;
			
			if ( list.get(mid) > x) {
				right = mid - 1;
				ans = mid;
			}else {
				left = mid + 1;
				
			}
		}
		
		return ans;
	}
	
	public static class node {
		int upper;
		int lower;
		
	}
}
