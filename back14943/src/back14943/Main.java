package back14943;

import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int arr[] = new int[N];
		Queue<node> yang = new LinkedList<>();
		Queue<node> yuem = new LinkedList<>();
		
		for (int i = 0 ; i <N ; i++) {
			arr[i] = in.nextInt();
			if ( arr[i] > 0) {
				yang.add(new node(i,arr[i]));
			}else if ( arr[i] < 0) {
				yuem.add(new node(i,arr[i]));
			}
		}
		
		long sum = 0;
		
		while ( !yang.isEmpty() || ! yuem.isEmpty() ) {
			
			node a = yang.peek();
			node b = yuem.peek();
			
			int len = Math.abs(a.idx - b.idx);
			
			if ( a.cost > -b.cost ) {
				a.cost += b.cost;
				sum += len*-b.cost;
				yuem.poll();
			}else if ( a.cost == -b.cost) {
				
				sum += len*a.cost;
				yang.poll();
				yuem.poll();
			}else {
				
				sum += len*a.cost;
				b.cost += a.cost;
				yang.poll();
			}
			
		}
			
		System.out.println(sum);
			
		}
		
	
	
	public static class node{
		int idx;
		int cost;
		node (int idx,int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}
}
