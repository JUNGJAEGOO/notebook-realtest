package back1337;

import java.util.*;

public class Main {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		
		ArrayList<Integer> good[] = new ArrayList[10011];
		for ( int i = 0 ; i < 10011 ; i++) {
			good[i] = new ArrayList<>();
		}
		
		int cnt = 0;
		good[cnt].add(arr[0]);
		for ( int i = 1 ; i < N ; i++) {
			if ( arr[i] -1 == arr[i-1]) {
				good[cnt].add(arr[i]);
			}else {
				cnt++;
				good[cnt].add(arr[i]);
			}
		}
		
		int ans = 5;
		for ( int i = 0 ; i < 10011 ; i++) {
			
			if ( good[i].size() >= 5) {
				ans = 0;
			}else {
				ans = Math.min(ans, 5-good[i].size());
			}
		}
		System.out.println(ans);
		
	}
}
