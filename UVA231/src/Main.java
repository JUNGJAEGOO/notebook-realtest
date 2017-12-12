import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		while ( true ) {
			
			int arr[] = new int[10000];
			int x = in.nextInt();
			if ( x== -1) {
				break;
			}
			int count=0;
			while ( x != -1) {
				
				arr[count] = x;
				x = in.nextInt();
				count++;
			}
			
			int dp[] = new int[count];
			Arrays.fill(dp, 1);
			//dp[0] = 1;
			
			for ( int i = 0 ; i < count ; i++) {
				for ( int j = 0 ; j < i ; j++) {
					if ( arr[i] < arr[j]) {
						dp[i] = Math.max(dp[j]+1, dp[i]);
					}
				}
			}
			
			for ( int i = 0 ; i < count ; i++) {
				System.out.print(dp[i]+" ");
			}System.out.println();
			
		}
	}

}
