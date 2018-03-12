package back14469;

import java.util.*;

public class Main {
	
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		boolean visit[] = new boolean[N];
		
		ArrayList<node> list = new ArrayList<>();
		for (int i = 0 ; i < N ; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			list.add(new node(i,start,start+end));
		}

		long nowsec = 0;
		for ( int i = 0 ; i < N ; i++) {
			
			int minidx = -1;
			int minstart = 1000000000;
			int minend = 1000000000;
			
			for ( int j = 0 ; j < N ; j++) {
				if ( visit[list.get(j).idx] == false) {
					int tmpstart = list.get(j).start;
					int tmpend = list.get(j).end;
					if ( tmpstart <= minstart && tmpend < minend) {
						minidx = list.get(j).idx;
						minstart = tmpstart;
						minend = tmpend;
					}
				}
			}
			System.out.println(minstart+" ~ "+minend);
			visit[minidx] = true;
			if ( nowsec == 0) {
				nowsec = minend;
			}else {
				if ( minstart <= nowsec) {
					nowsec += (minend-minstart);
				}else {
					nowsec = (minend);
				}
			}
		}
		
		System.out.println(nowsec);
	}
	
	public static class node{
		int idx;
		int start;
		int end;
		node ( int idx,int start,int end){
			this.idx = idx;
			this.start = start;
			this.end = end;
		}
	}
}
