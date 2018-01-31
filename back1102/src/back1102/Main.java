package back1102;

import java.util.Scanner;

public class Main {
	static int inf = 1000000000;
	static int N,P;
	static int dp[][];
	static int mat[][];
	static char state[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N =Integer.parseInt(in.nextLine());
		mat = new int[N][N];
		
		for (int i = 0 ; i < N ; i++) {
			String tmp[] = in.nextLine().split(" ");
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		dp = new int[N][(1<<N)+1];
		for (int i = 0 ; i <N ; i++) {
			for (int j = 0 ; j < (1<<N)+1 ;j++) {
				dp[i][j] = -1;
			}
		}
		
		state = in.nextLine().toCharArray();
		P = Integer.parseInt(in.nextLine());
		//System.out.println(1<<N);
		System.out.println(func(0,1,state));
	}
	
	public static int func(int pos,int visit,char[] state) {
		
		System.out.println(pos+" "+visit+" "+String.valueOf(state));
		
		if ( visit == (1<<N)-1) {
			int check = 0;
			for (int i = 0 ; i < state.length ; i++) {
				if ( state[i] == 'Y') {
					check++;
				}
			}
			if ( check >= P) {
				System.out.println("!!!!"+pos+" "+visit+" "+String.valueOf(state));
				return mat[pos][0];
			}else {
				return inf;
			}
		}
		
		int ret = dp[pos][visit];
		if ( ret != -1) {
			return ret;
		}
		ret = inf;
		
		for (int i = 0 ; i < N ; i++) {
			if ( ( visit & (1<<i) )== 0) {
				if ( mat[pos][i] != 0) {
					//System.out.println(i);
					char[] tmp = state.clone();
					tmp[i] = 'Y';
					int a = mat[pos][i]+func(i, visit | (1<<i) , tmp);
					int b = func(i,visit|(1<<i),state);
					System.out.println(a+"        "+b);
					ret = Math.min(ret,Math.min(a,b));
					
				}
			}
		}
		
		
		return dp[pos][visit] = ret;
		
	}
}
