package back2515;

import java.util.*;

public class Main {
	static int N,S;
	static LinkedList<node> info;
	static int dp[];

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		S = in.nextInt();
		info = new LinkedList<>();
		for (int i = 0 ; i < N ; i++) {
			
			info.add(new node(in.nextInt(),in.nextInt()));
		}
		Collections.sort(info);
		/*for (int i = 0 ; i < N ; i++) {
			System.out.println(info.get(i).high+" "+info.get(i).cost);
		}*/
		dp = new int[20000001];
		Arrays.fill(dp, -1);
		
		System.out.println(func(0));
	}
	
	public static int func(int len) {
		
		//System.out.println(len+" "+h);
		
		if ( len == N) {
			return 0;
		}
		
		int ret = dp[len];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		ret = Math.max(ret, func(len+1));
		
		int idx = 0;
		int left = 0;
		int right = N-1;
		int mid;
		while ( left <= right) {
			mid = (left+right)/2;
			
			if ( info.get(mid).high-S >= info.get(len).high) {
				idx = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
			
			
		}
		
		System.out.println(len+" "+idx);
		
		ret = Math.max(ret, info.get(idx).cost+func(len+1));
		
		
		return dp[len] = ret;
	}
	
	static class node implements Comparable<node>{
		int high;
		int cost;
		@Override
		public int compareTo(node o) {
			if ( this.high > o.high) {
				return 1;
			}
			return -1;
		}
		node(int high,int cost){
			this.high = high;
			this.cost = cost;
		}

	}
}
