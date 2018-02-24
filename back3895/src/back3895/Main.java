package back3895;

import java.util.*;

public class Main {
	public static void main(String args[]) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		while ( true) {
			
			int n = in.nextInt();
			int k = in.nextInt();
			int m = in.nextInt();
			if ( n == 0 && k == 0 && m == 0) {
				break;
			}
			
			
			ArrayList<Integer> q= new ArrayList<>();
			
			for (int i = 1 ; i<= n ; i++) {
				q.add(i);
			}
			q.remove(m-1);
			int idx = m-1;
			while ( q.size() != 1) {
				int size = q.size();
				idx = (idx+k-1) % (size);
				//Thread.sleep(1000);
				//System.out.println(idx+ " "+size);
				//System.out.println(q);
				q.remove(idx);
			}
			
			System.out.println(q.get(0));
		}
	}
}
