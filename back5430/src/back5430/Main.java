package back5430;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while ( T>0) {
			
			char com[] = in.nextLine().toCharArray();
			int len = Integer.parseInt(in.nextLine());
			String arr = in.nextLine();
			String origin[] = arr.substring(1, arr.length()-1).split(",");
			/*for ( int i = 0 ; i < origin.length ; i++) {
				System.out.print(origin[i]+" ");
			}System.out.println();*/
			Stack<String> A = new Stack<>();
			Stack<String> B = new Stack<>();
			if ( len > 0) {
				for ( int i = 0 ; i < origin.length ; i++) {
					A.push(origin[i]);
				}
				for ( int i = origin.length-1 ; i >= 0 ; i--) {
					B.push(origin[i]);
				}
			}
			
			boolean error = false;
			int length = origin.length;
			if ( len == 0) {
				length = 0;
			}
			int sw = 1; // 1 면 A -1 B
			for (int i = 0 ; i < com.length ; i++) {
				
				if ( com[i] == 'D') {
					if ( sw == -1) {
						if ( A.size() > 0) {
							A.pop();
							length--;
						}else {
							error = true;
						}
					}else if ( sw == 1){
						if ( B.size() > 0) {
							length--;
							B.pop();
						}else {
							error = true;
						}
					}
				}else if ( com[i] == 'R'){
					sw *= -1;
				}
			}
			
			if ( error == true) {
				System.out.println("error");
			}else {
				System.out.print("[");
				for (int i = 0 ; i < length ; i ++) {
					if ( sw == -1) {
						if ( i != length-1) {
							System.out.print(A.pop()+",");
						}else {
							System.out.print(A.pop());
						}
					}else if ( sw == 1) {
						if ( i != length-1) {
							System.out.print(B.pop()+",");
						}else {
							System.out.print(B.pop());
						}
					}
				}
				System.out.println("]");
			}
	
			T--;
		}
	}
}
