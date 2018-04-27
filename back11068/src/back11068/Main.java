package back11068;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		char transform[] = new char[54];
		for (int i = 0 ; i < 26 ; i++) {
			transform[i] = (char)((int)'a' + i);
		}
		for (int i = 26 ; i < 52 ; i++) {
			transform[i] = (char)((int)'A' + (i-26));
		}
		
		transform[52] = '#';
		transform[53] = '!';
		
		
		/*for ( int i = 0 ; i < transform.length ; i++) {
			System.out.println(transform[i]);
		}*/
		
		for ( int testcase = 0 ; testcase < T ; testcase++) {
			
			int now = in.nextInt();
			boolean pass = false;
			
			lop:
			for ( int i = 2 ; i <= 64 ; i++) {
				
				int n = now;
				ArrayList<String> str = new ArrayList<>();
				
				if ( i >= 2 && i <= 10) {
					
					while ( n > (i-1) ) {
						
						int nam = n% i;
						n/=i;
						str.add( String.valueOf(nam) );
						
					}
					if ( n != 0 ) {
						str.add( String.valueOf(n) );
					}
					
					Collections.reverse(str);
					//System.out.println(i+" "+str);
					
					char tmp[] = new char[str.size()];
					for ( int j = 0 ; j < str.size() ; j++) {
						tmp[j] = str.get(j).charAt(0);
					}
					
					
					if ( isPalindrome(tmp) ) {
						//System.out.println(String.valueOf(tmp)+" is ok");
						pass = true;
						break lop;
					}
					
				}
				else {
					
					while ( n > (i-1) ) {
											
						int nam = n% i;
						n/=i;
						if ( nam <= 9) {
							str.add( String.valueOf(nam) );
						}else {
							str.add( String.valueOf(transform[nam-10]) );
						}
					}
					
					if ( n != 0 ) {
						if ( n <= 9) {
							str.add( String.valueOf(n) );
						}else {
							str.add( String.valueOf(transform[n-10]) );
						}
					}
					
					Collections.reverse(str);
					//System.out.println(i+" "+str);
					
					char tmp[] = new char[str.size()];
					for ( int j = 0 ; j < str.size() ; j++) {
						tmp[j] = str.get(j).charAt(0);
					}
					
					
					if ( isPalindrome(tmp) ) {
						//System.out.println(String.valueOf(tmp)+" is ok");
						pass = true;
						break lop;
					}
					
				}
				
			}
			
			if ( pass ) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			
		}
	}
	public static boolean isPalindrome(char[] input) {
		
		int left = 0;
		int right= input.length-1;
		
		while ( left <= right ) {
			if ( input[left] != input[right] ) {
				return false;
			}else {
				left++;
				right--;
			}
		}
		
		return true;
	}
}
