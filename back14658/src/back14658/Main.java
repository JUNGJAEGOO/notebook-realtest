package back14658;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int L = in.nextInt();
		int K = in.nextInt();
		ArrayList<node> stars = new ArrayList<>();
		for (int i = 0 ; i < K ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			stars.add(new node(x,y));
		}
		
		for  (int i = 1 ; i <= K ; i++) {
			for (int j = 1 ; j <= K ; j++) {
				func(i,j);
			}
		}
	}
	
	public static void func() {
		
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x =x;
			this.y = y;
		}
	}
}
