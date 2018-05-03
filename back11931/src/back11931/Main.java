package back11931;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int N = in.nextInt();
		
		for ( int i = 0 ; i < N ; i++) {
			list.add(in.nextInt());
		}
		
		Collections.sort(list);
		Collections.reverse(list);
		
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < N ; i++) {
			sb.append(list.get(i)+"\n");
		}
		
		System.out.println(sb);
	}
}
