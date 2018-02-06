package back2493;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		Stack<node> st =new Stack<>();
		int N = in.nextInt();
		for ( int i = 0; i < N ; i++) {
			node tmp = new node();
			tmp.idx = i+1;
			tmp.h = in.nextInt();
			st.add(tmp);
		}
		Stack<node> two = new Stack<>();
		int res [] = new int[N+1];
		two.add(st.pop());
		while ( !st.isEmpty() ) {
			
			if ( two.isEmpty() ) {
				two.add(st.pop());
			}else {
				if ( two.peek().h < st.peek().h ) {
					//System.out.println(two.peek().h+","+two.peek().idx +" "+st.peek().h+","+st.peek().idx);
					res[two.peek().idx] = st.peek().idx;
					two.pop();
				}else {
					two.add(st.pop());
				}
			}	
			
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1 ; i <= N ; i++) {
			sb.append(res[i]+" ");
		}
		System.out.print(sb);
		
	}
	
	public static class node{
		int idx;
		int h;
	}
}
