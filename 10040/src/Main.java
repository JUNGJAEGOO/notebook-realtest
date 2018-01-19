import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in= new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int arr[] = new int[N];
		int simsa[] = new int[M];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		for ( int j = 0 ; j < M ; j++) {
			simsa[j] = in.nextInt();
		}
		int res[] = new int[N];
		int cnt = 0;
		
		for ( int i = 0 ; i < M ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				if ( simsa[i] >= arr[j]) {
					res[j]++;
					break;
				}
			}
		}
		
		int max = 0;
		int maxidx = 0;
		for ( int i = 0 ; i < N ; i++) {
			//System.out.print(res[i]+" ");
			if ( max < res[i]) {
				max = res[i];
				maxidx = i;
			}
		}//System.out.println();
		System.out.println(maxidx+1);
		
	}
}
