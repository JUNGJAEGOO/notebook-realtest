package back2659;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	static TreeSet<Integer> tr = new TreeSet<>();
	
	static int a,b,c,d;
	static int cnt = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();
		
		make(0,"");
		
		int watch =  a*1000+b*100+c*10+d;
		int watch2 = b*1000+c*100+d*10+a;
		int watch3 = c*1000+d*100+a*10+b;
		int watch4 = d*1000+a*100+b*10+c;
		
		int min = watch;
		min = Math.min(min, watch2);
		min = Math.min(min, watch3);
		min = Math.min(min, watch4);
		
		Iterator itr = tr.iterator();
		int count = 0;
		while ( itr.hasNext()) {
			count++;
			int next = (int)itr.next();
			//System.out.println(next);
			if ( next == min ) {
				//System.out.println(count);
				break;
			}
		}
		
		System.out.println(count);
		
	}
	
	public static void make(int len,String list) {
		if ( len == 4) {
			//System.out.println(list);
			
			String str1 = String.valueOf(list.charAt(0)) + 
					String.valueOf(list.charAt(1)) + String.valueOf(list.charAt(2)) +
					String.valueOf(list.charAt(3));
			
			String str2 = String.valueOf(list.charAt(1)) + 
					String.valueOf(list.charAt(2)) + String.valueOf(list.charAt(3)) +
					String.valueOf(list.charAt(0));
			
			String str3 = String.valueOf(list.charAt(2)) + 
					String.valueOf(list.charAt(3)) + String.valueOf(list.charAt(0)) +
					String.valueOf(list.charAt(1));
			
			String str4 = String.valueOf(list.charAt(3)) + 
					String.valueOf(list.charAt(0)) + String.valueOf(list.charAt(1)) +
					String.valueOf(list.charAt(2));
			
			int min = 100000;
			min = Math.min(Integer.parseInt(str1), Integer.parseInt(str2));
			min = Math.min(min, Integer.parseInt(str3));
			min = Math.min(min, Integer.parseInt(str4));
			
			tr.add(min);
			return;
		}else {
			
			for ( int i = 1 ; i<= 9 ; i++) {
				list += String.valueOf(i);
				make(len+1,list);
				list = list.substring(0,len);
			}
			
		}
	}
}
