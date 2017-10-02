package back1916;
import java.util.*;
public class Main {

	static int edge[][];
	static int dis[];
	static boolean visit[];
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		visit = new boolean[n];
		edge = new int[n][n];
		dis = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				edge[i][j] = 1000000000;
				
			}
		}
		
		for(int j = 0 ; j < n ; j++) {
			dis[j] = 1000000000;
			
		}
		
		for(int i = 0 ; i < m ; i++) {
			int startTMP = in.nextInt()-1;
			int endTMP = in.nextInt()-1;
			int cost = in.nextInt();
			if ( edge[startTMP][endTMP]!=1000000000) {
				edge[startTMP][endTMP]=Math.min(cost,edge[startTMP][endTMP]);
			}
			else {
				edge[startTMP][endTMP] = cost;
			}
			edge[startTMP][endTMP] = 1;
			

		}
		
		int start = in.nextInt();
		int end = in.nextInt();
	
		
		search(start,n);
		
		System.out.println(dis[end-1]);
/*		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(dis[i][j]+ " ");
			}
			System.out.println();
		}*/
	}
	
	public static void search(int start,int n) {
		             
		int mindist = 1000000000;
		int minindex = 0;
		
		visit[start-1] = true;
		
		int index = start-1;
		dis[index] = 0;
		for ( int count = 0 ; count < n-1 ; count++) {
		mindist = 1000000000;
		minindex = 0;
		for ( int i = 0 ; i < n ; i++ ) {
			if(visit[i] == false && dis[i]<mindist) {
				minindex = i;
				mindist = dis[i];
			}
		}
		//System.out.println("주위 중 최소값은 "+mindist+"인덱스는 "+minindex);
		visit[minindex] = true;
		dis[minindex] = mindist;
		
		for ( int i = 0 ; i < n ; i++ ) {
			
			if ( (dis[i] + mindist < dis[i] ) && edge[minindex][i] != 1000000000 ) {
				//System.out.println(dis[minindex][i]+" 와 "+mindist+" 의 합을 "+dis[index][i]+" 와 교환");
				dis[i] = dis[i]  + mindist;

			}
			
		}
		
/*		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(dis[i][j]+ " ");
			}
			System.out.println();
		}*/
		
		}
		
		
	}
}
