package back14867;

import java.util.*;

public class Main {

	static int ans = 100000000;
	static int A,B;
	static int a,b,c,d;
	static boolean C1[];
	static boolean C2[];
	static boolean C3[];
	static boolean C4[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();
		A = 0;
		B = 0;
		
		C1 = new boolean[10001];
		C2 = new boolean[10001];
		C3 = new boolean[10001];
		C4 = new boolean[10001];
		C1[0] = true;
		C3[0] = true;
		
		func(0,0,0);
		
		//System.out.println(ans);
	}
	
	public static void func(int l,int nA,int nB) {
		
		//System.out.println(nowA+" "+nowB);
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(l,nA,nB));
		
		while ( !q.isEmpty() ) {

			node now = q.poll();
			int nowA = now.a;
			int nowB = now.b;
			int len = now.len;
			
			if ( nowA == c && nowB == d) {
			
				System.out.println(len);
				return;
			}
			
			if (  C2[nowB] == false ) {
				C2[nowB] = true;
				q.add(new node(len+1,a,nowB));
				//func(len+1,a,nowB);
			}
			if ( C4[nowA] == false) {
				C4[nowA] = true;
				q.add(new node(len+1,nowA,b));
				//func(len+1,nowA,b);
			}
			
			if ( C1[nowB] == false ) {
				C1[nowB] = true;
				q.add(new node(len+1,0,nowB));
				//func(len+1,0,nowB);
			}
			
			if (  C3[nowA] == false ) {
				C3[nowA] = true;

				q.add(new node(len+1,nowA,0));
				//func(len+1,nowA,0);
			}
			
			if ( nowA+nowB <= b) {
				if (  C1[nowA+nowB] == false ) {
					C1[nowA+nowB] = true;

					q.add(new node(len+1,0,nowA+nowB));
					//func(len+1,0,nowA+nowB);
				}
			}else {
				int diff = b - nowB;
				if (  C4[nowA-diff] == false ) {
					C4[nowA-diff] = true;

					q.add(new node(len+1,nowA-diff,b));
					//func(len+1,nowA-diff,b);
				}
			}
			
			if ( nowA+nowB <= a) {
				if (  C3[nowA+nowB] == false ) {
					C3[nowA+nowB] = true;

					q.add(new node(len+1,nowA+nowB,0));
					//func(len+1,nowA+nowB,0);
				}
			}else {
				int diff = a - nowA;
				if ( C2[nowB-diff] == false ) {
					C2[nowB-diff] = true;

					q.add(new node(len+1,a,nowB-diff));
					//func(len+1,a,nowB-diff);
				}
			}
		
		}
		
		System.out.println(-1);
	}
	
	public static class node{
		int a,b;
		int len;
		node (int len,int a,int b){
			this.a = a;
			this.b= b ;
			this.len = len;
		}
	}
	

	
	
}
