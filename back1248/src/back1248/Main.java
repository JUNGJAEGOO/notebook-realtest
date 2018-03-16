package back1248;

import java.util.*;

public class Main {
	static int N;
	static char zogun[];
	
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = Integer.parseInt(in.nextLine());
		zogun = in.nextLine().toCharArray();
		
		ArrayList<Integer> arr = new ArrayList<>();;
		func(0,0,0,0,arr);
	}
	
	public static void func(int len,int start,int lim,int go,ArrayList<Integer> now) {
		
		System.out.println(now+" "+len);
		
		if ( len == (N * ( N + 1 )) / 2 ) {
			
			for (int i = 0 ; i < now.size() ; i++) {
				System.out.print(now.get(i)+" ");
			}System.out.println();
			
			return;
		}
		
		
		if  ( len == 0) {
			if ( zogun[len] == '-') {
				for ( int i = -10 ; i < 0 ; i++) {
					now.add(i);
					func(len+1,start,lim+1,go,now);
					now.remove(now.size()-1);
				}
			}else if ( zogun[len] == '0') {
				now.add(0);
				func(len+1,start,lim+1,go,now);
				now.remove(0);
			}else if ( zogun[len] == '+') {
				for ( int i = 1 ; i < 11 ; i++) {
					now.add(i);
					func(len+1,start,lim+1,go,now);
					now.remove(now.size()-1);
				}
			}
		}else if ( len < N){
			
			if ( zogun[len] == '-') {
			
					
					for ( int i = -10 ; i <= 10 ; i++) {
						
						int sum = 0;
						now.add(i);
						for ( int j = start ; j <= lim ; j++) {
							sum += now.get(j);
						}
						if ( sum < 0) {
							if ( len+1 == N-go) {
								func(len+1,go+1,go+1,go+1,now);
							}else {
								func(len+1,start,lim+1,go,now);
							}
						}
						now.remove(now.size()-1);
					}
					
					
				
			}else if ( zogun[len] == '0') {
					for ( int i = -10 ; i <= 10 ; i++) {
					
					int sum = 0;
					now.add(i);
					for ( int j = start ; j <= lim ; j++) {
						sum += now.get(j);
					}
					if ( sum == 0) {
						if ( len+1 == N-go) {
							func(len+1,go+1,go+1,go+1,now);
						}else {
							func(len+1,start,lim+1,go,now);
						}
					}
					now.remove(now.size()-1);
				}
			}else if ( zogun[len] == '+') {
				
				//System.out.println("hi");
				for ( int i = -10 ; i <= 10 ; i++) {
					
					int sum = 0;
					now.add(i);
					//System.out.println(now+"     sd"+start+" "+lim);
					for ( int j = start ; j <= lim ; j++) {
						sum += now.get(j);
					}
					//System.out.println(now+" "+sum);
					
					if ( sum > 0) {
						if ( len+1 == N-go) {
							func(len+1,go+1,go+1,go+1,now);
						}else {
							func(len+1,start,lim+1,go,now);
						}
					}
					now.remove(now.size()-1);
				}
				
			}
			
		}else {
			
			
			
			System.out.println("hi"+" "+len+" "+start+" ~ "+lim+" go:"+go);
			if ( zogun[len] == '-') {
				
	
					int sum = 0;
				
					for ( int j = start ; j <= lim ; j++) {
						sum += now.get(j);
					}
					if ( sum < 0) {
						if ( lim+1 > N-go) {
							func(len+1,go+1,go+1,go+1,now);
						}else {
							func(len+1,start,lim+1,go,now);
						}
					}
					

		}else if ( zogun[len] == '0') {
			
				
				int sum = 0;
				
				for ( int j = start ; j <= lim ; j++) {
					sum += now.get(j);
				}
				if ( sum == 0) {
					if ( lim+1 > N-go) {
						func(len+1,go+1,go+1,go+1,now);
					}else {
						func(len+1,start,lim+1,go,now);
					}
				}
				
		}else if ( zogun[len] == '+') {
			
				
				int sum = 0;
				
				for ( int j = start ; j <= lim ; j++) {
					sum += now.get(j);
				}
				
				if ( sum > 0) {
					if ( lim+1 > N-go) {
						func(len+1,go+1,go+1,go+1,now);
					}else {
						func(len+1,start,lim+1,go,now);
					}
				}
				
			}
			
		
			
		}
	}
}
