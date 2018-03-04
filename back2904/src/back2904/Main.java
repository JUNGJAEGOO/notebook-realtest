package back2904;

import java.util.*;

public class Main {
	static boolean isprime[];
	static ArrayList<Integer> prime = new ArrayList<>();
	public static void main(String args[]) {
		isprime = new boolean[1000001];
		eratos();
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<node> combi = new ArrayList<>();
		int arr[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		for (int i = 0 ; i < N ; i++) {
			for (int j = i+1 ; j< N ; j++) {
				combi.add(new node(arr[i],arr[j]));
			}
		}
		
		//System.out.println(prime);
		//System.out.println(prime.size());
		
		for (int i = 0 ; i < combi.size() ; i++) {
			
			int A = combi.get(i).x;
			int B = combi.get(i).y;
			
			for ( int j = 0 ; j < prime.size() ; j++) {
				
				int tmpa = A;
				int tmpb = B;
				int divider = prime.get(j);
				if ( divider > A) {
					break;
				}
				
				while ( tmpa > 1) {
					
					
					
				}
				
				
			}
			
			
		}
	
	}
	
	public static void eratos() {
		isprime[0] = true;
		isprime[1] = true;
		for (int i = 2 ; i <= 1000000 ; i++) {
			if ( isprime[i] == false) {
				prime.add(i);
				for (int j = i + i ; j <= 1000000 ; j = j + i) {
					if ( j > 1000000 ) {
						break;
					}
					isprime[j] = true;
				}
			}
		}
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
