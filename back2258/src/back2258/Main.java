package back2258;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		ArrayList<node> list = new ArrayList<>();
		
		for ( int i = 0 ; i < N ; i++) {
			list.add(new node(in.nextInt(),in.nextInt()));
		}
		
		Collections.sort(list);
		
		int sum = 0;
		
		
		for ( int i = 0 ; i < N ; i++) {
			
			//System.out.println(list.get(i).price+" "+(sum+list.get(i).weight));
			
			if ( list.get(i).weight + sum >= M) {
				System.out.println(list.get(i).price);
				return;
			}else {
				
				sum += list.get(i).weight;
				
			}
			
		}
		
		System.out.println(-1);
		
	}
	
	public static class node implements Comparable<node>{
		int price;
		int weight;
		node ( int weight,int price){
			this.price = price;
			this.weight = weight;
			
		}
		@Override
		public int compareTo(node o) {
			if ( this.price > o.price) {
				return 1;
			}
			return -1;
		}
	}
}
