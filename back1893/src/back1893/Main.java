package back1893;

import java.util.HashMap;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		
		while ( T > 0 ) {
			
			String soon = in.nextLine();
			String origin = in.nextLine();
			String want = in.nextLine();
			ArrayList<Integer> ans = new ArrayList<>();
			
			for (int i = 0; i < soon.length() ; i++) {
			
				String biggyo = shift(i,soon);
				//System.out.println("비교: "+biggyo);
				HashMap<Character,Character> hm = new HashMap<>();
				for (int j = 0 ; j < soon.length() ; j++) {
					hm.put(soon.charAt(j), biggyo.charAt(j));
				}
				
				String pattern = move(origin,hm);
				
				//System.out.println("패턴: "+pattern);
				int fail[] = make(pattern);
				
				int x = (KMP(fail,pattern,want));
				if ( x== 1) {
					ans.add(i);
				}
			}
			
			if ( ans.size() == 0) {
				System.out.println("no solution");
			}else if ( ans.size() == 1) {
				System.out.print("unique: ");
				for (int i = 0 ; i < ans.size() ; i++) {
					System.out.print(ans.get(i)+" ");
				}
				System.out.println();
			}else {
				System.out.print("ambiguous: ");
				for (int i = 0 ; i < ans.size() ; i++) {
					System.out.print(ans.get(i)+" ");
				}
				System.out.println();
			}
			
			T--;
		}
	}
	
	public static String move(String ori,HashMap<Character,Character> hm) {
		
		node[] now = new node[ori.length()];
		for (int i = 0 ; i < now.length ; i++) {
			now[i] = new node();
			now[i].now = ori.charAt(i);
		}
		
		//System.out.println("오리진 "+ori);
		Iterator itr = hm.keySet().iterator();
		
		while ( itr.hasNext()) {
			
			char key = (char) itr.next();
			//System.out.println(key+" "+hm.get(key));
			
			for(int i = 0 ; i < now.length ; i++) {
				if ( now[i].tran == false) {
					if ( now[i].now == key) {
						now[i].now = hm.get(key);
						now[i].tran = true;
					}
				}
			}
			
		}
		
		ori ="";
		for (int i = 0 ; i < now.length ; i++) {
			ori += now[i].now;
		}
		
		return ori;
		
	}
	
	public static String shift(int key,String origin) {
		
		char c[] = origin.toCharArray();
		while ( key > 0) {
			
			char tmp = c[0];
			for ( int i = 0 ; i < c.length-1; i++) {
				c[i] = c[i+1];
			}
			c[c.length-1] = tmp;
			origin = String.valueOf(c);
			key--;
		}
		
		return origin;
		
	}
	
	public static int[] make(String pattern) {
		int fail[] = new int[pattern.length()];
		char[] p = pattern.toCharArray();
		int j = 0;
		for (int i = 1 ; i < fail.length ; i++) {
			while ( j > 0 && p[i] != p[j] ) {
				j = fail[j-1];
			}
			if ( p[i] == p[j]) {
				fail[i] = ++j;
			}
			
		}
		
		return fail;
	}
	
	public static int KMP(int[] fail,String pattern,String str) {

		int ans = 0;
		char p[] = str.toCharArray();
		char pat[] = pattern.toCharArray();
		int j = 0;
		for (int i = 0 ; i < str.length() ; i++) {
			while ( j > 0 && p[i] != pat[j]) {
				j = fail[j-1];
			}
			if ( p[i] == pat[j]) {
				if ( j == pattern.length()-1 ) {
					ans++;
					j = 0;
					j = fail[j];
				}else {
					j++;
				}
			}else {
				j = 0;
			}
			
		}
		
		return ans;
	}
	
	static class node{
		char now;
		boolean tran;
	}
}
