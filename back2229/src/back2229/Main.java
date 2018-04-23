package back2229;

import java.util.*;

public class Main {
	static int N;
	static int arr[];
	static int dp[];
	static int mintree[];
	static int maxtree[];
	static int mininf = 1000000000;
	static int maxinf = -1000000000;
	
	public static int maxinit(int node,int start,int end) {
		if ( start == end) {
			return maxtree[node] = arr[start]; 
		}else {
			return maxtree[node] = Math.max(maxinit(node*2,start,(start+end)/2), maxinit(node*2+1,(start+end)/2+1,end));
		}
	}
	
	public static int MAX(int node,int left,int right,int start,int end) {
		if ( left > end || right < start) {
			return maxinf;
		}
		if ( left <= start && end <= right ) {
			return maxtree[node];
		}
		
		return Math.max(MAX(node*2,left,right,start,(start+end)/2),MAX(node*2+1,left,right,(start+end)/2+1,end));
	}
	
	public static int mininit(int node,int start,int end) {
		if ( start == end) {
			return mintree[node] = arr[start]; 
		}else {
			return mintree[node] = Math.min(mininit(node*2,start,(start+end)/2), mininit(node*2+1,(start+end)/2+1,end));
		}
	}
	
	public static int MIN(int node,int left,int right,int start,int end) {
		if ( left > end || right < start) {
			return mininf;
		}
		if ( left <= start && end <= right ) {
			return mintree[node];
		}
		
		return Math.min(MIN(node*2,left,right,start,(start+end)/2),MIN(node*2+1,left,right,(start+end)/2+1,end));
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		int H = (int)Math.ceil(Math.log(N)/Math.log(2));
		//System.out.println(1<<H);
		mintree = new int[1<<(H+1)];
		maxtree = new int[1<<(H+1)];
		
		maxinit(1,0,N-1);
		mininit(1,0,N-1);
		
		/*for ( int i = 0 ; i < 3 ; i++) {
			int left = in.nextInt();
			int right = in.nextInt();
			
			System.out.println(MAX(1,left-1,right-1,0,N-1));
			System.out.println(MIN(1,left-1,right-1,0,N-1));
		}*/
		
		dp = new int[1001];
		for ( int i = 0 ; i < 1001 ; i++) {
		
			dp[i] = -1;
			
		}
		
		/*for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= i ; j++) {
				int min = MIN(1,j-1,i-1,0,N-1);
				int max = MAX(1,j-1,i-1,0,N-1);
				//System.out.println(j+" to "+i+" "+max+" "+min);
				dp[i] = Math.max(dp[i], dp[j-1] + max-min);
			}
		}*/
		
		
		
		//System.out.println(dp[N]);
		
		func(0);
		
		int max = -1;
		for ( int i = 0 ; i < 1001 ; i++) {
			max = Math.max(max,dp[i]);
			//System.out.print(dp[i]+" ");
		}//System.out.println();
		System.out.println(max);
	}
	
	public static int func(int idx) {
		
		if ( idx > N) {
			return 0;
		}
		
		int ret = dp[idx];
		if (ret != -1) {
			return ret;
		}
		ret = 0;
		
		for ( int i = 0 ; i < N ; i++) {
			
			if ( idx + i <= N) {
				
				int min = MIN(1,idx-1,idx+i-1,0,N-1);
				int max = MAX(1,idx-1,idx+i-1,0,N-1);
				System.out.println(idx+" to "+(idx+i)+" : "+min+" "+max);
				ret = Math.max(ret, max-min+func(idx+i+1));
				
			}
			
		}
		
		return dp[idx] = ret;
		
	}
	

}
