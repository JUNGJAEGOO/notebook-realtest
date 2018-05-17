package back8896;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		
		while ( T > 0) {
			
			int N = Integer.parseInt(in.nextLine());
			
			char[][] now = new char[N][];
			
			for ( int i = 0 ; i < N ; i++) {
				now[i] = in.nextLine().toCharArray();
			}
			
			boolean loser[] = new boolean[N];
			int cnt = 0;
			while ( true ) {
			
				int R = 0;
				int S = 0;
				int P = 0;
				
				
				ArrayList<Integer> Rlist = new ArrayList<>();
				ArrayList<Integer> Slist = new ArrayList<>();
				ArrayList<Integer> Plist = new ArrayList<>();
				
				for ( int i = 0 ; i < N ; i++) {
					
					if ( now[i][cnt] == 'R' && !loser[i]) {
						R++;
						Rlist.add(i);
					}else if ( now[i][cnt] == 'S' && !loser[i]) {
						S++;
						Slist.add(i);
					}else if( now[i][cnt] == 'P' && !loser[i]) {
						P++;
						Plist.add(i);
					}
					
				}
				
				//System.out.println(R+" "+S+" "+P);
				
				if ( S == 0 && P > 0 && R > 0) {
					for ( int i = 0 ; i < Rlist.size() ; i++) {
						loser[Rlist.get(i)] = true;
					}
				}else if ( P == 0 && S > 0 && R > 0) {
					for ( int i = 0 ; i < Slist.size() ; i++) {
						loser[Slist.get(i)] = true;
					}
				}else if ( R == 0 && S > 0 && P > 0) {
					for ( int i = 0 ; i < Plist.size() ; i++) {
						loser[Plist.get(i)] = true;
					}
				}
				
				cnt++;
				
				if ( cnt == now[0].length) {
					break;
				}
			
			}
			
			int winner = -1;
			int sum = 0;
			for ( int i = 0 ; i < N ; i++) {
				if ( !loser[i]) {
					sum++;
					winner = i;
				}
			}
			
			if ( sum == 1) {
				System.out.println(winner+1);
			}else {
				System.out.println(0);
			}
			
			T--;
		}
	}
}
