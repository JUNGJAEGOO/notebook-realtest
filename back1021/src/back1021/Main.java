package back1021;

import java.util.*;

public class Main {
	static ArrayList<Integer> list = new ArrayList<>();
	static int N,M;
	static int ans = 1000000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		Deque<Integer> dq = new LinkedList<>();
		for ( int i = 0 ; i < N ; i++) {
			dq.addLast(i+1);
		}
		
		for ( int i = 0 ; i < M ; i++) {
			list.add(in.nextInt());
		}
		
		
		func(0,0,dq);
		
		System.out.println(ans);
	}
	
	public static void func(int len,int sum,Deque<Integer> dq) {
		
		if ( len == M) {
			ans = Math.min(ans, sum);
			return;
		}else {
			
			if ( dq.getFirst() == list.get(len) ) {
				dq.removeFirst();
				func(len+1,sum,dq);
			}else {
				
				int target = list.get(len);
				
				Iterator itr = dq.iterator();
				
				int cnt  = 1;
				
				while ( itr.hasNext()) {
					int key = (int)itr.next();
					if ( key == target) {
						break;
					}
					cnt++;
				}
				
				int mid = (int)((Math.ceil((double)dq.size()/2)));
				
				if ( cnt == mid) {
					int count = 0;
					while ( true) {
						int tmp = dq.removeFirst();
						dq.addLast(tmp);
						count++;
						if ( dq.getFirst() == target) {
							dq.removeFirst();
							break;
						}
						
					}
					
					func(len+1,sum+count,dq);
				}else if ( cnt < mid) {
					
					int count = 0;
					while ( true) {
						int tmp = dq.removeFirst();
						dq.addLast(tmp);
						count++;
						if ( dq.getFirst() == target) {
							dq.removeFirst();
							break;
						}
						
					}
					
					func(len+1,sum+count,dq);
					
				}else if ( cnt > mid) {
					
					int count = 0;
					while ( true) {
						int tmp = dq.removeLast();
						dq.addFirst(tmp);
						count++;
						if ( dq.getFirst() == target) {
							dq.removeFirst();
							break;
						}
						
					}
					
					func(len+1,sum+count,dq);
					
				}
				
			}
			
		}
		
	}
	
	public static class node{
		int idx;
		int num;
		node ( int idx,int num){
			this.idx = idx;
			this.num = num;
		}
	}
}
