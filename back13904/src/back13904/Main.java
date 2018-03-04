package back13904;

import java.util.*;

public class Main {
	static int N;
	static int days[];

	static ArrayList<node> list = new ArrayList<>();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int maxday = 0;
		for (int i = 0 ; i < N ; i++) {
			int day = in.nextInt();;
			int cost = in.nextInt();;
			if ( day > maxday) {
				maxday = day;
			}
			list.add(new node(day,cost));
		}
		Collections.sort(list);
		
		days = new int[2001];
		int cnt = 0;
		while ( true ) {
			
			int cost = list.get(cnt).cost;
			int day = list.get(cnt).fire;
			while ( true) {
				if ( day <= 0 ) {
					break;
				}
				if ( days[day] == 0) {
					days[day] = cost;
					//System.out.println(days[day]+" "+day);
					break;
				}
				day--;
			}
			cnt++;
			if ( cnt >= N) {
				break;
			}
			
		}
		int sum = 0;
		for (int i = 1 ; i<= 1000 ; i++) {
			sum += days[i];
		}
		System.out.println(sum);
		
		
	}

	public static class node implements Comparable<node>{
		int fire;
		int cost;
		node (int fire,int cost){
			this.fire = fire;
			this.cost = cost;
		}
		@Override
		public int compareTo(node o) {
			if ( this.cost < o.cost) {
				return 1;
			}
			return -1;
		}
	}
}
