package back1708;

import java.util.*;

public class Main {
	static int originX = -50000000;
	static int originY = -50000000;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<node> points = new ArrayList<>();
		
		for (int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			points.add(new node(x,y));
			if ( originX == -50000000 && originY == -50000000) {
				originX =x;
				originY =y;
			}else {
				if ( y < originY) {
					originX = x;
					originY = y;
				}else if ( y == originY) {
					if ( x < originX) {
						originX = x ;
						originY = y;
					}
				}
			}
		}
		
		for ( int i = 0 ; i < N ; i++) {
			if ( points.get(i).x == originX && points.get(i).y == originY) {
				points.remove(i);
				break;
			}
		}
		
		//System.out.println("!! "+originX+","+originY);
		Collections.sort(points);
		for (int i = 0 ; i < N-1 ; i ++) {
			System.out.println(points.get(i).x+","+points.get(i).y+"  "+points.get(i).angle);
		}
	
		Stack<node> st= new Stack();
		st.add(new node(originX,originY));
		st.add(points.get(0));
		int nextidx = 1;
		
		while ( true ) {
			
			while ( st.size() >= 2) {
				int topx = st.peek().x;
				int topy = st.peek().y;
				st.pop();
				int Fx = st.peek().x;
				int Fy = st.peek().y;
				
				
				System.out.println(Fx+","+Fy+" "+topx+","+topy+" "+points.get(nextidx).x+","+points.get(nextidx).y);
				
				double pandan = CCW(Fx,Fy,topx,topy,points.get(nextidx).x,points.get(nextidx).y);
				System.out.println("각도"+ pandan);
				if ( pandan < 0) {
					st.add(new node(topx,topy));
					break;
				}
			}
			
			
			st.add(points.get(nextidx++));
			if (nextidx >= N-1) {
				break;
			}
		}
		
		for (int i = 0 ; i < st.size();  i++) {
			System.out.println(st.get(i).x+" "+st.get(i).y);
		}
		System.out.println(st.size());
		
	}
	
	public static double CCW(long x1,long y1,long x2,long y2,long x3,long y3) {
		double tmp = x1*y2 + x2*y3 + x3*y1;
		tmp = tmp - y1*x2 - y2*x3 - y3*x1;
		return tmp;
	}
	
	public static double calcAngle(int x1,int y1,int x2,int y2) {
		return Math.atan2((double)(y2-y1),(double)(x2-x1));
	}
	
	public static double calcDist(long x1,long y1,long x2,long y2) {
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	
	public static class node implements Comparable<node>{
		int x,y;
		double angle;
		double dist;
		node (int x,int y){
			this.x =  x;
			this.y = y;
			this.angle = calcAngle(originX,originY,x,y);
			this.dist = calcDist(originX,originY,x,y);
		}
		@Override
		public int compareTo(node o) {
			if ( this.angle < o.angle ) {
				return 1;
			}else if ( this.angle == o.angle) {
				if( this.dist > o.dist) {
					return 1;
				}else {
					return -1;
				}
			}
			else {
				return -1;
			}
		}
	}
}
