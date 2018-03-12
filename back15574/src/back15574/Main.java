package back15574;

import java.util.*;

public class Main{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<node> list = new ArrayList<>();
		for ( int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			list.add(new node(x,y));
		}
		Collections.sort(list);
		
		double sum1 = 0,sum2=0;
		
		int nowX = list.get(0).x;
		boolean sw = false; // sw = true면 맥스찾기 false면 민 찾기
		int min = list.get(0).y;
		int max = -1000000000;
		ArrayList<node> cals = new ArrayList<>();
		
		for (int i = 1 ; i < N ; i++) {
			if ( list.get(i).x == nowX) {
				if ( sw ) {
					if ( list.get(i).y > max) {
						max = list.get(i).y;
					}
				}else {
					if ( list.get(i).y < min) {
						min = list.get(i).y;
					}
				}
			}else {
				if ( sw ) {
					cals.add(new node(nowX,max));
					sw = false;
				}else {
					cals.add(new node(nowX,min));
					sw = true;
				}

				nowX = list.get(i).x;
				if ( sw ) {
					max = list.get(i).y;
				}else {
					min = list.get(i).y;
				}
			}
		}
		
		if ( sw ) {
			cals.add(new node(nowX,max));
			sw = false;
		}else {
			cals.add(new node(nowX,min));
			sw = true;
		}

		nowX = list.get(N-1).x;
		if ( sw ) {
			max = list.get(N-1).y;
		}else {
			min = list.get(N-1).y;
		}
		
		
		
		
		for (int i = 0 ; i < cals.size() ; i++) {
			System.out.println(cals.get(i).x+" "+cals.get(i).y);
		}
	}
	
	public static class node implements Comparable<node>{
		int x,y;
		node (int x,int y){
			this.x=x;
			this.y=y;
		}
		@Override
		public int compareTo(node o) {
			if ( this.x > o.x) {
				return 1;
			}else if ( this.x == o.x){
				if ( this.y > o.y) {
					return 1;
				}else {
					return -1;
				}
			}
			return -1;
		}
	}
}