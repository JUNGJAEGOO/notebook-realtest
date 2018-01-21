package back2186;

import java.io.*;
import java.util.*;

public class Main {
	static int N,M,K;
	static char map[][];
	static int X[];
	static int Y[];
	static char target[];
	static boolean visit[][];
	static int ans;
	static int dp[][][];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N+2][M+2];
		visit = new boolean[N+2][N+2];
		X = new int[4];
		Y = new int[4];
		dp = new int[101][101][81];
		
		for (int i = 0 ; i <= 100 ; i++) {
			for (int j = 0 ; j <= 100 ; j++) {
				for  (int k = 0 ; k <= 80 ; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		for (int i = 0 ; i < K ; i++) {
			X[0] = -1;
			X[1] = 0;
			X[2] = 1;
			X[3] = 0;
			
			Y[0] = 0;
			Y[1] = 1;
			Y[2] = 0;
			Y[3] = -1;
					
		}
	
		
		for ( int i = 1 ; i <= N ; i++ ) {
			char tmp[] = br.readLine().toCharArray();
			for  (int j = 1 ; j<= M ; j++) {
				map[i][j] = tmp[j-1];
			}
		}
		
		String T = br.readLine();
		target = T.toCharArray();
		
		
		for  (int i = 1 ; i<= N ; i++) {
			for ( int j = 1 ; j<= M ; j++) {
				if ( map[i][j] == target[0]) {
					//visit[i][j] = true;
					ans+=DFS(i,j,0);
					//visit[i][j] = false;
				}
			}
		}
		
	/*	for (int i = 1 ; i <=4 ; i++) {
			for (int j =1 ; j <= 4 ; j++) {
				for  (int k =3 ;k <= 3; k++) {
					System.out.print(dp[i][j][k]+" ");
				}
			}

			System.out.println();
		}*/
		
		System.out.println(ans);
	
	}
	
	public static int DFS(int x,int y,int len) {
		
		//System.out.println(x+","+y+" "+len);
		
		if ( len == target.length-1) {
			//System.out.println(x+","+y);
			return 1;
		}
		
		int ret = dp[x][y][len];
		if ( dp[x][y][len] != -1) {
			return ret;
		}
		ret = 0;
		
		for ( int i = 1 ; i <= K; i++) {
			//for (int t = 1 ; t <= K ; t++) {
				
			for ( int j = 0 ; j < 4 ; j++) {
				if ( x+i*X[j] >= 1 && x+i*X[j] <= N && y+i*Y[j] >= 1 && y+i*Y[j] <= M ) {
					
					//if ( visit[x+i*X[j]][y+i*Y[j]] == false) {
						//System.out.println(x+X[i][j]+" "+(y+Y[i][j]));
						
						if ( map[x+i*X[j]][y+i*Y[j]] == target[len+1]) {
							//System.out.println(x+X[i][j]+" "+(y+Y[i][j]));
							//visit[x+i*X[j]][y+i*Y[j]] = true;
							ret += DFS(x+i*X[j],y+i*Y[j],len+1);
							//visit[x+i*X[j]][y+i*Y[j]] = false;
						}
					//}
				}
			}
			
			//}
		}
		
		//System.out.println(ret);
		
		return dp[x][y][len] =ret;
	}
	
}
