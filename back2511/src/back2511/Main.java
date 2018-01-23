package back2511;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int A[] = new int[10];
		int B[] = new int[10];
		for  (int i = 0 ; i < 10 ; i++) {
			A[i] = in.nextInt();
		}
		for  (int i = 0 ; i < 10 ; i++) {
			B[i] = in.nextInt();
		}
		
		int round = 0;
		int sumA =0,sumB =0;
		char lastWinner = ' ';
		int draws = 0;
		while ( round < 10) {
			
			if ( A[round] > B[round]) {	
				sumA += 3;
				lastWinner = 'A';
			}else if ( A[round] == B[round]) {
				sumA += 1;
				sumB += 1;
				draws++;
			}else if ( A[round] < B[round]) {
				sumB += 3;
				lastWinner = 'B';
			}
			
			round++;
		}
		
		System.out.println(sumA+" "+sumB);
		if ( draws == 10) {
			System.out.println("D");
			return;
		}
		
		if ( sumA > sumB) {
			System.out.println("A");
		}else if ( sumA < sumB) {
			System.out.println("B");
		}else if ( sumA == sumB) {
			System.out.println(lastWinner);
		}
		
	}
}
