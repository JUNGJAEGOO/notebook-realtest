package back2166;

import java.util.*;

public class Main {
	static ArrayList<node> list = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for ( int i = 0 ; i < N ; i++) {
			list.add(new node(in.nextInt(),in.nextInt()));
		}
		
		double ans = 0;
		for ( int i = 1 ; i < N-1 ; i++) {
			ans += (double)CCW(list.get(0).x,list.get(0).y,list.get(i).x,
					list.get(i).y,list.get(i+1).x,list.get(i+1).y);
		}
		
		System.out.println(ans/2);
	}
	
	public static long CCW(long x1,long y1,long x2,long y2,long x3,long y3) {
		
		long X = x1*y2 + x2*y3 + x3*y1;
		long Y = y1*x2 + y2*x3 + y3*x1;
		//System.out.println(X-Y);
		return Math.abs(X-Y);
		
	}
	
	public static class node{
		long x,y;
		node (long x,long y){
			this.x= x;
			this.y= y;
		}
	}
}
