package back10800;

import java.util.*;

public class Main {
		public static void main(String args[]) {
			Scanner in = new Scanner(System.in);
			int N = in.nextInt();
			
			PriorityQueue<Integer> Colors[] = new PriorityQueue[2001];
			ArrayList<Long> ColorsOrigin[] = new ArrayList[2001];
			ArrayList<Long> sum[] = new ArrayList[2001];
			ArrayList<player> P = new ArrayList<>();
			for ( int i = 1 ; i<= 2000 ; i++) {
				Colors[i] = new PriorityQueue<>();
				ColorsOrigin[i] = new ArrayList<>();
				sum[i] = new ArrayList<>();
			}
			
			for ( int i = 1 ; i <= N ; i++) {
				int C = in.nextInt();
				int S = in.nextInt();
				P.add(new player(C,S));
				Colors[C].add(S);
				//System.out.println(Colors[C]);
			}
			
			for ( int i = 1 ; i<= N ; i++) {
				
				int len = Colors[i].size() ;
				for ( int j = 0 ; j < len ; j++) {
					
					Long x = (long)Colors[i].poll();
					//System.out.println(x);
					if ( j == 0) {
						sum[i].add(x);
					}else {
						sum[i].add(sum[i].get(j-1) + x);
					}
					ColorsOrigin[i].add(x);
				}
			}
			
			
			StringBuilder sb = new StringBuilder();
			for ( int i = 0 ; i < P.size() ; i++) {
				
				int nowC = P.get(i).C;
				int nowS = P.get(i).W;
				
				int summation = 0;
				for ( int j = 1 ; j <= 2000 ; j++ ) {
					if ( nowC == j || sum[j].size() == 0) {
						continue;
					}
					
					//System.out.println(nowC+" "+j+" "+sum[j]);
					
					int left = 0;
					int right = ColorsOrigin[j].size()-1;
					int ans = 0;
					
					while (  left <= right ) {
						int mid = (left + right) / 2;
						
						if ( ColorsOrigin[j].get(mid) <= nowS ) {
							left = mid + 1;
							ans = mid;
						}else {
							right = mid -1;
						}
					}
					
					//System.out.println(sum[j].get(ans));
					if ( nowS >= sum[j].get(ans) ) {
						summation += sum[j].get(ans);
					}
				}
				sb.append(summation+"\n");
			}
			System.out.print(sb);
		}
		
		public static class player{
			int C;
			int W;
			player(int C,int W){
				this.C = C;
				this.W = W;
			}
		}

}
