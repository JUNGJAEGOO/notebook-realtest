package back15562;

import java.util.*;

public class Main {
	static int p[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		p = new int[1000001];
		Arrays.fill(p, -1);
		for (int i = 0 ; i < M ; i++) {
			int parent = in.nextInt();
			int child = in.nextInt();
			merge(parent,child);
		}
		
		int sum = 0 ;
		for (int i = 1 ; i <= 1000000 ; i++) {
			//System.out.println(p[i]);
			if(  p[i] != -1) {
				sum++;
			}
		}
		
		System.out.println(sum);
	}
	
	public static void merge(int a , int b) {
		int A = find(a);
		int B = find(b);
		
		if ( A == B) {
			return;
		}
		
		p[B] = A;
	}
	
	public static int find(int x) {
		if ( p[x] == -1) {
			return x;
		}else {
			return p[x] = find(p[x]);
		}
	}
}
