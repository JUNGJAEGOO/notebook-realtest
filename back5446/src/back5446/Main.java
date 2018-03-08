package back5446;

import java.util.*;

public class Main {
	
	static node root;
	static int ans;
	
	public static void main(String args[]) {
		Scanner in = new  Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while ( T  > 0) {
			
			// 0~9 는 48~57
			// a~z 는 97~122
			// A~Z 는 65~90
			// . 은  46
			root = new node();
			
			int n1 = Integer.parseInt(in.nextLine());
			for (int i = 0 ; i < n1 ; i++) {
				char tmp[] = in.nextLine().toCharArray();

				make(root,tmp,0);
			}
			
			
			int n2 = Integer.parseInt(in.nextLine());
			for (int i = 0 ; i < n2 ; i++) {
				char tmp[] = in.nextLine().toCharArray();
				
				prohibit(root,tmp,0);
			}
			
			
			
			ans = 0;
			
			search(root);
			System.out.println(ans);
			
			
			T--;
		}
	}
	
	public static void search(node now) {
		
		//System.out.println(now.childsum);
		
		if (now.terminal == true){
			ans++;
		}
		
		if ( now.start == false && now.prohibit == false && now.terminal == false) {
			ans++;
			return;
		}
		else {
			
			for ( int i = 45 ; i < 130 ; i++) {
				if ( now.child[i] != null) {
					//System.out.println((char)i+" "+now.child[i].prohibit+" "+now.child[i].terminal);
					search(now.child[i]);
				}
			}
		}
		
	}
	
	public static void prohibit(node now,char[] c,int idx) {
		
		if ( idx == c.length ) {
			now.prohibit = true;
			return;
		}else {
			now.prohibit = true;
			//System.out.println(c[idx]+" "+idx);
			if ( now.child[c[idx]] != null) {
				prohibit(now.child[c[idx]],c,idx+1);
			}
		}
		
	}
	
	public static void make(node now,char[] c,int idx) {
		
		if ( idx == c.length  ) {
			now.terminal = true;
			return;
		}else {
			
			if ( idx == 0) {
				now.start = true;
			}
			if ( now.child[c[idx]] == null) {
				now.child[c[idx]] = new node();
				
			}
			now.childsum++;
			//System.out.println(c[idx]+" "+(idx)+" "+now.childsum);
			make(now.child[c[idx]],c,idx+1);	
		}	
	}
	
	
	
	
	public static class node{
		boolean terminal;
		int childsum;
		boolean prohibit;
		boolean start;
		node child[] = new node[130];
		
	}
}
