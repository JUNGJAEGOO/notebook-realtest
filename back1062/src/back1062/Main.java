package back1062;

import java.io.*;
import java.util.*;

public class Main {
	static int ans;
	static ArrayList<Character> list = new ArrayList<>();
	static int N,K;
	static String arr[];
	static int mat[];
	static boolean visit[];
	static HashSet<Character> hs[]; 
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new String[N];
		visit = new boolean[27];
		mat = new int[27];
		hs = new HashSet[N];
		
		for (int i = 0 ; i < N ; i++) {
			hs[i] = new HashSet<>();
		}
		
		if ( K - 5  < 0 ) {
			System.out.println(0);
			return;
		}
		K-=5;
			
		int ex = 0;
		for ( int i = 0 ; i < N ; i++) {
			String tmp = br.readLine();
			arr[i] = tmp.replace("[antic]","");
			//System.out.println(arr[i]);
			if ( arr[i].length() == 0) {
				ans++;
			}
			
			for ( int j = 0 ; j < arr[i].length() ; j++) {
				mat[arr[i].charAt(j)-'a']++;
				if ( mat[arr[i].charAt(j)-'a'] == 1 ) {
					if ( arr[i].charAt(j) != 'a' && arr[i].charAt(j) != 'c' && arr[i].charAt(j) != 't' && arr[i].charAt(j) != 'i' && arr[i].charAt(j) != 'n') {
						ex++;
					}
				}
				if ( arr[i].charAt(j) != 'a' && arr[i].charAt(j) != 'c' && arr[i].charAt(j) != 't' && arr[i].charAt(j) != 'i' && arr[i].charAt(j) != 'n') {
					hs[i].add(arr[i].charAt(j));
				}
			}
			//System.out.println(hs[i]);
			
		}
		
		//System.out.println(ex);
		if ( K > ex) {
			K = ex;
		}
		
		// a==0 c==3 t i n
		DFS(0,0);
		System.out.println(ans);
		
	}
	
	public static void DFS(int len,int idx) {
		
		if ( len > K ) {
			return;
		}
		
		if ( len == K) {
			System.out.println(list);
			
			int tmpres = 0;
			
			boolean pass;
			
			for (int i = 0 ; i < N; i++) {
				Iterator it = hs[i].iterator();
				pass = true;
				while ( it.hasNext() ) {
					if ( !list.contains(it.next() )) {
						pass = false;
						break;
					}
				}
				if ( pass ) {
					tmpres++;
				}
			}
			
			
			//System.out.println(x+","+tmpres);
			ans = Math.max(ans, tmpres);
			return;
				
		}
		
		for (int i = idx ; i < 26 ; i++) {
			if ( mat[i] > 0 && visit[i] == false) {
				if ( i != 0 && i != 2 && i != 8 && i != 13 && i != 19  ) {
					visit[i] = true;
					list.add((char)(i+'a'));
					DFS(len+1,i);
					list.remove(list.size()-1);
					visit[i] = false;
				}
			}
		}
		
		
	}
}
