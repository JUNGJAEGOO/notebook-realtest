package back1213;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] input = in.nextLine().toCharArray();
		char[] ans = new char[input.length];
		int N = input.length;
		if ( N%2 == 0) {
			
			char minchar = 'Z';
			int left = 0;
			int right = N-1;
			
			while ( true) {
			minchar = 'Z';
			for ( int i = 0 ; i < N ; i++) {
				if ( input[i] != 'a' && (input[i]+0 < minchar+0)  ) {
					minchar = input[i];
				}
			}
			
			int num = 0 ;
			for ( int i = 0 ; i < N ; i++) {
				if ( input[i] == minchar) {
					num++;
				}
			}
			
			if ( num%2 != 0) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
			
			while ( num > 0) {
				if ( num%2 == 0) {
					ans[left] = minchar;
					left++;
					num--;
				}else {
					ans[right] = minchar;
					right--;
					num--;
				}
			}
			
			if ( left - 1 == right) {
				for ( int i = 0 ; i < N ; i++) {
					System.out.print(ans[i]);
				}
				break;
			}
			
			for ( int i = 0 ; i < N ; i++) {
				if ( input[i] == minchar) {
					input[i] = 'a';
				}
			}

			}
			
		}else {
			
			int odd = 0;
			char middle = 'a';
			int middlenum = 0;
			for ( int i = 0 ; i < N ; i++) {
				int num = 0;
				if ( input[i] == middle) {
					continue;
				}
				for ( int j = 0 ; j < N ; j++) {
					if ( input[i] == input[j]) {
						num++;
					}
				}
				if ( num %2 != 0) {
					middle = input[i];
					odd++;
				}
			}
			if ( odd >=2 ) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
			
			for ( int i = 0 ; i < N ; i++) {
				ans[i] = 'a';
				if ( input[i] == middle) {
					middlenum++;
				}
			}
			
			if ( middlenum == N && middle == 'Z') {
				for(int i = 0 ; i < N ; i++) {
					System.out.print(middle);
				}
			}
			
			char minchar = 'Z';
			int left = 0;
			int right = N-1;
			int search = 0;
			while ( true) {
			minchar = 'Z';
			for ( int i = 0 ; i < N ; i++) {
				if ( input[i] != middle && input[i] != 'a' && (input[i]+0 < minchar+0)  ) {
					minchar = input[i];
				}
			}
			
			int num = 0 ;
			for ( int i = 0 ; i < N ; i++) {
				if ( input[i] == minchar) {
					num++;
				}
			}
			
			search += num;
			while ( num > 0) {
				if ( num%2 == 0) {
					ans[left] = minchar;
					left++;
					num--;
				}else {
					ans[right] = minchar;
					right--;
					num--;
				}
			}
			
			if ( search == N - middlenum) {
				for ( int i = 0 ; i < N ; i++) {
					if ( ans[i] == 'a') {
						ans[i] = middle;
					}
				}
				for ( int i = 0 ; i < N ; i++) {
					System.out.print(ans[i]);
				}
				break;
			}
			
			for ( int i = 0 ; i < N ; i++) {
				if ( input[i] == minchar) {
					input[i] = 'a';
				}
			}

			}
			
		}
		
		
	}
}
