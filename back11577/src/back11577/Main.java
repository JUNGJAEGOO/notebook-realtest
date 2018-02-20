package back11577;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		int cnt = 0;
		for (int i = 0 ; i <= N-K ; i++) {
			
			if ( arr[i] == 1) {
				for (int j = i ; j < i+K ; j++) {
					arr[j] ^= 1;
				}
				cnt++;
			}
			
			/*for (int s = 0 ; s < N ; s++) {
				System.out.print(arr[s]);
			}System.out.println();*/
			
		}
		
		
		
		boolean pass =  true;
		for (int i = 0 ; i < N ; i++) {
			if ( arr[i] == 1) {
				pass = false;
				break;
			}
		}
		
		if ( pass) {
			System.out.println(cnt);
		}else {
			System.out.println("Insomnia");
		}
	}
}
