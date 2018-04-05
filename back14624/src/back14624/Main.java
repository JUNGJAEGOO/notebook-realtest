package back14624;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		if ( N % 2 == 0) {
			System.out.println("I LOVE CBNU");
		}else {
			
			for (int i = 0 ; i < N/2 + 2 ; i++) {
				
				for ( int j = 0 ; j < N ; j++) {
					if ( i == 0 ) {
						System.out.print("*");
					}else {
						
						if ( j ==  N/2 - (i-1) ) {
							System.out.print("*");
							if ( i == 1) {
								break;
							}
						}
						else if ( j == N/2 + (i-1) ) {
							System.out.print("*");
							break;
						}
						else {
							System.out.print(" ");
						}
						
					}
				}
				System.out.println();
				
			}
		}
	}
}
