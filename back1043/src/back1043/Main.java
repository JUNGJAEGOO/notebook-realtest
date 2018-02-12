package back1043;

import java.util.*;

public class Main {
	static int N,M;
	static ArrayList<Integer> party[];
	static boolean visit[];
	static int dp[][];
	static int inf = 10000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		int trueman = in.nextInt();
		
		Queue<Integer> q= new LinkedList<>();
		
		HashSet<Integer> man = new HashSet<>();
		for (int i = 0 ; i < trueman ; i++) {
			int x = in.nextInt();
			q.add(x);
			man.add(x);
		}
		
		party = new ArrayList[M+1];
		for (int i = 1 ; i<= M ; i++) {
			party[i] = new ArrayList<>();
		}
		for (int i = 1 ; i <= M ; i++) {
			
			int num = in.nextInt();
			for (int j = 0 ; j < num ; j++) {
				party[i].add(in.nextInt());
			}

		}

		dp = new int[2][51];
		Arrays.fill(dp[0],-1);
		Arrays.fill(dp[1],-1);
		System.out.println(func(0,0,man));
	}
	
	public static int func(int state,int len,HashSet<Integer> list) {
		
		System.out.println(len+" "+list);
		
		if ( len > M) {
			int ans = 0;
			for (int i = 1 ; i<= M ; i++) {
				
				boolean pass = true;
				for (int j = 0 ; j < party[i].size() ; j++) {
					if ( list.contains(party[i].get(j))) {
						pass = false;
						break;
					}
				}
				if ( pass) {
					ans++;
				}
			}
			
			return ans;
		}
		
		int ret = dp[state][len];
		if ( ret!= -1) {
			return ret;
		}
		ret = 0;
		
		ret = Math.max(ret, func(0,len+1,list) );
		if ( len > 0) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for (int i = 0 ; i < party[len].size() ; i++) {
				tmp.add(party[len].get(i));
				list.add(party[len].get(i));
			}
			ret = Math.max(ret, func(1,len+1,list) );
			
			int x = 0;
			while ( x < tmp.size()) {
				
				if ( list.contains(tmp.get(x))) {
					list.remove((Integer)tmp.get(x));
				}
				x++;
			}
			
		}
		
		
		return dp[state][len] = ret;
	}
	

}
