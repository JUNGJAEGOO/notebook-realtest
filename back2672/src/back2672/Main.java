package back2672;

import java.util.*;

public class Main {
	static ArrayList<node> list = new ArrayList<>();
	static ArrayList<Double> xx = new ArrayList<>();
	static ArrayList<Double> yy = new ArrayList<>();
	
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		for ( int i = 0 ; i < N ; i++) {
			
			double x = in.nextDouble();
			double y = in.nextDouble();
			
			double w = in.nextDouble();
			double h = in.nextDouble();
			
			list.add(new node(x,y,x+w,y+h));
			xx.add(x);
			xx.add(x+w);
			yy.add(y);
			yy.add(y+h);
			
			
		}
		
		double ans = 0;
		Collections.sort(xx);
		Collections.sort(yy);
		
		for (int i = 0 ; i < xx.size()-1 ; i++) {
			for ( int j = 0 ; j < yy.size()-1 ; j++) {

				for ( int k = 0 ; k < list.size() ; k++) {
					
					double a = xx.get(i);
					double b = yy.get(j);
					double a2 = xx.get(i+1);
					double b2 = yy.get(j+1);
					
					if ( a < list.get(k).x2 && a2 > list.get(k).x1 
							&& b < list.get(k).y2 && b2 > list.get(k).y1) {
						
						/*System.out.println(a+","+b+" "+a2+","+b2+" "+list.get(k).x1+","+list.get(k).y1
								+" "+list.get(k).x2+","+list.get(k).y2);*/
						
						// System.out.println(a+","+b+" "+a2+","+b2);
						ans +=  ( a2 - a ) * ( b2 - b);
						break;
					}
					
				}
				
				
			}
			
		}
		
		if ( (long)ans == ans ) {
			System.out.println((long)ans);
		}else {
			System.out.format("%.2f",ans);
		}
	}
	
	public static class point {
		double x,y;
		point(double x,double y){
			this. x= x;
			this.y = y;
		}
		
	}
	
	public static class node{
		double x1,y1,x2,y2;
		node( double x1,double y1,double x2,double y2){
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;

		}
	}
}
